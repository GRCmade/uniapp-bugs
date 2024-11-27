<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>

<script>
	// import {
	// 	openUrl
	// } from "@/uni_modules/cysy-appTools"
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			click(){
				openUrl("http://yuhe.space")
			}
		}
	}
</script>

<style>

</style>
