<template>
	<view class="content">
		<image class="logo" src="/static/logo.png" @click="onCLick"></image>
		<view class="text-area">
			<text class="title">{{title}}</text>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello--tab_2'
			}
		},
		onLoad() {

		},
		methods: {
			onCLick() {
				const ctx = uni.createCanvasContext('at-canvas4');
				console.log("createATImg------------11", ctx);
				ctx.font = "italic bold 20px cursive";
				const metrics = ctx.measureText("Hello World", (res) => {
					console.log("createATImg------------22---ctx.measureText", res);
				});
				console.log("createATImg------------22---ctx.measureText1", metrics);

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