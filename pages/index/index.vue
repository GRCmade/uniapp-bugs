<template>
	<view>
		<button @click="click">click</button>
		<button @click="click2">url file</button>
	</view>
</template>
<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				uni.downloadFile({
					url: 'http://192.168.31.148:3000/download/header', //仅为示例，并非真实的资源
					success: (res) => {
						console.log(res);
					}
				});
			},
			click2() {
				uni.downloadFile({
					url: 'http://192.168.31.148:3000/file/uni-app.pdf', //仅为示例，并非真实的资源
					success: (res) => {
						console.log(res);
					}
				});
			}
		}
	}
</script>
<style></style>