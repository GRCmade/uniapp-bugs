<template>
	<view>
		<slider min="0.3" max="3" :value="0.3" step="0.05" activeColor="#61bc55" @change="sliderChange"
			@changing="sliderChange" show-value />
		<button @click="handleClick">Click me</button>
	</view>
</template>

<script>
	export default {
		methods: {
			sliderChange(e) {
				console.log('value 发生变化：' + e.detail.value)
			}
		}
	}
</script>

<style scoped>
</style>