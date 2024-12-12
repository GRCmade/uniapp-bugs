<template>
	<view class="content">
		<web-view update-title ref="myWebView" :src="openUrl"></web-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				openUrl: "",
			}
		},
		onLoad() {
			// yuhe - test
			this.openUrl = 'http://218.245.63.50:9139/capital/goOutmanage/listmPage?catchID=adminyg'
		},
		methods: {

		}
	}
</script>

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