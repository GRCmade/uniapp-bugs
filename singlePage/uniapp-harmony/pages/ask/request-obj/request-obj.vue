<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>


<script>
	export default {
		data() {
			return {
				ls: ["1","2"]
			}
		},
		methods: {
			click() {
				// 192.168.31.148
				const ls = ["1","2"]
				uni.request({
					url: "http://192.168.31.148:3001/data",
					method: "POST",
					header:{
						'content-type':'application/json'
					},
					data: this.ls,
					success(res) {
						console.log("成功", JSON.stringify(res))
					},
					fail(res) {
						console.log("失败", res);
					}
				})
			}
		}
	}
</script>


<style></style>