<template>
	<view> vue 3 小程序 <button @click="handleClick">Click</button>
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
			handleClick() {
				console.log("mp")
			}
		}
	}
</script>
<style scoped>
</style>