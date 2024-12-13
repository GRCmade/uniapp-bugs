<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>


<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				uni.request({
					url:"http://192.168.31.148:3000/api/data",
					header:{
						"content-type": "text/plain"
					},
					success(res) {
						console.log(res.data.slice(0,-1))
						try {
							const str = res.data.slice(0,-1)
							const obj = JSON.parse(str)
							console.log(obj)
						} catch (error) {
							console.log(error)
							//TODO handle the exception
						}

					}
				})
			}
		}
	}
</script>


<style></style>