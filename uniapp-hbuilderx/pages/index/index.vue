<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>
<script lang="ts">
	import { WifiOption } from '@/uni_modules/uni-wifi/utssdk/interface'

	export default {
		data() {
			return {
				title: 'Hello'
			}
		},
		onLoad() {

		},
		methods: {
			click() {
				uni.startWifi({
					complete: e => {
						console.log("startWifi", e)
					}
				})
				uni.getConnectedWifi({
					success(res) {
						console.log("res", res)
					}, fail(res) {
						console.log("fail", res)
					}
				})
			}
		}
	}
</script>
<style>
</style>