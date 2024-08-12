<template>
	<view>
		<button @click="login">login</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		onLoad() {
			

		},
		methods: {
			login(){
				uni.login({
					provider:"weixin",
				  success: function (loginRes) {
				    console.log(loginRes);
				  }
				});
			}
		}
	}
</script>

<style>

</style>
