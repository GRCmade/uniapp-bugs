<template>
	<view>
		<view class="uni-padding-wrap uni-common-mt">
			<view>
				<video id="myVideo" :direction="90" src="https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/2minute-demo.mp4"
					@error="videoErrorCallback" :danmu-list="danmuList" enable-danmu danmu-btn controls></video>
			</view> index-next 页面
		</view>
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
		methods: {
			nav() {
				uni.navigateTo({
					url: "/pages/index/index-next"
				})
			},
			sendDanmu: function() {
				this.videoContext.sendDanmu({
					text: this.danmuValue,
					color: this.getRandomColor()
				})
				this.danmuValue = ''
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