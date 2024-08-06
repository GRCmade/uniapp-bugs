<template>

	<scroll-view scroll-y="true" class="scroll-box">
		<view class="bug-page-card" v-for="(item,index) in list" :key="index">

			<image :src="item.img" mode=""></image>

		</view>

	</scroll-view>

	</view>
</template>

<script>
	export default {

		data() {
			return {

				list: [

					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},
					{
						img: '/static/logo.png'
					},

				]

			}

		}

	}
</script>

<style lang="scss" scoped>
	.scroll-box {
		width: 100%;
		height: 100vh;

	}

	/deep/.uni-scroll-view-content {
		display: flex;
		flex-wrap: wrap;
		align-items: center;
		justify-content: center;
	}

	.bug-page-card {

		width: 350rpx;
		height: 450rpx;

		image {
			width: 100%;
			height: 100%;
			filter: blur(30rpx);
			// filter: drop-shadow(16px 16px 20px blue);
		}

	}

	.bug-page {
		width: 100%;
		height: 100%;

	}
</style>