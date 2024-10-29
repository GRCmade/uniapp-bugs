<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>


<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				uni.showToast({
					title: 'yuhe',
					position: 'center',
					icon: 'none',
					mask: true,
				});
			}
		}
	}
</script>


<style></style>