<template>
	<view class="box">
		<view class="" v-for="(item,index) in list" :key="index">
			<image :src="item" mode="aspectFill" @click="click(index)"></image>
		</view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				title: 'index',
				list: ['https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250610144702277.png',
					'https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250609172511009.png',
					'https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250606152202354.png',
					'https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250604144729362.png'
				]
			}
		},
		onLoad() {},
		methods: {
			click(index) {
				uni.previewImage({
					urls: this.list,
					current: index
				})
			}
		}
	}
</script>
<style lang="scss">
	.box {
		display: flex;
		flex-direction: column;

		image {
			width: 200rpx;
			height: 200rpx;
			border: 1px solid red;
			margin-left: 15rpx;
		}
	}
</style>