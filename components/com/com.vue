<template>
	<view>
		<view class="box" @touchstart="touchstart" @touchmove="touchmove"></view>
	</view>
</template>

<script>
	export default {
		name:"com",
		data() {
			return {
				touchstart(){
					console.log("touchs");
				},
				touchmove(){
					console.log("touchm");
				},
			};
		}
	}
</script>

<style>
	.box{
		width: 600rpx;
		height: 500rpx;
		background-color: #36d;
	}
</style>