// 云对象教程: https://uniapp.dcloud.net.cn/uniCloud/cloud-obj
// jsdoc语法提示教程：https://ask.dcloud.net.cn/docs/#//ask.dcloud.net.cn/article/129
module.exports = {
	_before: function() { // 通用预处理器

	},
	async getImMessage() {
		const apiUrl = "https://env-00jxgssitq2m.api-hz.cloudbasefunction.cn/functions/invokeFunction"
		const data = {
			"command": {
				"$db": [{
					"$method": "collection",
					"$param": ["uni-im-msg"]
				}, {
					"$method": "where",
					"$param": [{
						"conversation_id": "group_65aa42e5465fe748c837da2b",
						"update_time": {
							"$db": [{
								"$method": "command"
							}, {
								"$method": "lt",
								"$param": [1722327672853]
							}]
						}
					}]
				}, {
					"$method": "limit",
					"$param": [30]
				}, {
					"$method": "orderBy",
					"$param": ["update_time", "desc"]
				}, {
					"$method": "get",
					"$param": []
				}]
			},
			"clientInfo": {
				"PLATFORM": "web",
				"OS": "macos",
				"APPID": "__UNI__DCloud",
				"DEVICEID": "17221929447653190753",
				"scene": 1001,
				"appId": "__UNI__DCloud",
				"appLanguage": "zh-Hans",
				"appName": "DCloud",
				"appVersion": "3.3.0",
				"appVersionCode": 24070101,
				"browserName": "chrome",
				"browserVersion": "127.0.0.0",
				"deviceId": "17221929447653190753",
				"deviceModel": "PC",
				"deviceType": "pc",
				"hostName": "chrome",
				"hostVersion": "127.0.0.0",
				"osName": "macos",
				"osVersion": "10.15.7",
				"ua": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36",
				"uniPlatform": "web",
				"uniRuntimeVersion": "4.23",
				"locale": "zh-Hans",
				"LOCALE": "zh-Hans"
			},
			"uniIdToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1aWQiOiI2NjdjZDg3MDE0OWIxNjRhM2JiMjZkMGYiLCJyb2xlIjpbImRldmVsb3BlciJdLCJwZXJtaXNzaW9uIjpbImJ1Zy1wcm9jZXNzIl0sInVuaUlkVmVyc2lvbiI6IjEuMC4xNiIsImlhdCI6MTcyMjMyMzA1NiwiZXhwIjoxNzI0OTE1MDU2fQ.CXNxVHXxnyPpomc-7Twk16KCyQC2k9pHmTp3ut-o0oE"
		}
		const res = await uniCloud.httpclient.request(apiUrl, {
			method: 'POST',
			data: data,
			contentType: 'json', // 指定以application/json发送data内的数据
			dataType: 'json' // 指定返回值为json格式，自动进行parse
		})
		console.log(res)
	},
	harmony() {
		let data = "hello harmony"
		let obj = {
			code: 0,
			msg: '成功',
			data: data
		}
		return obj
	},
	testRequest() {
		let data = [1, 2, 3, 4, 5]
		return data
	},
	pickerViewTw() {
		let data = [
			[10, 20, 30],
			[100, 200, 300],
			[1000, 2000, 3000]
		]
		return data
	},
	pickerViewTh() {
		let data = [
			[11, 21, 31, 41, 51],
			[122, 222, 322],
			[1333, 2333, 3333]
		]
		return data
	}
	/**
	 * method1方法描述
	 * @param {string} param1 参数1描述
	 * @returns {object} 返回值描述
	 */
	/* 
	method1(param1) {
		// 参数校验，如无参数则不需要
		if (!param1) {
			return {
				errCode: 'PARAM_IS_NULL',
				errMsg: '参数不能为空'
			}
		}
		// 业务逻辑
		
		// 返回结果
		return {
			param1 //请根据实际需要返回值
		}
	}
	*/
}