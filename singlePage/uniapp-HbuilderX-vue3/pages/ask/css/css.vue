<template>
	<view>
		<view class="gi-1">1</view>
		<view class="gi-2">2</view>
		<view class="ggg-1">3</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {};
		},
		methods: {}
	};
</script>

<style>
/* 匹配 class 包含 'gi-' 的元素 */
[class*='gi-']:before {
	content: ''; /* 必须定义内容，哪怕是空字符串 */
	display: inline-block; /* 定义布局类型 */
	width: 20px;
	height: 20px;
	background-color: red;
	margin-right: 5px; /* 与后面的内容分隔 */
}
</style>