<template>
	<view>
		<button @click="nav">nav</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			nav(){
				console.log("nav")
				uni.navigateTo({
					url:"/pages/ask/problem/196888/subpage/196888-1",
					fail(e) {
						console.log(e)
					}
				})
			}
		}
	}
</script>

<style>

</style>
