<template>
	<view>
		<button @click="click">button</button>
	</view>
</template>
<script lang="ts" setup>
	import { onMounted, nextTick } from 'vue'
	onMounted(() => {
		console.log("onMounted")
			uni.getSystemInfo({
				success: res => {
					console.log(`windowHeight: ${JSON.stringify(res.windowHeight)}`)
					console.log(`screenHeight: ${JSON.stringify(res.screenHeight)}`)
					// console.log(`navigationBarHeight: ${JSON.stringify(res.navigationBarHeight)}`)
				}
			})
			console.log("onMounted-1")
	})
	const click = () => {
		uni.getSystemInfo({
			success: res => {
				console.log(`windowHeight: ${JSON.stringify(res.windowHeight)}`)
				console.log(`screenHeight: ${JSON.stringify(res.screenHeight)}`)
				// console.log(`navigationBarHeight: ${JSON.stringify(res.navigationBarHeight)}`)
			}
		})
	}
</script>
<style></style>