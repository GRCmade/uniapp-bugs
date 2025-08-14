<template>
	<view>
		<button @click="handleClick">Click me</button>
		<button @click="handleClick2">Click to webview</button>
		<button @click="handleClick3">redirect to webview</button>
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
				console.log('Button clicked')
				uni.navigateTo({
					url: "/pages/temp/temp"
				})
			},
			handleClick2() {
				console.log('Button clicked')
				uni.navigateTo({
					url: "/pages/test/test"
				})
			},
			handleClick3() {
				uni.redirectTo({
					url: "/pages/test/test"
				})
			}
		}
	}
</script>
<style scoped>
</style>