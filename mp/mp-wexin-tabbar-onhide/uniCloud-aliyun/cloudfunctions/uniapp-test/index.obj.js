// 云对象教程: https://uniapp.dcloud.net.cn/uniCloud/cloud-obj
// jsdoc语法提示教程：https://ask.dcloud.net.cn/docs/#//ask.dcloud.net.cn/article/129
module.exports = {
	_before: function () { // 通用预处理器

	},
	harmony(){
		let data = "hello harmony"
		let obj = {
			code:0,
			msg:'成功',
			data:data
		}
		return obj
	},
	testRequest(){
		let data = [1,2,3,4,5]
		return data
	},
	pickerViewTw(){
		let data = [
			[10,20,30],
			[100,200,300],
			[1000,2000,3000]
		]
		return data
	},
	pickerViewTh(){
		let data = [
			[11,21,31,41,51],
			[122,222,322],
			[1333,2333,3333]
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
