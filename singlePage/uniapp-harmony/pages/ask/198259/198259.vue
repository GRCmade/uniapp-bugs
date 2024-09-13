<template>
	<view>
		<button @click="click">websocket</button>

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
				var coon = uni.connectSocket({
					url: 'ws://localhost:8081',
					success() {
						console.log("success")
					},
					fail() {
						console.log('fail - yuhe')
					}
				});
				coon.onError((e)=>{
					console.log(e, 'IM SDK UNI Error')  
				})
			}
		}
	}
</script>

<style>

</style>