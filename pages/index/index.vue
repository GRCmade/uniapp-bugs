<template>
	<view>
		<button @click="click('')">click</button>
		<button @click="click2">url file</button>
		<button @click="click3">send file</button>
		<button @click="click(1)">click header1</button>
		<button @click="click(2)">click header2</button>
		<button @click="click(3)">click header3</button>
		<button @click="click(4)">click header4</button>
	</view>
</template>
<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click(num) {
				let str = 'header' + num
				console.log("str", str)
				uni.downloadFile({
					url: `http://192.168.31.148:3000/download/${str}`, //仅为示例，并非真实的资源
					success: (res) => {
						console.log(res);
					}
				});
			},
			click2() {
				uni.downloadFile({
					url: 'http://192.168.31.148:3000/file/uni-app.pdf', //仅为示例，并非真实的资源
					success: (res) => {
						console.log(res);
					}
				});
			},
			click3() {
				uni.downloadFile({
					url: 'http://192.168.31.148:3000/download/senfile', //仅为示例，并非真实的资源
					success: (res) => {
						console.log(res);
					}
				});
			}
		}
	}
</script>
<style></style>