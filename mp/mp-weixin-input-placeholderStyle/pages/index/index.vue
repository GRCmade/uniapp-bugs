<template>
	<view class="content">
		<image class="logo" src="/static/logo.png"></image>
		<view class="text-area">
			<text class="title" @click="click">{{title}}</text>
		</view>
		<view class="title" @click="yuheClick">
			yuhe
		</view>
		<input placeholder-style="color:#FFFFFF" type="text" placeholder="请输入订单号"></input>
	</view>
</template>

<script>
	function test() {
		console.log("test")
	}
	export default {
		data() {
			return {
				title: 'Hello',
				input: 0,
				inputNo: '',
				lastInputTime: '',
				showWidht: true
			}
		},
		onLoad() {
			// console.log("onload", this.$tools)
			test()
			// const appAuthorizeSetting = uni.getAppAuthorizeSetting()
			
			// console.log("appAuthorizeSetting", appAuthorizeSetting)
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
			setTimeout(() => {
				uni.setTabBarItem({
					index: 0,
					text: '首页'
				})
			}, 100)
		},
		methods: {
			yuheClick(){
				plus.runtime.launchApplication({
					action: 'App-Prefs:root=Privacy&path=CAMERA'
				}, function(e) {
					console.log(JSON.stringify(e));
				});
			},
			inputchange() {
				let currentTime = Date.now(); // 当前时间戳
				if (this.lastInputTime) {
					// 如果存在上一次输入时间，则计算时间差
					let interval = currentTime - this.lastInputTime;
					console.log(interval)
					if (interval > this.inputIntervalThreshold) {
						this.inputNo = ' '
						uni.showToast({
							title: '请扫描会员码或刷卡录入',
							icon: 'none'
						})
						return
					}
				}
				// 更新上一次输入时间
				this.lastInputTime = currentTime;
			},
			click() {
				uni.chooseImage({
					count: 6, //默认9
					sourceType: ['album', 'camera'], //从相册选择
					success: function(res) {
						console.log(JSON.stringify(res.tempFilePaths));
					},
					fail(e) {
						console.log(e)
					}
				});
			}
		}
	}
</script>

<style lang="scss">
	page{
		background-color: $uni-border-color;
	}
	.controls-play {
		width: 100rpx;
		height: 100rpx;
	}

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