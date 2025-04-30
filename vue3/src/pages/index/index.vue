<template>
	<view>
		<!-- #ifndef APP-HARMONY -->
		<uni-nav-bar :title="title" backgroundColor="#f1f1f1" left-icon="left" @clickLeft="hmBackPress" fixed="true"
			statusBar="true" :border="false"></uni-nav-bar>
		<!-- #endif -->
		<web-view :src="url" style="margin-top: 500rpx;"></web-view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				title: '在线客服',
				jjdm: '',
				url: '',
			}
		},
		onLoad() {
			this.url = 'http://192.168.31.227:5500/vue3/src/static/index.html'
			// this.url = 'https://care60.live800.com/live800/chatClient/chatbox.jsp?companyID=80028932'
		},
		methods: {
			hmBackPress() {}
		}
	}
</script>
<style>
	.box {
		/* position: fixed; */
		position: relative;
		left: 0;
		right: 0;
		background-color: aqua;
		width: 100px;
		height: 100px;
	}
</style>