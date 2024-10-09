<template>
	<view>
		<uni-grid :column="3" :square="false">
			<uni-grid-item>
				<text class="text">文本</text>
			</uni-grid-item>
			<uni-grid-item>
				<text class="text">文本</text>
			</uni-grid-item>
			<uni-grid-item>
				<text class="text">文本</text>
			</uni-grid-item>
			<uni-grid-item>
				<text class="text">文本</text>
			</uni-grid-item>
			<uni-grid-item>
				<text class="text">文本</text>
			</uni-grid-item>
			<uni-grid-item>
				<text class="text">文本</text>
			</uni-grid-item>
		</uni-grid>
		<uni-popup ref="showpopup" type="center">
			<view style="width: 750rpx;height: 500px;background-color: #fff;">
				<uni-grid :column="3" :square="false">
					<uni-grid-item>
						<text class="text">文本 1</text>
					</uni-grid-item>
					<uni-grid-item>
						<text class="text">文本 2</text>
					</uni-grid-item>
					<uni-grid-item>
						<text class="text">文本 3</text>
					</uni-grid-item>
					<uni-grid-item>
						<text class="text">文本 4</text>
					</uni-grid-item>
					<uni-grid-item>
						<text class="text">文本 5</text>
					</uni-grid-item>
					<uni-grid-item>
						<text class="text">文本 6</text>
					</uni-grid-item>
				</uni-grid>
			</view>
		</uni-popup>
		<button @click="click">click</button>
		<com></com>
	</view>
</template>

<script>
	import comVue from './com.vue'
	export default {
		components:{
			com:comVue
		},
		data() {
			return {

			}
		},
		onLoad() {},
		methods: {
			click() {
				this.$refs.showpopup.open()
			}
		}
	}
</script>

<style>

</style>