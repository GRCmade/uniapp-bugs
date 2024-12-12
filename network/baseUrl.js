//network/baseUrl.js

// ================================================================设置网络请求根路径
let baseUrl = (function() {
	// 请求根路径
	let urlStr = '';
	if (process.env.NODE_ENV === 'development') {
		console.log('开发环境');
		urlStr = 'http://218.245.63.50:9139/capital/m/';
		// #ifdef H5
		// urlStr = 'http://192.168.31/collect/';

		// #endif
		// #ifndef H5
		// urlStr = 'http://192.168.31/collect/';

		// #endif
	} else {
		console.log('生产环境');
		urlStr = 'http://218.245.63.50:9139/capital/m/';
		// #ifdef H5
		// urlStr = 'http://192.168.31/collect/';

		// #endif
		// #ifndef H5
		// urlStr = 'http://192.168.31/collect/';

		// #endif
	}
	return urlStr
})();
// ==================== 图片上传url==========
let uploadImgUrl = (function() {
	let urlStr = '';
	if (process.env.NODE_ENV === 'development') {
		// urlStr = 'http://192.168.31/collect/';

	} else {
		// urlStr = 'http://192.168.31/collect/';

	}
	return urlStr
})();

export default {
	baseUrl,
	uploadImgUrl
}