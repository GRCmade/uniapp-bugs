//network/api.js文件

import Request from './request.js'
let request = new Request().http
/*
 * 请求样式：
    自定义名字: function(data) {
        return request({
            url: "/banner", //请求头
            method: "GET", //请求方式 
            data: data,    //请求数据
            whetherData: true,  //是否数据格式规范接口
            hideLoading: false, //加载样式
			isRomteServer:false //是否远程地址
        })
    }, 
 */
function get(url, data, whetherData = true, hideLoading, isRomteServer, header) {
	return request({
		url: url,
		method: 'GET',
		data: data,
		header: header,
		whetherData: whetherData,
		isRomteServer: isRomteServer
	})
}

function post(url, data, whetherData = true, hideLoading, isRomteServer, header) {
	return request({
		url: url,
		method: 'POST',
		data: data,
		header: header,
		whetherData: whetherData,
		hideLoading: hideLoading,
		isRomteServer: isRomteServer,
	})
}


let api = {
	//app登录
	login_login: data => post('/login', data, false, false, true),
}

export default api;