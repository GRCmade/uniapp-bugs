<template>
	<view>
		<button @click="click">click2</button>
	</view>
</template>


<script>
	export default {
		data() {
			return {}
		},
		onReady() {
			const res = uni.getWindowInfo()
			console.log(JSON.stringify(res))
		},
		methods: {
			click() {
				const res = uni.getWindowInfo()
				console.log(JSON.stringify(res))
			}
		}
	}
</script>


<style></style>