<template>
	<view>
		<button @click="click">click</button>
		<web-view ref="webview"  src="http://192.168.31.156:5500/test.html"></web-view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		onLoad() {
			
		},
		methods: {
			click(){
				const res = this.$refs.webview
				console.log(JSON.stringify(res));
			}
		}
	}
</script>

<style>

</style>
