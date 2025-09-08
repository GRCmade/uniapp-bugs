<template>
	<view>
		<web-view src="http://192.168.31.218:5178/"></web-view>
	</view>
</template>
<script>
	import PopGestureUtil from '@/uni_modules/ay-pop-gesture/js_sdk/ay-pop-gesture.js';
	export default {
		data() {
			return {}
		},
		onLoad() {
			console.log("PopGestureUtil")
			PopGestureUtil.addIOSPopGesture(this.$scope.$getAppWebview())
		},
		onUnload() {
			// 移除侧滑返回功能
			PopGestureUtil.removeIOSPopGesture();
		},
		methods: {}
	}
</script>
<style>
</style>