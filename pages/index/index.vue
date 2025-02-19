<template>
	<view class="content">
		<image class="logo" src="/static/logo.png" @click="onCLick"></image>
		<button @click="click">click</button>
		<view class="text-area">
			<text class="title">{{title}}</text>
		</view>
		<canvas id="at-canvas"></canvas>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello'
			}
		},
		onLoad() {

		},
		methods: {
			click(){
				const ctx = uni.createCanvasContext('at-canvas');
				console.log("createATImg------------11", ctx);
				ctx.font = "italic bold 20px cursive";
				const metrics = ctx.measureText("Hello World", (res) => {
					console.log("createATImg------------22---ctx.measureText", res);
				});
				console.log("createATImg------------22---ctx.measureText1", metrics);
			},
			onCLick() {
				uni.switchTab({
					url: "/pages/index/index3",
				});
				// uni.navigateTo({
				// 	url: '/pages/index/index3',
				// 	success(res) {
				// 		console.log(res)
				// 	},
				// 	fail(res) {
				// 		console.log(res)
				// 	}
				// })


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