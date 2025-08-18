<template>
	<view>
		<view class="content">
			<image class="logo" src="/static/logo.png"></image>
			<view class="text-area">
				<text class="title">{{ title }}</text>
			</view>
		</view>
		<view class="component-list_item" v-for="item in darkComponentsList">
			<navigator :url="item.url">
				{{ item.title }}
			</navigator>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: '这里是二级页面',
				darkComponentsList: [
					{
						title: 'Button 组件',
						url: '/pages/button/button',
					},
					{
						title: 'Switch 组件',
						url: '/pages/switch/switch',
					},
					{
						title: 'Picker 组件',
						url: '/pages/picker/picker',
					},
					{
						title: 'Picker-view 组件',
						url: '/pages/picker-view/picker-view',
					},
					{
						title: 'Toast 类组件',
						url: '/pages/popup/popup',
					},
				],
			}
		},
		onLoad() {},
		methods: {},
	}
</script>

<style>
	.component-list_item {
		padding: 20rpx;
		border-bottom: 1px solid #999;
	}

	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
