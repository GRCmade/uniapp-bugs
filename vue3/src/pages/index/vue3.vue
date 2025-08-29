<template>
	<view>
		<view>
			<video id="myVideo" src="https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/2minute-demo.mp4"
				@error="videoErrorCallback" :danmu-list="danmuList" enable-danmu danmu-btn controls></video>
		</view>
		<button @click="handleClick">Click me</button>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				src: '',
				danmuList: [{
					text: '第 1s 出现的弹幕',
					color: '#ff0000',
					time: 1
				}, {
					text: '第 3s 出现的弹幕',
					color: '#ff00ff',
					time: 3
				}],
				danmuValue: ''
			}
		},
		onReady: function(res) {
			// #ifndef MP-ALIPAY
			this.videoContext = uni.createVideoContext('myVideo')
			// #endif
		},
		onHide() {
			console.log("onHide")
			this.videoContext.pause()
		},
		methods: {
			handleClick() {
				this.videoContext.pause()
			},
			sendDanmu: function() {
				this.videoContext.sendDanmu({
					text: this.danmuValue,
					color: this.getRandomColor()
				});
				this.danmuValue = '';
			},
			videoErrorCallback: function(e) {
				uni.showModal({
					content: e.target.errMsg,
					showCancel: false
				})
			},
			getRandomColor: function() {
				const rgb = []
				for (let i = 0; i < 3; ++i) {
					let color = Math.floor(Math.random() * 256).toString(16)
					color = color.length == 1 ? '0' + color : color
					rgb.push(color)
				}
				return '#' + rgb.join('')
			}
		}
	}
</script>
<style scoped>
</style>