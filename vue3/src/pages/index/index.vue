<template>
	<view>
		<button @click="click">button</button>
	</view>
</template>
<script lang="ts" setup>
	const click = () => {
		uni.previewImage({
			urls: ['https://cos.haoce.com/upload/image/20250606/54a19f76-8b3b-4e67-ae1a-c6aec2c16e70.jpg'],
			current: "0",
			fail(e:any) {
				console.log("e", e)
			}
		})
	}
</script>
<style></style>