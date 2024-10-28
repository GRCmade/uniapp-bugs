<template>
	<view>
		<view v-for="(it,i) in ls" :key="i">
			<view class="title">{{it.day}}</view>
			<view class="box">
				<view v-for="(item,index) in it.list" :key="index">
					<button @click="click(item)" size="mini" type="primary">{{item}}</button>
				</view>
			</view>
		</view>
		<button @click="click2">click getBatteryCapacity</button>
	</view>
</template>

<script>
	import {
		list
	} from './hellolist';


	export default {
		data() {
			return {
				title: 'Hello',
				ls: list
			}
		},
		onLoad() {},
		methods: {
			click2() {
				// plus.runtime.quit();
			},
			click(id) {
				const prefixPattern = /^docisue/;
				if (prefixPattern.test(id)) {
					const str = `/pages/ask/doc/${id}/${id}`
					console.log(str)
					uni.navigateTo({
						url: str
					})
				} else {
					const str = `/pages/ask/${id}/${id}`
					console.log(str)
					uni.navigateTo({
						url: str
					})
				}

			}
		}
	}
</script>

<style lang="scss">
	.box {
		display: flex;
		width: 100%;
		flex-wrap: wrap;

		button {
			margin: 10rpx;
			font-size: 30rpx;
			font-weight: 700;
			padding: 5rpx 8rpx;
		}
	}

</style>