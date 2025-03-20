<template>
	<view>
		<button @click="click">click</button>
		<uni-badge text="1"></uni-badge>
		<uni-badge text="2" type="success" @click="bindClick"></uni-badge>
		<uni-badge text="3" type="primary" :inverted="true"></uni-badge>
		<com></com>
	</view>
</template>


<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				uni.chooseImage({
					count: 1,
					sizeType: ['original'],
					sourceType: ['album', 'camera'],
					success: (res) => {
						console.log(res)
						uni.getImageInfo({
							src: res.tempFilePaths[0],
							success: (res) => {
								console.log("图片信息", res)
							}
						})
					}
				})
			}
		}
	}
</script>


<style></style>