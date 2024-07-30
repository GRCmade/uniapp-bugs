<template>
	<view class="content">
		<image class="logo" src="/static/logo.png"></image>
		<view class="text-area">
			<text class="title" @click="click">{{title}}</text>
		</view>
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
		onShow() {
			console.log("onShow")
			uni.setTabBarItem({  
			 index: 0,  
			 text: 'xxx'  
			})  
			// wx.setTabBarItem({
			// 	index: 0,
			// 	text: 'xxx'
			// })
		},

		onHide() {
			console.log("onHide")
			uni.setTabBarItem({  
			 index: 0,  
			 text: '首页'  
			})  
			// wx.setTabBarItem({
			// 	index: 0,
			// 	text: '首页'
			// })

		},
		methods: {
			click() {
				uni.navigateTo({
					url:"/pages/page/page2"
				})
				// console.log("click")
				// uni.getLocation({
				// 	type: 'gcj02', //返回可以用于uni.openLocation的经纬度
				// 	success: function(res) {
				// 		console.log("click", res)
				// 		const latitude = res.latitude;
				// 		const longitude = res.longitude;
				// 		uni.openLocation({
				// 			latitude: latitude,
				// 			longitude: longitude,
				// 			success: function() {
				// 				console.log('success');
				// 			}
				// 		});
				// 	},
				// 	fail(res) {
				// 		console.log("fail", res)
				// 	}
				// });
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