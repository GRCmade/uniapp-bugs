<template>
	<view class="page-body">
		<page-head title="movable-view,可拖动视图"></page-head>
		<view class="uni-padding-wrap uni-common-mt">
			<view class="uni-title uni-common-mt">
				示例 7
				<text>\n可放缩</text>
			</view>
			<movable-area scale-area>
				<movable-view direction="all" @scale="onScale" scale :scale-value="scale">1：{{scale}}</movable-view>
				<movable-view :x="400" direction="all" @scale="onScale" scale :scale-value="scale2">2：{{scale2}}</movable-view>
				<movable-view :x="200" direction="all" @scale="onScale" scale :scale-min="0.3"
					:scale-value="scale3">3：不能设为0.1</movable-view>
			</movable-area>
			<button @tap="tap1(0.5)" class="uni-link uni-center uni-common-mt">
				点击这里给1 0.5倍
			</button>
			<button @tap="tap1(3)" class="uni-link uni-center uni-common-mt">
				点击这里给1 3倍
			</button>
			<button @tap="tap2(0.1)" class="uni-link uni-center uni-common-mt">
				点击这里给2 0.1倍
			</button>
			<button @tap="tap2(10)" class="uni-link uni-center uni-common-mt">
				点击这里给2 10倍
			</button>
			<button @tap="tap3(0.1)" class="uni-link uni-center uni-common-mt">
				不能设为0.1
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
				scale3:1,
				old: {
					x: 0,
					y: 0,
					scale: 2
				}
			}
		},
		methods: {
			tap1(num) {
				// 解决view层不同步的问题
				this.scale = this.old.scale
				this.scale = this.old.scale
				this.$nextTick(function() {
					this.scale = num
				})
			},
			tap2(num) {
				this.scale2 = this.old.scale
				this.scale2 = this.old.scale
				this.$nextTick(function() {
					this.scale2 = num
				})
			},
			tap3(num) {
				this.scale3 = this.old.scale
				this.scale3 = this.old.scale
				this.$nextTick(function() {
					this.scale3 = num
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
		width: 500rpx;
		height: 500rpx;
	}
</style>