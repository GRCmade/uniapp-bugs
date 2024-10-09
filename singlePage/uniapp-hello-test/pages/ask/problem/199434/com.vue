<template>
	<view class="">
		<swiper :current="current" @change="change">
			<swiper-item>
				<view class="box">
					<view class="box-header">
						<view class="boxitem" v-for="i,index in textList" :class="{'active':index==0}"
							@click="headerClick(index)">{{i}}</view>
					</view>
					<view class="box-body">{{current}}</view>
				</view>
			</swiper-item>
			<swiper-item>
				<view class="box">
					<view class="box-header">
						<view class="boxitem" v-for="i,index in textList" :class="{'active':index==1}"
							@click="headerClick(index)">{{i}}</view>
					</view>
					<view class="box-body">{{current}}</view>
				</view>
			</swiper-item>
			<swiper-item>
				<view class="box">
					<view class="box-header">
						<view class="boxitem" v-for="i,index in textList" :class="{'active':index==2}"
							@click="headerClick(index)">{{i}}</view>
					</view>
					<view class="box-body">{{current}}</view>
				</view>
			</swiper-item>
			<swiper-item>
				<view class="box">
					<view class="box-header">
						<view class="boxitem" v-for="i,index in textList" :class="{'active':index==3}"
							@click="headerClick(index)">{{i}}</view>
					</view>
					<view class="box-body">{{current}}</view>
				</view>
			</swiper-item>
		</swiper>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello',
				current: 0,
				textList: ["文本文本 1", "文本文本 2", "文本文本 3", "文本文本 4"]
			}
		},
		onLoad() {},
		methods: {
			change(res) {
				
				this.current = res.detail.current
			},
			headerClick(index) {
				
				this.current = index
			}
		}
	}
</script>

<style lang="scss">
	.box {
		// width: 750rpx;
		background-color: #fff;

		.box-body {
			height: 200rpx;
			width: 100%;
		}

		.box-header {
			display: flex;
			justify-content: space-around;

			.boxitem {
				background-color: #f5f5f5;
				color: #333;
				padding: 10rpx 20rpx;
				font-size: 25rpx;
				border-radius: 40rpx;
			}

			.active {
				background-color: $uni-color-primary;
				color: #fff;
			}
		}

	}
</style>