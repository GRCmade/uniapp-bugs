<template>
	<view>
		<button @click="click">click</button>
		<web-view id="webview" style="margin-top: 100rpx;" src="https://ask.dcloud.net.cn/">
			<cover-view>button</cover-view>
		</web-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {}
		},
		onBackPress() {
			console.log("onBackPress")
			// return false
		},
		onLoad() {
			this.$nextTick(()=>{
				this.webviewcontext = uni.createWebviewContext('webview',this)
			})
		},
		methods: {
			click() {
				// uni.navigateTo({
				// 	url:"/pages/second/second"
				// })
				this.webviewcontext.back()
			}
		}
	}
</script>


<style></style>