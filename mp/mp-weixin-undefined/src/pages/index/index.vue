<template>
	<view class="content">
		<image class="logo" src="/static/logo.png"></image>
		<view>
			<text class="title">{{ test }}</text>
		</view>
		<button @click="" click>toundefined</button>
	</view>
</template>

<script>
export default {
	data() {
		return {
			test: '123'
		}
	},
	onLoad() {
		this.test = undefined
	},
	methods: {
		toundefined() {
			this.test = undefined
		}
	}
}
</script>

<style>
.content {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
}

.logo {
	height: 200rpx;
	width: 200rpx;
	margin: 200rpx auto 50rpx auto;
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
