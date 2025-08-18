<template>
	<view>
		<picker-view class="picker-view" :value="indexs" :indicatorStyle="indicatorStyle">
			<picker-view-column v-if="false">
				<view class="item" v-for="(item, index) in 20" :key="index">{{ item }}</view>
			</picker-view-column>
			<picker-view-column>
				<view class="item" v-for="(item, index) in 20" :key="index">{{ item }}</view>
			</picker-view-column>
			<picker-view-column>
				<view class="item" v-for="(item, index) in 20" :key="index">{{ item }}</view>
			</picker-view-column>
		</picker-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				indexs: [],
				show: false,
				indicatorStyle: `height: 30px;`,
			}
		},
		methods: {
			changeIndexs() {
				this.indexs = [2, 3]
				console.log(this.indexs)
			},
		},
	}
</script>

<style>
	.picker-view {
		width: 750rpx;
		height: 600rpx;
	}

	.item {
		height: 34px;
		align-items: center;
		justify-content: center;
		text-align: center;
	}
</style>
