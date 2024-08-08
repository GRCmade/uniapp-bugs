<template>
	<view class="container">
		<view class="box"></view>
		<view class="wrap"></view>
	</view>
</template>
<script setup>
	import {
		onMounted,
		ref,
		getCurrentInstance
	} from "vue"
	const instance = ref()
	const observer = ref()
	onMounted(() => {
		instance.value = getCurrentInstance()
		observer.value = uni.createIntersectionObserver(instance.value)
		observer.value
			.relativeTo('.box')
			.observe('.wrap', (res) => {
				console.log('createIntersectionObserver res', res)
			})
	})
</script>
<style lang='scss' scoped>
	.container {
		height: 1000vh;

		.box {
			position: fixed;
			top: 20rpx;
			width: 100%;
			height: 100rpx;
			background: rgba(0, 0, 0, 0.5);
			z-index: 2;
		}

		.wrap {
			width: 200rpx;
			height: 200rpx;
			background: cyan;
			position: sticky;
			top: 0;
			z-index: 3;
		}
	}
</style>