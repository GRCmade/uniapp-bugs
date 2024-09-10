<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			click(){
				uni.reLaunch({
					url:"/pages/ask/index"
				})
			}
		}
	}
</script>

<style>

</style>
