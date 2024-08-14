<template>
	<view class="content">
		<text>测试1234567890AaBbCcGg</text>
		<text class="test-family">测试1234567890AaBbCcGg</text>
		<text class="two-row">1234567890AaBbCcGg测试</text>
		<text class="two-row test-family">1234567890AaBbCcGg测试</text>
		<text class="two-row test-family">测试1234567890AaBbCcGg</text>
		<text class="two-row test-family">测试纯中文测试纯中文测试纯中文</text>
		<text class="two-row test-family">Test Pure Engligh Test Pure Engligh Test Pure Engligh</text>
	</view>
</template>

<script setup>
	// import {
	// 	onBeforeMount
	// } from 'vue';
	// onBeforeMount(() => {
	// 	const dom = uni.requireNativePlugin('dom')
	// 	dom.addRule('fontFace', {
	// 		'fontFamily': "testfamily",
	// 		'src': "url('https://byte-drama-series.s3.amazonaws.com/font/gordita-regular.otf')"
	// 	});
	// })
</script>

<style>
	/* 在线链接服务仅供平台体验和调试使用，平台不承诺服务的稳定性，企业客户需下载字体包自行发布使用并做好备份。 */
	/* @font-face {
		font-family: 'iconfont';
		src: url('https://byte-drama-series.s3.amazonaws.com/font/gordita-regular.otf');
	} */

	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}


	.two-row {
		height: 48rpx;
		line-height: 24rpx;
		font-size: 24rpx;
		width: 200rpx;
	}

	.test-family {
		font-family: testfamily;
	}
</style>