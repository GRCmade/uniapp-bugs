<template>
	<view>
		<button @click="handleClick">local webview</button>
		<button @click="handleBaidu">handleBaidu</button>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				message: 'Hello, World!'
			}
		},
		methods: {
			handleClick() {
				uni.navigateTo({
					url: "/pages/loacl-webview/loacl-webview"
				})
			},
			handleBaidu() {
				uni.navigateTo({
					url: "/pages/baidu/baidu"
				})
			}
		}
	}
</script>
<style scoped>
</style>