<template>
	<view>
		<button @click="gotoWeb">跳转到webview</button>
	</view>
</template>

<script>
	export default {
		methods: {
			gotoWeb() {
				uni.navigateTo({
					url: '/pages/ask/lubing/main'
				})
			}
		}
	}
</script>

<style>
</style>