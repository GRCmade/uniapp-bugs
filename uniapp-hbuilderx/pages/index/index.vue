<template>
	<view class="">
		<button @click="click">click</button>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				title: 'index',
				data: ''
			}
		},
		onLoad() {},
		methods: {
			click() {
				uni.previewImage({
					urls: ['https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250609172511009.png']
				})
			}
		}
	}
</script>