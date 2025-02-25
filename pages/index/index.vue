<template>
	<div class="invisible" v-if="C1" @click="CB1"></div>
	<div class="button" @click="CB2">{{text}}</div>
	<div class="invisible" @click="CB3">CB3</div>
</template>
<script>
	export default {
		data() {
			return {
				text: '快速点击',
				C1: true,
			};
		},
		mounted() {
			setInterval(() => {
				this.C1 = !this.C1;
			}, 300);
		},
		methods: {
			CB1() {},
			CB2() {
				this.text = '正确: 触发了CB2';
				console.log(this.text);
			},
			CB3() {
				this.text = '错误: 触发了CB3';
				console.log(this.text);
			},
		},
	};
</script>
<style lang="less">
	.invisible {
		height: 0px;
	}

	.button {
		display: flex;
		justify-content: center;
		align-items: center;
		width: 100%;
		height: 100%;
		font-size: 80px;
		color: white;
		;
		background-color: red;
	}
</style>