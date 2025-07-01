<template>
	<view class="content">
		<!-- 		<image class="logo" src="/static/logo.png"></image>
		<view class="text-area">
			<text class="title">{{ title }}</text>
		</view> -->
		<view class="list-main">
			<com v-if="currentData.type == 1" style="width: 100%"></com>
			<!-- <text v-if="currentData.type == 1"> {{ currentData.text }} </text> -->
			<text v-else-if="currentData.type == 2" style="color: #000;">
				{{ currentData.text }}
			</text>
			<view> currentData.type:{{currentData.type}} </view>
			<view> index:{{index}}</view>
			<view> currentData.type == 1:{{currentData.type == 1}}</view>
		</view>
		<view class="next-btn" @click="next">
			<text>下一题</text>
		</view>
		<view class="next-btn" @click="first">
			<text>第一题</text>
		</view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				title: 'Hello',
				datas: [{
					type: 1,
					text: '组件1'
				}, {
					type: 2,
					text: '组件2'
				}],
				index: 0
			};
		},
		computed: {
			currentData() {
				return this.datas[this.index];
			}
		},
		onLoad() {},
		methods: {
			next() {
				if (this.index < this.datas.length - 1) {
					this.index++;
				}
			},
			first() {
				this.index = 0
			}
		}
	};
</script>
<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		height: 100%;
	}

	.list-main {
		/* flex: 1; */
		width: 100%;
		height: 500px;
		position: relative;
		background-color: red;
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

	.next-btn {
		width: 100%;
		height: 50px;
		display: flex;
		align-items: center;
		justify-content: center;
		background-color: black;
		color: #fff;
		margin-bottom: 30px;
	}
</style>