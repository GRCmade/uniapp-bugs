<template>
	<view>
		<button @click="Iclick">Iclick</button>
		<view v-for="(it,i) in ls" :key="i">
			<view class="title">{{it.day}}</view>
			<view class="box">
				<view v-for="(item,index) in it.list" :key="index">
					<button @click="click(item)" size="mini" type="primary">{{item}}</button>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	import {
		list
	} from './hellolist'
	export default {
		data() {
			return {
				title: 'Hello',
				ls: list
			}
		},
		onShow() {
			// console.log(getCurrentPages())
		},
		onLoad() {
			// uni.setTabBarBadge({
			// 	index: 0,
			// 	text: "1",
			// 	fail(e) {
			// 		uni.showToast({
			// 			title: e.errMsg || e.message,
			// 			icon: "none"
			// 		})
			// 	}
			// })
		},
		onTabItemTap(e) {
			// uni.setTabBarItem({
			// 	index: 0,
			// 	text: 'yuhe',
			// })
			const {
				text
			} = e
			console.log('text', e.text)
		},
		onHide() {
			// setTimeout(()=>{
			// 	uni.setTabBarItem({
			// 		index: 0,
			// 		text: '测试'
			// 	})
			// },0)
			
		},
		methods: {
			Iclick() {
				const a = true
				// uni.switchTab({
				// 	url:"/pages/tabBar/component/component"
				// })
				uni.setTabBarItem({
					index: 1,
					text: '修改2',
				})
			},
			click(id) {
				const prefixPattern = /^docisue/;
				const alphaPattern = /^alpha/;
				if (prefixPattern.test(id)) {
					const str = `/pages/ask/doc/${id}/${id}`
					console.log(str)
					uni.navigateTo({
						url: str
					})
				} else if (alphaPattern.test(id)) {
					const str = `/pages/ask/alpha/${id}/${id}`
					console.log(str)
					uni.navigateTo({
						url: str
					})
				} else {
					const str = `/pages/ask/problem/${id}/${id}`
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
		margin-left: 20rpx;
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>