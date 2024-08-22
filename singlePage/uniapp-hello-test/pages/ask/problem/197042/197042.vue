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
				const para = encodeURIComponent("/page/index?i=666")
				const url = `/pages/ask/problem/197042/197042-1?data=${para}&type=123`
				console.log("197042",para)
				uni.navigateTo({
					url:url
				})
			}
		}
	}
</script>

<style>

</style>
