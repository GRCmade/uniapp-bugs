<template>
	<view>
		<button @click="click">click</button>
		<button @click="getStorage">getStorage</button>
		<button @click="getStorageSync">getStorageSync</button>
	</view>
</template>


<script>
	export default {
		data() {
			return {}
		},
		methods: {
			getStorageSync(){
				console.log(JSON.stringify(uni.getStorageSync('key')));
			},
			getStorage() {
				uni.getStorage({
					key: 'key',
					success(res) {
						console.log(JSON.stringify(res));
					}
				})
			},
			click() {
				uni.setStorage({
					key: 'key',
					data: [{
						"note": "男",
						"id": "1",
						"cbm": "1"
					}, {
						"note": "女",
						"id": "2",
						"cbm": "2"
					}],
					success() {
						console.log("success");
					}
				})
				// uni.setStorageSync('key', [{
				// 	"note": "男",
				// 	"id": "1",
				// 	"cbm": "1"
				// }, {
				// 	"note": "女",
				// 	"id": "2",
				// 	"cbm": "2"
				// }])
			}
		}
	}
</script>


<style></style>