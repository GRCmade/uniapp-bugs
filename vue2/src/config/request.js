// 此vm参数为页面的实例，可以通过它引用vuex中的变量
module.exports = (vm) => {
    // 初始化请求配置
	let vuex_http = vm.vuex_http
    uni.$u.http.setConfig((config) => {
        /* config 为默认全局配置*/
        config.baseURL = vuex_http; /* 根域名 */
		config.method= 'POST';
		// 设置为json，返回后会对数据进行一次JSON.parse()
		config.dataType= 'json';
		config.showLoading= true; // 是否显示请求中的loading
		config.loadingText= '请求中...'; // 请求loading中的文字提示
		config.loadingTime= 800; // 在此时间内，请求还没回来的话，就显示加载中动画，单位ms
		config.originalData= true; // 是否在拦截器中返回服务端的原始数据
		config.loadingMask= true; // 展示loading的时候，是否给一个透明的蒙层，防止触摸穿透
        config.custom.auth = true; // 是否添加token
        return config
    })
	uni.$u.post=(url,params) => {
		return uni.$u.http.post(url,params)
	}
	uni.$u.get=(url,params) => {
		return uni.$u.http.get(url, {
            params: params,
            header: { 'content-type': 'application/x-www-form-urlencoded;charset=utf-8'}
        })
	}
	uni.$u.postQuery = (url,params) => {
		return uni.$u.http.post(url,params, {
			header: { 'content-type': 'application/x-www-form-urlencoded'}
		})
	}
	uni.$u.postJSON = (url,params,header) => {
		let h = header || {}
		h['content-type'] = 'application/json;charset=UTF-8'
		return uni.$u.http.post(url,params,{ header: h })
	}
	uni.$u.postFormData = (url,params,header) => {
		let h = header || {}
		h['content-type'] = 'application/form-data;charset=UTF-8'
		return uni.$u.http.post(url,params,{ header: h })
	}
	//有file的提交方式
	uni.$u.postFile = ({url, name, params, files, header}) => {
		let h = header || {}
		h['token'] = vm.vuex_token
		if(true){
			return new Promise((resolve, reject)=>{
				uni.uploadFile({
					url: vuex_http + url,
					filePath: files,
					name: name || 'file',
					formData: params,
					header: h,
					success: (uploadFileRes) => {
						if(uploadFileRes.statusCode == 200){
							uploadFileRes.data = JSON.parse(uploadFileRes.data)
						}
						resolve(uploadFileRes.data)
					},
					fail: (error) => {
						console.error(error);
						reject(error);
					}
				});
			}) 
		}
	}
	// 请求拦截
	uni.$u.http.interceptors.request.use((config) => { // 可使用async await 做异步操作
	    // 初始化请求拦截器时，会执行此方法，此时data为undefined，赋予默认{}
	    config.data = config.data || {}
		// 根据custom参数中配置的是否需要token，添加对应的请求头
		if(config?.custom?.auth) {
			// 可以在此通过vm引用vuex中的变量，具体值在vm.$store.state中
			config.header.token = vm.vuex_token;
		}
	    return config 
	}, config => { // 可使用async await 做异步操作
	    return Promise.reject(config)
	})
	
	// 响应拦截
	uni.$u.http.interceptors.response.use((response) => { /* 对响应成功做点什么 可使用async await 做异步操作*/
		if(response.statusCode == 200){
			let res = response.data
			if(res.code == 200) {
				// res为服务端返回值，可能有code，result等字段
				// 这里对res.result进行返回，将会在this.$u.post(url).then(res => {})的then回调中的res的到
				// 如果配置了originalData为true，请留意这里的返回值
				return res;
			} else if(res.code == 401) {
				// 假设401为token失效，这里跳转登录
				vm.$u.toast('验证失败，请重新登录');
				setTimeout(() => {
					// 此为uView的方法，详见路由相关文档
					vm.$u.route('/pages/login/login')
				}, 1500)
				return false;
			} else if(res.code == 'NF501') {
                // 此为uView的方法，详见路由相关文档
                uni.reLaunch({ url: '/pages/login/login' })
				return false;
            } else {
				vm.$u.toast(res.data || res.message);
				// 如果返回false，则会调用Promise的reject回调，
				// 并将进入this.$u.post(url).then().catch(res=>{})的catch回调中，res为服务端的返回值
				return false;
			}
		}else{
			if(response.statusCode == 505){
				vm.$u.toast("服务器正在维护，请稍后再购买");
				return false
			}else{
				vm.$u.toast("系统发生未知错误");
				return false
			}
			
		}
	}, (response) => { 
		// 对响应错误做点什么 （statusCode !== 200）
		return Promise.reject(response)
	})
}