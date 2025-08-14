<template>
	<view> temp <button @click="click">temp</button>
	</view>
</template>
<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				uni.navigateTo({
					url: "/pages/test/test"
				})
			}
		}
	}
</script>
<style>
</style>