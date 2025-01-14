<template>
	<view>
		<button @click="click">click</button>
		<web-view src="http://192.168.31.148:5173/web/newd#/"></web-view>
		<!-- <web-view src="http://192.168.31.148:8080/web/newd#/"></web-view> -->
	</view>
</template>


<script>
	export default {
		data() {
			return {}
		},
		onPullDownRefresh() {
			console.log("onPullDownRefresh")
			uni.stopPullDownRefresh()
		},
		methods: {
			click() {
				
			}
		}
	}
</script>


<style></style>