<template>
	<view>
		<view class="uni-padding-wrap">
			<view class="uni-hello-text">
				延迟加载的理念：页面初始化时，暂不加载处于屏幕可见区域之外的图片。该方案会有如下几大好处：
				<text>\n加快页面渲染速度</text>
				<text>\n提升页面滚动性能</text>
				<text>\n默认不下载屏幕外的图片，减少网络流量</text>
			</view>
		</view>
		<view class="uni-list">
			<view class="uni-list-cell" hover-class="uni-list-cell-hover" v-for="(item,index) in list" :key="index">
				<view class="uni-media-list">
					<view class="uni-media-list-logo">
						<!-- #ifdef MP-ALIPAY -->
						<image class="image" lazy-load :src="item.src" />
						<!-- 非支付宝平台也可以使用lazy-load -->
						<!-- #endif -->
						<!-- #ifndef MP-ALIPAY -->
						<image class="image" :class="{lazy:!item.show}" :data-index="index" @load="imageLoad" :src="item.show?item.src:''" />
						<image class="image placeholder" :class="{loaded:item.loaded}" :src="placeholderSrc" />
						<!-- #endif -->
					</view>
					<view class="uni-media-list-body">
						<view class="uni-media-list-text-top">主标题</view>
						<view class="uni-media-list-text-bottom uni-ellipsis">列表二级标题</view>
					</view>
				</view>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			var imgs = ['shuijiao', 'muwu', 'cbd']
			var list = []

			for (let i = 0; i < 20; i++) {
				list.push({
					src: `https://img-cdn-qiniu.dcloud.net.cn/uniapp/images/${imgs[i%3]}.jpg`,
					show: false,
					loaded: false
				})
			}

			return {
				windowHeight: 0,
				placeholderSrc: '../../static/60x60.png',
				list: list,
				show: false
			}
		},
		// #ifndef MP-ALIPAY
		methods: {
			load() {
				uni.createSelectorQuery().selectAll('.lazy').boundingClientRect((images) => {
					images.forEach((image, index) => {
						console.log(image);
						if (image.top <= this.windowHeight) {
							this.list[image.dataset.index].show = true;
						}
					})
				}).exec()
			},
			imageLoad(e) {
				this.list[e.target.dataset.index].loaded = true
			}
		},
		onLoad() {
			this.windowHeight = uni.getSystemInfoSync().windowHeight
		},
		onShow() {
			if (!this.show) {
				this.show = true
				setTimeout(() => {
					this.load()
				}, 100)
			}
		},
		onPageScroll() {
			this.load()
		}
		// #endif
	}
</script>

<style>
	page {
		background-color: #F4F5F6;
		height: 100%;
		font-size: 14px;
		line-height: 1.8;
	}

	.uni-padding-wrap {
		padding: 0 16px;
	}

	.placeholder {
		opacity: 1;
		transition: opacity 0.4s linear;
	}

	.placeholder.loaded {
		opacity: 0;
	}

	.uni-list {
		background-color: #FFFFFF;
		position: relative;
		width: 100%;
		display: flex;
		flex-direction: column;
	}

	.uni-list:after {
		position: absolute;
		z-index: 10;
		right: 0;
		bottom: 0;
		left: 0;
		height: 1px;
		content: '';
		-webkit-transform: scaleY(.5);
		transform: scaleY(.5);
		background-color: #c8c7cc;
	}

	.uni-list::before {
		position: absolute;
		z-index: 10;
		right: 0;
		top: 0;
		left: 0;
		height: 1px;
		content: '';
		-webkit-transform: scaleY(.5);
		transform: scaleY(.5);
		background-color: #c8c7cc;
	}

	.uni-list-cell {
		position: relative;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
	}

	.uni-list-cell-hover {
		background-color: #eee;
	}

	.uni-list-cell-pd {
		padding: 22rpx 30rpx;
	}

	.uni-list-cell-left {
		font-size: 28rpx;
		padding: 0 30rpx;
	}

	.uni-list-cell-db,
	.uni-list-cell-right {
		flex: 1;
	}

	.uni-list-cell::after {
		position: absolute;
		z-index: 3;
		right: 0;
		bottom: 0;
		left: 30rpx;
		height: 1px;
		content: '';
		-webkit-transform: scaleY(.5);
		transform: scaleY(.5);
		background-color: #c8c7cc;
	}

	.uni-list .uni-list-cell:last-child::after {
		height: 0rpx;
	}

	.uni-list-cell-last.uni-list-cell::after {
		height: 0rpx;
	}

	.uni-list-cell-divider {
		position: relative;
		display: flex;
		color: #999;
		background-color: #f7f7f7;
		padding: 15rpx 20rpx;
	}

	.uni-list-cell-divider::before {
		position: absolute;
		right: 0;
		top: 0;
		left: 0;
		height: 1px;
		content: '';
		-webkit-transform: scaleY(.5);
		transform: scaleY(.5);
		background-color: #c8c7cc;
	}

	.uni-list-cell-divider::after {
		position: absolute;
		right: 0;
		bottom: 0;
		left: 0rpx;
		height: 1px;
		content: '';
		-webkit-transform: scaleY(.5);
		transform: scaleY(.5);
		background-color: #c8c7cc;
	}


	.uni-media-list {
		padding: 22rpx 30rpx;
		box-sizing: border-box;
		display: flex;
		width: 100%;
		flex-direction: row;
	}

	.uni-navigate-right.uni-media-list {
		padding-right: 74rpx;
	}

	.uni-pull-right {
		flex-direction: row-reverse;
	}

	.uni-pull-right>.uni-media-list-logo {
		margin-right: 0rpx;
		margin-left: 20rpx;
	}

	.uni-media-list-logo {
		height: 84rpx;
		width: 84rpx;
		margin-right: 20rpx;
	}

	.uni-media-list-logo image {
		height: 100%;
		width: 100%;
	}

	.uni-media-list-body {
		height: 84rpx;
		display: flex;
		flex: 1;
		flex-direction: column;
		justify-content: space-between;
		align-items: flex-start;
		overflow: hidden;
	}

	.uni-media-list-text-top {
		width: 100%;
		line-height: 36rpx;
		font-size: 30rpx;
	}

	.uni-media-list-text-bottom {
		width: 100%;
		line-height: 30rpx;
		font-size: 26rpx;
		color: #8f8f94;
	}

	.uni-media-list-logo {
		position: relative;
	}

	.uni-media-list-logo .image {
		position: absolute;
	}

	.uni-hello-text {
		padding: 15px 0px;
	}
</style>
