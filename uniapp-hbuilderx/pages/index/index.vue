<template>
	<view>
		<button @click="handleClick">Click me</button>
	</view>
</template>
<script setup>
	import { onLoad } from "@dcloudio/uni-app"
	onLoad(() => {
		console.log("rpx", uni.rpx2px(60))
	})
</script>
<style scoped>
</style>