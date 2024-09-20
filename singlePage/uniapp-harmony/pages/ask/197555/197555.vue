<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		methods: {
			click() {
				console.log('click')
				var socketTask = uni.connectSocket({
					url: 'ws://192.168.31.118:8080', //仅为示例，并非真实接口地址。
					success(e) {
						console.log('成功',e)
					},
					fail(e) {
						console.log(e)
					},
					complete(e) {
						console.log('complete', e)
					}
				});
				uni.onSocketOpen(function(res) {
					console.log('WebSocket连接已打开！');
					socketTask.send({
						data: "yuhe",
						success() {
							console.log("send success")
						},
						fail(e) {
							console.log("send fail", e)
						},
						complete(e) {
							console.log('complete', e)
						}
					})
				});

			}
		}
	}
</script>

<style>

</style>