<template>
	<view>
		<view class="box">
			<view class="box-input">
				<input type="text" placeholder="请输入" />
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style>
	.box{
		width: 100%;
		height: 2000rpx;
		background-color: aqua;
		display: flex;
		justify-content: center;
		align-items: center;
		.box-input{
			width: 500rpx;
			height: 500rpx;
			background-color: red;
		}
	}
</style>
