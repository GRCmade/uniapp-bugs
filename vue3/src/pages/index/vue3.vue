<template>
	<view> vue 3 小程序 <button @click="sendHostEvent">sendHostEvent</button>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				message: 'Hello, World!'
			}
		},
		methods: {
			sendHostEvent() {
				uni.sendNativeEvent("test", "yuhe", (ret) => {
					//发送消息成功回调
					console.log("来自项目 vue3")
					console.log('Send event to Host: ' + JSON.stringify(ret));
				});
			},
		}
	}
</script>
<style scoped>
</style>