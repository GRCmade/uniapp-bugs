<template>
	<view>
		<button @click="handleClick">getLocation</button>
	</view>
</template>
<script>
	// #ifdef APP-HARMONY
	import "@/uni_modules/harmony-permissions"
	// #endif
	export default {
		data() {
			return {
				message: 'Hello, World!'
			}
		},
		methods: {
			handleClick() {
				uni.getLocation({
					success(res) {
						console.log("success", res);
					},
					fail(res) {
						console.log("fail", res);
					}
				})
			}
		}
	}
</script>
<style scoped>
</style>