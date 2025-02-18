<template>
	<view>
		<button @click="click">click</button>
		<button @click="getAppAuthorizeSetting">getAppAuthorizeSetting</button>
		<canvas canvas-id="myCanvas"></canvas>
	</view>
</template>


<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				uni.scanCode({
					success: function(res) {
						console.log('条码类型:' + res.scanType);
						console.log('条码内容:' + res.result);
					}
				});
			},
			getAppAuthorizeSetting(){
				const appAuthorizeSetting = uni.getAppAuthorizeSetting()
				console.log(appAuthorizeSetting)
			}
		}
	}
</script>


<style></style>