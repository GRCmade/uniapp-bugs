<template>
	<view class="page-body">
		<page-head title="movable-view,可拖动视图"></page-head>
		<view class="uni-padding-wrap uni-common-mt">
			<view class="uni-title uni-common-mt">
				示例 7
				<text>\n可放缩</text>
			</view>
			<movable-area scale-area>
				<movable-view direction="all" @scale="onScale" scale scale-min="0.1" scale-max="4" :scale-value="scale">1：{{scale}}</movable-view>
				<movable-view :x="400" direction="all" @scale="onScale" scale scale-min="0.1" scale-max="4" :scale-value="scale2">2：{{scale2}}</movable-view>
			</movable-area>
			<button @tap="tap2" class="uni-link uni-center uni-common-mt">
				点击这里给1缩小0.5倍
			</button>
			<button @tap="tap3" class="uni-link uni-center uni-common-mt">
				点击这里给2缩小0.1倍
			</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				x: 0,
				y: 0,
				scale: 1,
				scale2: 1,
				old: {
					x: 0,
					y: 0,
					scale: 2
				}
			}
		},
		methods: {
			tap: function(e) {
				// 解决view层不同步的问题
				this.x = this.old.x
				this.y = this.old.y
				this.$nextTick(function() {
					this.x = 30
					this.y = 30
				})
			},
			tap2() {
				// 解决view层不同步的问题
				this.scale = this.old.scale
				this.scale = this.old.scale
				this.$nextTick(function() {
					this.scale = 0.5
				})
			},
			tap3(){
				this.scale2 = this.old.scale
				this.scale2 = this.old.scale
				this.$nextTick(function() {
					this.scale2 = 0.1
				})
			},
			onChange: function(e) {
				this.old.x = e.detail.x
				this.old.y = e.detail.y
			},
			onScale: function(e) {
				// this.old.scale = e.detail.scale
			}
		}
	}
</script>

<style>
	movable-view {
		display: flex;
		align-items: center;
		justify-content: center;
		height: 150rpx;
		width: 150rpx;
		background-color: #007AFF;
		color: #fff;
	}

	movable-area {
		height: 300rpx;
		width: 100%;
		background-color: #D8D8D8;
		overflow: hidden;
	}

	.max {
		width:500rpx;
		height: 500rpx;
	}
</style>