const PopGestureUtil = {
	iOSPopGestureView: undefined,
	/**
	 * @description: 添加iOS侧滑返回功能
	 * @param {String} webview 当前webview
	 **/
	addIOSPopGesture(webview) {
		// #ifdef APP-PLUS
		if (uni.getSystemInfoSync().platform == 'ios') {
			let view = new plus.nativeObj.View('customPopGesture', {
					top: '0px',
					left: '0px',
					width: '15px',
					bottom: '0px',
					color: 'rgba(0,0,0,0)'
				},
				[{
					tag: 'rect',
					id: 'rect',
					color: 'rgba(0,0,0,0)',
				}, ]);
			this.iOSPopGestureView = view;
			// var currentWebview = this.$scope.$getAppWebview() //获取当前页面的webview对象
			var currentWebview = webview //获取当前页面的webview对象
			setTimeout(function() {
				let wv = currentWebview;
				let wvChildren = currentWebview.children();
				if (wvChildren && wvChildren.length > 0) {
					wv = currentWebview.children()[0];
				}
				wv.append(view);
				view.show();
				view.addEventListener('touchend', (e) => {
					let screenX = e.screenX; // 在屏幕中的X坐标
					let screenWidth = uni.getSystemInfoSync().screenWidth;
					console.log(screenWidth, '滑动距离', screenX);
					if (screenX > screenWidth * 0.2) {
						wv.canBack(function(backRes) {
							console.log('是否可返回：' + backRes.canBack);
							if (backRes.canBack) {
								wv.back();
							} else {
								uni.navigateBack({
									delta: 1
								});
							}
						});
					}
				}, false);
			}, 500);
		}
		// #endif
	},
	/**
	 * @description: 移除iOS侧滑返回功能
	 **/
	removeIOSPopGesture() {
		// #ifdef APP-PLUS
		if (uni.getSystemInfoSync().platform == 'ios') {
			if (this.iOSPopGestureView) {
				this.iOSPopGestureView.close();
			}
		}
		// #endif
	},
}

export default PopGestureUtil
