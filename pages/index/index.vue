<template>
	<view>
		<button @touchend="show = !show">aa</button>
		<input type="text" value="" class="input" auto-focus v-if="show" />
		<my-input></my-input>
		<view class="box">1</view>
	</view>
</template>
<script>
	import myInput from './my-input.vue';
	export default {
		components: {
			myInput
		},
		data() {
			return {
				show: false
			}
		},
		methods: {}
	}
</script>
<style>
	.input {
		border: 1px solid;
		/* position: fixed;
		bottom: 0; */
	}

	.box {
		width: 100%;
		height: 1000px;
		background-color: aqua;
	}
</style>