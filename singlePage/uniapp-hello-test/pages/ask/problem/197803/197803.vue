<template>
	<view>
		<view class="height">yuhe</view>
		<!-- <uni-nav-bar left-icon="back" left-text="返回" right-text="菜单" title="标题"></uni-nav-bar> -->
		<!-- <uni-data-select ref="dataSelect" v-model="value" :localdata="range" @change="change"></uni-data-select> -->
	</view>
</template>

<script>
	export default {
		data() {
			return {
				value: 0,
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
						text: "游泳"
					},
				],
			};
		},
		onLoad() {
			// this.$refs.dataSelect.toggleSelector()
		},
		methods: {
			change(e) {
				console.log("e:", e);
			},
		},
	};
</script>

<style lang="scss">
	.height{
		margin-top: var(--status-bar-height)	;
	}
	.text {
		font-size: 12px;
		color: #666;
		margin-top: 5px;
	}

	.uni-px-5 {
		padding-left: 10px;
		padding-right: 10px;
	}

	.uni-pb-5 {
		padding-bottom: 10px;
	}
</style>