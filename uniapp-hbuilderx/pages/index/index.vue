<template>
	<view>
		<button @click="handleClick('open')">Click me</button>
		<button @click="handleClick">close</button>
	</view>
</template>
<script>
	function onchange(res){
		console.log(res.isConnected);
		console.log(res.networkType);
	}
	export default {
		data() {
			return {
				message: 'Hello, World!'
			}
		},
		methods: {
			handleClick(type) {
				const listener = function(res){
					console.log("onNetworkStatusChange"+JSON.stringify(res))
				};
				if(type == 'open'){
					uni.onNetworkStatusChange(listener);
				}else{
					uni.offNetworkStatusChange(listener);
				}
			},
		}
	}
</script>
<style scoped>
</style>