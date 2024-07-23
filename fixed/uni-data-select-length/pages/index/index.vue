<template>
	<view class="container">

		<view class="intro">本项目已包含uni ui组件，无需import和注册，可直接使用。在代码区键入字母u，即可通过代码助手列出所有可用组件。光标置于组件名称处按F1，即可查看组件文档。</view>
		<text class="intro">详见：</text>
		<uni-link :href="href" :text="href"></uni-link>
		<view>
			<uni-data-select v-model="value" :localdata="range" @change="change"></uni-data-select>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				value: 1,
				range: [{
						value: 0,
						text: "篮球"
					},
					{
						value: 1,
						text: "足球"
					},
					{
						value: 2,
						text: "游泳阿萨德尽快哈是客户打卡机双打卡户籍卡大叔大婶大叔大婶大萨达打算电话卡激活即可"
					},
				],
			};
		},
		methods: {
			change(e) {
				console.log("e:", e);
			},
		},
	};
</script>

<style>
	.container {
		padding: 20px;
		font-size: 14px;
		line-height: 24px;
	}
</style>