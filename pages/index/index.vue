<template>
	<view>
		<button @click="caniuse">caniuse</button>
		<button @click="getAppBaseInfo">getAppBaseInfo</button>
		<button @click="getWindowInfo">getWindowInfo</button>
		<button @click="getDeviceInfo">getDeviceInfo</button>
		<button @click="getAppAuthorizeSetting">getAppAuthorizeSetting</button>
		<button @click="getSystemInfoSync">getSystemInfoSync</button>
	</view>
</template>


<script>
	export default {
		data() {
			return {}
		},
		methods: {
			caniuse(){
				// console.log(uni.canIUse());
			},
			getAppAuthorizeSetting(){
				console.log(uni.getAppAuthorizeSetting())
			},
			getWindowInfo(){
				console.log(uni.getWindowInfo())
			},
			getDeviceInfo(){
				console.log(uni.getDeviceInfo());
			},
			getAppBaseInfo() {
				console.log(uni.getAppBaseInfo())
			},
			getSystemInfoSync(){
				console.log(uni.getSystemInfoSync())
			}
		}
	}
</script>


<style></style>