<template>
	<view class="flex">
		<image src="../../static/logo.png" mode="" class="image"></image>
		<view class="title">hello uniapp</view>
		<button type="primary">退出登录</button>
	</view>
</template>

<script setup>
	
</script>

<style lang="scss">
	.flex{
		display: flex;
		flex-direction: column;
		align-items: center;
		.title{
			margin: 30rpx 0;
		}
	}
	.image{
		width: 300rpx;
		height: 300rpx;
	}
</style>
