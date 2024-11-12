<template>
	<view>
		<web-view src="http://192.168.31.148:5500/index.html"></web-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		onLoad() {
			console.log(uni.getWindowInfo().statusBarHeight);
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
