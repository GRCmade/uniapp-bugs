<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		methods: {
			click() {
				uni.getSystemInfo({
					success: (res) => {
						console.log(JSON.stringify(res))
					}
				});
			}
		}
	}
</script>

<style>

</style>