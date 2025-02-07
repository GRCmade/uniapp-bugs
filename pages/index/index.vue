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
				uni.makePhoneCall({
					phoneNumber: '17348678249' ,//仅为示例
					success(res) {
						console.log("success",res)
					},
					fail(res){
						console.log("fail",res)
					}
				});
			}
		}
	}
</script>


<style></style>