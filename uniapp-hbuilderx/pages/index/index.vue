<template>
	<view class="content">
		<image class="logo" src="/static/logo.png"></image>
		<view class="text-area">
			<text class="title">{{title}}</text>
			<input @input="onInput"></input>
		</view>
		<button @click="goEval">跳转到插件页面结果页</button>
	</view>
</template>

<script>
	// let plugin = requirePlugin('jxzPlugin');
	export default {
		data() {
			return {
				title: 'Hello',
				biz_no:'223',
				order_no:'223',
				channel_code:'223'
			}
		},
		onLoad() {
			// plugin.init({ face: jd.faceRecognition, env: 'test' })
		},
		onShow(){
			// const result = plugin.getEvalResult()
			// console.log(result, '----result')
		},
		methods: {
			onInput(e){
				console.log(e);
			},
			goEval(){
				jd.navigateTo({
					url: `plugin://jxzPlugin/eval?bizNo=${this.biz_no}&orderNo=${this.order_no}&channelCode=${this.channel_code}`,
				})
			}
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
