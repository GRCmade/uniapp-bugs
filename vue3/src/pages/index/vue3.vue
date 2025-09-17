<template>
	<view>
		<button @click="handleClick">Click requireNativePlugin('uniMP') </button>
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
				const mp = uni.requireNativePlugin('uniMP');
				console.log("mp",mp)
			}
		}
	}
</script>
<style scoped>
</style>