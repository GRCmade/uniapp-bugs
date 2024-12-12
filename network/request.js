//network/request.js文件

import base from './baseUrl.js'
import api from "@/network/api.js"

export default class Request {
	http(param) {
		// 请求参数
		let url = param.url;
		let method = param.method;
		let header = param.header || {};
		let data = Object.assign(param.data || {});
		let hideLoading = param.hideLoading || false;
		let whetherData = param.whetherData;
		let isRomteServer = param.isRomteServer;
		//拼接完整请求地址
		let requestUrl = base.baseUrl + url;
		console.log(requestUrl);

		//请求方式:GET或POST(POST需配置
		// header: {'content-type' : "application/x-www-form-urlencoded"},)
		if (method) {
			method = method.toUpperCase(); //小写改为大写
			if (method == "POST") {
				header = Object.assign({
					// 'content-type': "application/x-www-form-urlencoded"
					'content-type': "application/json"
				}, param.header, {
					saToken: uni.getStorageSync("user").saToken ? uni.getStorageSync("user").saToken : ''
				})
			} else {
				header = Object.assign({
					'content-type': "application/json"
				}, param.header, {
					saToken: uni.getStorageSync("user").saToken ? uni.getStorageSync("user").saToken : ''
				})
			}
		}
		//加载圈
		if (!hideLoading) {
			uni.showLoading({
				mask: true
			})
		}
		// 返回promise
		return new Promise((resolve, reject) => {
			// 请求
			uni.request({
				url: requestUrl,
				data: data,
				method: method,
				header: header,
				success: (res) => {
					//如果是开发环境，则打印返回参数
					if (process.env.NODE_ENV === 'development') {
						console.log('请求成功' + requestUrl, JSON.stringify(res.data));
					}

					//隐藏加载
					if (!hideLoading) {
						uni.hideLoading();
					}
					// 判断 请求是否成功 
					if (res.statusCode == 200) {
						//判断  接口返回列表中是否存在 data 列表 （因为接口不统一所以从这里判断 promise返回什么数据）
						// if (whetherData) {
						// 	// code判断:1成功,不等于1错误
						// 	if (res.data.code == 1) {
						// 		//成功            
						// 		resolve(res.data)
						// 		return true;
						// 	} else {
						// 		if (res.data.code == 2 || res.data.code == 10015) {
						// 			uni.removeStorageSync("user")
						// 			// #ifndef MP-WEIXIN
						// 			uni.navigateTo({
						// 				url: '/pages/login/login'
						// 			})
						// 			// #endif
						// 			// #ifdef MP-WEIXIN
						// 			// toast('请前往登录')
						// 			uni.switchTab({
						// 				url: '/pages/login/login'
						// 			})
						// 			// #endif
						// 		}
						// 		// console.log("错误", res.data);
						// 		uni.showToast({
						// 			title: res.data.msg,
						// 			icon: 'none'
						// 		})
						// 		return false;
						// 	}
						// } else {
						// 	console.log('不判断', res.data);
						// 	resolve(res.data);
						// 	return true;
						// }
						if (res.data.code === "401") {
							//401为登录信息过期，跳转到登录页面重新登录
							// api.login_logout().then(res => {

							// });
							uni.setStorageSync("badgeNum", 0);
							// #ifdef APP-PLUS
							plus.runtime.setBadgeNumber(0);
							// #endif
							// #ifdef APP-HARMONY
							uni.setBadgeNumber(0)
							// #endif
							uni.removeStorageSync("user");
							uni.setStorageSync("autoBiometric", "yes");
							uni.reLaunch({
								url: "/pages/login/login"
							});
						} else {
							resolve(res.data);
							return true;
						}
					} else {
						return false;
					}
				},
				//请求失败
				fail: (err) => {
					if (process.env.NODE_ENV === 'development') {
						console.log('请求失败 ' + requestUrl, JSON.stringify(err));
					}
					//隐藏加载
					if (!hideLoading) {
						uni.hideLoading();
					}
					uni.showToast({
						title: "数据请求异常，请重新进入此页面！",
						icon: "none"
					})
					resolve(false);
					return false;
				},
				//请求完成
				complete() {
					return;
				}
			})
		})
	}
}