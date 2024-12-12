<template>
	<view>
		<button @tap="show = !show">aa</button>
		<input type="text" value="" class="input" auto-focus  v-if="show"/>
		<view class="box">1</view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				show: false
			}
		},
		methods:{
		}
	}
</script>
<style>
	.input {
		border: 1px solid;
		/* position: fixed;
		bottom: 0; */
	}
	.box{
		width: 100%;
		height: 1000px;
		background-color: aqua;
	}
</style>