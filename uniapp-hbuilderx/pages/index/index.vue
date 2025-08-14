<template>
	<view class="content">
		<image class="logo" src="/static/logo.png"></image>
		<view class="text-area">
			<text class="title">Hello Pinia </text>
			<!-- #ifdef WEB -->
			<view class="">
				countStore.count:  {{countStore.count}}
			</view>
			<!-- #endif -->
		</view>
	</view>
</template>

<!-- 这里去掉setup在鸿蒙模拟器就会白屏,需要添加上才可以 -->
<!-- #ifndef APP-HARMONY || APP-PLUS -->
<script>
	import {
		useCountStore
	} from "@/stores/count";
	const countStore = useCountStore()
	console.log("countStore", countStore.count)
</script>
<!-- #endif -->
<!-- #ifdef APP-HARMONY -->
<script setup>
	import {
		useCountStore
	} from "@/stores/count";
	const countStore = useCountStore()
	console.log("countStore", useCountStore)
</script>
<!-- #endif -->
<!-- #ifdef APP-PLUS -->
<script>
	import {
		useCountStore
	} from "@/stores/count";
	const countStore = useCountStore()
	console.log("countStore", useCountStore)
</script>
<!-- #endif -->



<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>