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
					url:"http://192.168.31.148:3000/api/jsontext",
					header:{
						"content-type": "text/plain"
					},
					success(res) {
						console.log(res.data)
						const str = res.data
						let obj = {}
						try {
							// obj = JSON.parse(decodeURIComponent(str))
							obj = JSON.parse(str)
						} catch (error) {
							console.log(error)
							//TODO handle the exception
						}
						console.log(obj)
					}
				})
			}
		}
	}
</script>


<style></style>