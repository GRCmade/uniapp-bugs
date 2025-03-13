<template>
	<view>
		<button @click="chooseImage">chooseImage</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			chooseImage() {
				uni.chooseImage({
					count: 1,
					sizeType: ['original', 'compressed'],
					sourceType: ['album', 'camera'],
				})
			}
		}
	}
</script>

<style>

</style>
