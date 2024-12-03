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
				uni.chooseImage({
					count: 1,
					sourceType: ['album'],
					success: function (res) {
						uni.getImageInfo({
							src: res.tempFilePaths[0],
							success: function (image) {
								console.log(image.width);
								console.log(image.height);
							}
						});
					}
				});

				// uni.getImageInfo({
				// 	src: "https://yuhepicgo.oss-cn-beijing.aliyuncs.com/logo.png",
				// 	success: function(image) {
				// 		console.log(image.width);
				// 		console.log(image.height);
				// 	},
				// 	fail(res) {
				// 		console.log(JSON.stringify(res));
				// 	}
				// });
			}
		}
	}
</script>


<style></style>