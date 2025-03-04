<template>
	<view>
		<view>1个参数： {{$t('global.pleaseInput')}}</view>
		<view>2个参数： {{$t('global.pleaseInput', { key: $t('login.tenantName') })}}</view>
	</view>
</template>
<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				console.log("upx", uni.rpx2px(121))
			}
		}
	}
</script>
<style lang="scss">
	.box {
		width: 121rpx;
		height: 121rpx;
		background-color: red;
	}
</style>