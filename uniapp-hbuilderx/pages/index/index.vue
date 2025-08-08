<template>
	<view>
		<button @click="handleClick">Click me</button>
	</view>
</template>
<script>
	import { test } from "@/uni_modules/harmony-button"
	export default {
		data() {
			return {
				message: 'Hello, World!'
			}
		},
		methods: {
			handleClick() {
				console.log('Button clicked')
			}
		}
	}
</script>
<style scoped>
</style>