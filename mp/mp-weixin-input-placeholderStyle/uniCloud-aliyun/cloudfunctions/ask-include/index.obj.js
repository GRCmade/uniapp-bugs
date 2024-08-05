// 云对象教程: https://uniapp.dcloud.net.cn/uniCloud/cloud-obj
// jsdoc语法提示教程：https://ask.dcloud.net.cn/docs/#//ask.dcloud.net.cn/article/129
const cheerio = require('cheerio');
const {
	url
} = require('inspector');
const cookie =
	'__uni__uid=rBEQJmajueg6376PKlZ2Ag==; email=gaoruicheng@dcloud.io; iqx__user_login=5OPK1tXkxM7XwMeZvbfe3uXJw8vErMDr19LTmq-f39HY1-3l1cXQv5Wh29Win6Odya_YxcKmkqGj3KenpdGexqumm8amls6lrZWtnOXOyNTTjpOokqOmq6yTqp26pdTTjq7h3NPa5dWhpJ6VhJ7DxMTb0N7d7Nytj7nT2Nvig67TxYq9zJTKj6GVw6erwpibgqve6eDXxtXHr9_qkpalmZihr5Sauri5scKig83bzc-OwNnV2t-OhLne1dDfx5mfq6ugn56VkqaWtsLYw9zXqKmlpp6Ymg..; iqx__Session=mucdqlgjt34b0v1luov8pb1j11; Hm_lvt_1aa4e79e9d9a938cfe5605a1d0269239=1722243763,1722306736,1722325451,1722390018; HMACCOUNT=6AD7DF210D66750D; Hm_lpvt_1aa4e79e9d9a938cfe5605a1d0269239=1722426398'
// 网络请求
async function netRequest(url) {
	const res = await uniCloud.request({
		url: url,
		sslVerify: false,
		dataType: "String",
		header: {
			'user-agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3877.400 QQBrowser/10.8.4507.400',
			'cookie': cookie
		}
	})
	return res
}
/** 获取文章中评论的用户
 * @param {Object} url
 * [{
	"id": 2609828,
	"name": "DCloud_UNI_yuhe",
	"count": 242
	}]
 * 
 */
async function getArticleUser(url) {
	const res = await netRequest(url)
	const $ = cheerio.load(res.data)
	$('.aw-invite-box').remove();
	// 创建一个空对象来存储每个 ID 及其出现的次数
	const idCounts = {};
	$('a.aw-user-name').each((index, element) => {
		const dataId = $(element).attr('data-id');
		if (dataId) {
			if (idCounts[dataId]) {
				idCounts[dataId].count++;
			} else {
				const str = $(element).attr('href').split('/');
				let dstr = decodeURIComponent(str[str.length - 1])
				idCounts[dataId] = {
					count: 1,
					name: dstr
				};
			}
		}
	});
	const result = Object.entries(idCounts).map(([id, {
		count,
		name
	}]) => ({
		id: Number(id),
		name,
		count
	}));
	for (var i = 0; i < result.length; i++) {
		result[i].email = await getUserEmail(result[i].id)
	}
	return result.sort((a, b) => b.count - a.count)
}

// 获取用户的email
async function getUserEmail(peopleid) {
	const url = `https://ask.dcloud.net.cn/people/${peopleid}`
	const res = await netRequest(url)
	const $ = cheerio.load(res.data)
	let email = 'not found'
	const element = $('.aw-mod-head h1 span').first()
	if ($(element).text()) {
		email = $(element).text().match(/[\w.-]+@[\w.-]+\.\w+/)[0]
	}
	return email
}

// 数据转为excel
async function data2excel(data) {
	var xlsx = require('node-xlsx');
	const fs = require('fs');
	// 需要写入excel的数据，通常可能是从数据库中查询获得，这里为演示，使用本地数据
	let buffer = xlsx.build(data);
	let fileName = '导出结果_' + new Date().getTime() + '.xlsx' //导出文件名
	//上传文件到云存储
	let uploadRes = await uniCloud.uploadFile({
		cloudPath: fileName,
		fileContent: buffer
	})
	return uploadRes
}

async function getMyAsk(people='2609828'){
	function getPage(page){
		const url =
			`https://ask.dcloud.net.cn/people/ajax/user_actions/uid-${people}__actions-101,%20201,%20105,%20204,%20401,%20406,%20501,%20502__page-${page}`
		return url
	}
	function isWithin7Days(dateString) {
	  // 解析给定的日期字符串
	  const givenDate = new Date(dateString);
	
	  // 获取当前日期
	  const currentDate = new Date();
	
	  // 计算当前日期的7天前的日期
	  const sevenDaysAgo = new Date();
	  sevenDaysAgo.setDate(currentDate.getDate() - 7);
	
	  // 比较给定日期和当前日期的7天前的日期
	  return givenDate >= sevenDaysAgo && givenDate <= currentDate;
	}
	let ls = []
	let symbol = true
	let page = 0
	while(symbol){
		const res = await netRequest(getPage(page))
		const $ = cheerio.load(res.data)
		if($('p').length > 0){
			$('p').each((index, element) => {
				let checktime = $(element).find('span').text()
				let obj = {
					url: $(element).find('.aw-hide-txt').attr('href'),
					time: checktime,
					name:$(element).find('.aw-hide-txt').text()
				}
				if(isWithin7Days(checktime)){
					ls.push(obj)
				}else{
					symbol = false
				}
			})
			page++
		}else{
			symbol = false
			break
		}
	}
	function removeDuplicatesByUrl(list) {
	  const seenUrls = new Set();
	  return list.filter(item => {
	    if (seenUrls.has(item.url)) {
	      return false;
	    } else {
	      seenUrls.add(item.url);
	      return true;
	    }
	  });
	}
	return removeDuplicatesByUrl(ls)
}

module.exports = {
	_before: function() { // 通用预处理器

	},
	async test() {
		let my_ask_list = await getMyAsk()
		let ask_list = my_ask_list.map((item)=>"https:"+item.url)
		console.log(my_ask_list)
		console.log(ask_list.length)
		let allData = []
		for (var i = 0; i < ask_list.length; i++) {
			let data = await getArticleUser(ask_list[i])
			allData.push(data)
		}
		const mergedCounts = allData.flat().reduce((acc, {
			id,
			name,
			count,
			email
		}) => {
			if (!acc[id]) {
				acc[id] = {
					id,
					name,
					count: 0,
					email
				};
			}
			acc[id].count += count;
			return acc;
		}, {});
		console.log("allData",allData)
		var result = Object.values(mergedCounts).sort((a, b) => b.count - a.count);
		return result
	},
	async getChooseLocationUserInfo() {
		function mergeList(result) {
			var ls = []
			result.forEach((item) => {
				let obj = []
				obj.push(item.id)
				obj.push(item.name)
				obj.push(item.count)
				obj.push(item.email)
				ls.push(obj)
			})
			var title = ['id', '名称', '评论数量', '邮箱']
			ls.unshift(title)
			return ls
		}
		const locationList = [
			'https://ask.dcloud.net.cn/question/195066',
			'https://ask.dcloud.net.cn/question/195113',
			'https://ask.dcloud.net.cn/question/169718',
			'https://ask.dcloud.net.cn/question/195803',
			'https://ask.dcloud.net.cn/question/195758',
			'https://ask.dcloud.net.cn/question/152891',
			'https://ask.dcloud.net.cn/question/193832',
			'https://ask.dcloud.net.cn/question/195720',
			'https://ask.dcloud.net.cn/question/195763',
			'https://ask.dcloud.net.cn/question/193319',
			'https://ask.dcloud.net.cn/question/195627',
			'https://ask.dcloud.net.cn/question/195638',
			'https://ask.dcloud.net.cn/question/195636',
			'https://ask.dcloud.net.cn/question/195568',
			'https://ask.dcloud.net.cn/question/195570',
			'https://ask.dcloud.net.cn/question/195554',
			'https://ask.dcloud.net.cn/article/41203',
			'https://ask.dcloud.net.cn/question/191725',
			'https://ask.dcloud.net.cn/question/195523',
			'https://ask.dcloud.net.cn/question/173443',
			'https://ask.dcloud.net.cn/question/145476',
			'https://ask.dcloud.net.cn/question/193710',
			'https://ask.dcloud.net.cn/question/193137'
		]
		let allData = []
		for (var i = 0; i < locationList.length; i++) {
			let data = await getArticleUser(locationList[i])
			allData.push(data)
		}
		const mergedCounts = allData.flat().reduce((acc, {
			id,
			name,
			count,
			email
		}) => {
			if (!acc[id]) {
				acc[id] = {
					id,
					name,
					count: 0,
					email
				};
			}
			acc[id].count += count;
			return acc;
		}, {});
		// console.log("allData",allData)
		var data = []
		var result = Object.values(mergedCounts).sort((a, b) => b.count - a.count);
		var dateItem = {
			name: '总',
			data: mergeList(result)
		}
		data.push(dateItem)
		// 分页数据
		for (var i = 0; i < locationList.length; i++) {
			let lsItem = []
			var strList = locationList[i].split('/')
			dateItem = {
				name: strList[strList.length - 1],
				data: mergeList(allData[i])
			}
			data.push(dateItem)
		}
		const excel = await data2excel(data)
		return {
			"excelUrl": excel.fileID,
			"excelData": data
		}
	}
}