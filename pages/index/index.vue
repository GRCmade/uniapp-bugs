<template>
	<view class="select-box">
		<view class="select-header">
			<text class="header-text close"></text>
			<text class="header-text header-title">{{pickerTitle}}</text>
			<text class="header-text sure" @click="confirmClick()">初始化</text>
		</view>
		<picker-view class="select-list-box" :indicator-style="indicatorStyle" :mask-style="maskStyle"
			:value="selectedIndexes" @change="selectChanged">
			<picker-view-column v-for="(pickerColumn, i) in pickerArray" :key="'pickerArray_'+i">
				<view class="select-list-item" v-for="(item, j) in pickerColumn" :key="'pickerArray_'+i+'_'+j">
					{{item.text}}
				</view>
			</picker-view-column>
		</picker-view>
	</view>
</template>

<script lang="ts" setup>
	import { ref } from 'vue';
	const indicatorStyle = ref('height: 100rpx;')
	const maskStyle = ref('')
	const selectedIndexes = ref([0, 0, 0])
	const pickerTitle = ref('')
	const pickerArray = ref([])
	function selectChanged(e : any) {
		const select_optionIndexs = e.detail.value
		console.log(select_optionIndexs)
		pickerTitle.value = JSON.stringify(select_optionIndexs)
	}
	function confirmClick() {
		let y_Option = format00(3, 25, 17, '年')
		let M_Option = format00(1, 2, 1, '月')
		let d_Option = format00(1, 31, 3, '日')
		let yArr = y_Option.listData
		let MArr = M_Option.listData
		let dArr = d_Option.listData
		pickerArray.value.push(yArr)
		pickerArray.value.push(MArr)
		pickerArray.value.push(dArr)
		selectedIndexes.value = [y_Option.defaultIndex, M_Option.defaultIndex, d_Option.defaultIndex]
	}
	function format00(start : any, end : any, defaultValue : any, word : string) {
		start = parseInt('0' + start)
		end = parseInt('0' + end)
		defaultValue = parseInt('0' + defaultValue)
		let listData = []
		let defaultIndex = 0
		for (let i = start; i <= end; i++) {
			let i_str = ('00' + i).slice(-2)
			if (defaultValue == i_str) {
				defaultIndex = listData.length
			}
			listData.push({
				value: i_str,
				text: i_str + word
			})
		}
		if (defaultValue > end) {
			defaultIndex = end
		}
		return { listData, defaultIndex }
	}
</script>

<style scoped>

	.t-red {
		color: red;
	}

	.pop-gap {
		width: 750rpx;
		height: 700rpx;
	}

	.pop-wrp {
		z-index: 200;
		top: 0rpx;
		left: 0rpx;
		position: fixed;
		height: 600rpx;
		width: 750rpx;
		overflow-y: scroll;
		background-color: aquamarine;
		display: flex;
		flex-direction: column;
	}

	.pop-t {
		word-wrap: break-word;
		white-space: normal;
		word-break: break-all;
		width: 740rpx;
		padding: 5rpx;
		color: #000000;
		font-size: 18rpx;
		border-bottom: 1rpx solid #000000;
	}

	.select-box {
		position: relative;
		width: 100%;
		height: 604rpx;
		background-color: #ffffff;
		bottom: 0;
		left: 0;
		border-radius: 24rpx 24rpx 0 0;
		overflow: hidden;
	}

	.select-header {
		position: relative;
		height: 104rpx;
		display: flex;
		align-items: center;
		justify-content: space-between;
		background-color: #ffffff;
		border-bottom: 1rpx solid #e9e9e9;
	}

	.header-text {
		height: 104rpx;
		line-height: 104rpx;
		font-size: 32rpx;
		color: #000000;
	}

	.close {
		padding-left: 32rpx;
		padding-right: 32rpx;
	}

	.header-title {
		flex: 1;
		text-align: center;
		color: #000000;
	}

	.sure {
		text-align: right;
		padding-left: 32rpx;
		padding-right: 32rpx;
		color: #08AEF9;
	}

	.select-list-box {
		position: relative;
		height: 500rpx;
		background-color: #ffffff;
	}

	.select-list-item {
		font-size: 32rpx;
		color: #000000;
		font-weight: 400;
		height: 100rpx;
		line-height: 100rpx;
		text-align: center;
		overflow: hidden;
		white-space: nowrap;
		text-overflow: ellipsis;
	}
</style>