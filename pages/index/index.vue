<template>
	<view>
		<button @click="click">click</button>
		<web-view style="margin-top: 200rpx;height: 200px;" id="webviewid" src="https://www.baidu.com"></web-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				const res = uni.createWebviewContext('webviewid',this)
				let str = 'console.table("webview-yuhe")'
				res.evalJS(str)
			},
			log(){
				
			}
		}
	}
</script>


<style></style>