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
				uni.chooseVideo({
					sourceType: ['camera', 'album'],
					success: function(res) {

						uni.uploadFile({
							url: "http://192.168.31.148:3000/uploadfile",
							filePath: res.tempFilePath,
							name: 'file',
							success(res) {
								console.log(res);
							},
							fail(res) {
								console.log(res);
							}
						})
					}
				});
			}
		}
	}
</script>


<style></style>