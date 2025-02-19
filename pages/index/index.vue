<template>
	<view>
		<button @click="click">click</button>
		<web-view style="margin-top: 200rpx;height: 200px;" id="webviewid" src="https://www.baidu.com"></web-view>
	</view>
</template>

<script setup>
	import {
		getCurrentInstance
	} from 'vue'
	const instance = getCurrentInstance()
	const click = () => {
		console.log("click", instance)
		const res = uni.createWebviewContext('webviewid', instance)
		let str = 'console.table("webview-yuhe")'
		res.evalJS(str)
	}
</script>


<style></style>