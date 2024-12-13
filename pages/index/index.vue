<template>
	<view>
		<view v-for="(item,index) in ls" :key="index">
			<button @click="click(item)">{{item}}</button>
			<image :src="item" mode="aspectFit"></image>
		</view>
	</view>
</template>


<script>
	export default {
		data() {
			return {
				ls: ["/static/1..png", "static/2..png", "./static/3..png", "../static/4..png", "../../static/5..png","6..png","/static/err.png"]
			}
		},
		methods: {
			click(item) {
				uni.setTabBarItem({
					index: 1,
					text: 'yuhe',
					// iconPath: '/static/tabbar/1.png',
					iconPath: item,
					selectedIconPath: '/static/tabbar/11.png'
				})
			},
		}
	}
</script>


<style>
	image {
		width: 50px;
		height: 50px;
	}
</style>