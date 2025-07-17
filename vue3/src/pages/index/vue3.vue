<template>
	<view>
		<button @click="click">vue3 osTheme</button>
		{{ theme }}
	</view>
</template>
<script lang="ts" setup>
	import { onLoad } from '@dcloudio/uni-app';
	import { ref } from 'vue';
	const theme = ref()
	onLoad(() => {
		console.log('osTheme', uni.getSystemInfoSync().osTheme)
		console.log('appTheme', uni.getSystemInfoSync().appTheme)
		uni.onThemeChange((res) => {
			console.log("uni.onThemeChange", JSON.stringify(res))
			theme.value = JSON.stringify(res)
		})
	})
	const click = () => {
		console.log('osTheme', uni.getSystemInfoSync().osTheme)
		console.log('appTheme', uni.getSystemInfoSync().appTheme)
	}
</script>
<style></style>