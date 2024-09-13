<template>
	<view class="box">
		comon
	</view>
</template>

<script>
	export default {
		mounted() {
			let pages = getCurrentPages();
			let view = pages[pages.length - 1];
			console.log(view);
			if (view) {
				view.onPageScroll = (e) => {
					console.log('onPageScroll', e);
				};
			}
		}
	}
</script>

<style>
	.box{
		height: 10000px;
	}
</style>