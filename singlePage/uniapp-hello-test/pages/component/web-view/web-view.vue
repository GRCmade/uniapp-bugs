<template>
	<view>
		<web-view :src="url" @message="getMessage"></web-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				url: 'http://localhost:5173/hybrid/html/local.html'
				// url: 'https://uniapp.dcloud.io/static/web-view.html'
				// url:'https://dcloud.yuhe.space/test.html'
			}
		},
		onLoad(options) {
			// if (options && options.url) {
			// 	this.url = options.url;
			// }
		},
		methods: {
			getMessage(event) {
				console.log(event)
				uni.showModal({
					content: JSON.stringify(event.detail),
					showCancel: false
				});
			}
		}
	}
</script>

<style>

</style>
