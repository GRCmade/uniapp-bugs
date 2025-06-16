<template>
	<view>
		<button @click="click">click</button>
		<button @click="getLocation">getLocation</button>
	</view>
</template>


<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				const appAuthorizeSetting = uni.getAppAuthorizeSetting()
				console.log(JSON.stringify(appAuthorizeSetting))
				console.log(JSON.stringify(appAuthorizeSetting.locationAuthorized))
			},
			getLocation(){
				uni.getLocation({
					success(res) {
						console.log(res);
					},
					fail(err) {
						console.log("fail",JSON.stringify(err))
					}
				})
			}
		}
	}
</script>


<style></style>