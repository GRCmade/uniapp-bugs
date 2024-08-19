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
				uni.request({
					url:"https://fc-mp-701e6f43-b3d1-467b-be68-d24d7eaaa29a.next.bspapp.com/ask/harmonyAxios",
					success(res) {
						console.log(res)
						uni.reLaunch({
							url:"/pages/ask/problem/188927/188927"
						})
					}
				})
				
			}
		}
	}
</script>

<style>

</style>
