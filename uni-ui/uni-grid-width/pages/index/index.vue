<template>
	<view class="">
		<uni-grid :column="list.length" :showBorder="false" :highlight="true" :square="true">
			<uni-grid-item v-for="(item, index) in list" :key="index" :index="index">
				<view class="align-center justify-center" style="flex: 1;">
					<text style="margin-bottom: 10px;">{{ item.num }}</text>
					<text class="font-md">{{ item.name }}</text>
				</view>
			</uni-grid-item>
		</uni-grid>
		<view class="box">
			
		</view>
	</view>
	
</template>

<script>
	export default {
		data() {
			return {
				// 选项列表
				list: [{
					name: '积分',
					num: 0
				}, {
					name: '调研团',
					num: 0
				}, {
					name: '好友',
					num: 0
				}],
			}
		},
		onLoad() {

		},
		methods: {

		}
	}
</script>

<style>
	.box{
		height: 200rpx;
		width: 100%;
		background-color: blue;
	}
	.align-center{
		background-color: red;
	}
</style>