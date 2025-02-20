<template>
	<view>
		<view class="" @click="click">组件： com click</view>
	</view>
</template>

<script>
	export default {
		name: "com",
		data() {
			return {

			};
		},
		methods: {
			click() {
				this.$emit('click');
			}
		}
	}
</script>

<style>

</style>