<template>
	<view>
		<button @click="click">上传不压缩的图片</button>
		<button @click="click2">上传压缩的图片</button>
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
					count: 1, //默认9
					success: function(res) {
						console.log(JSON.stringify(res.tempFilePaths));
						uniCloud.uploadFile({
							filePath: res.tempFilePaths[0],
							cloudPath: 'a.jpg',
							onUploadProgress: function(progressEvent) {
								console.log(JSON.stringify(progressEvent));
							}
						});
					}
				});

			},
			click2() {
				uni.chooseImage({
					count: 1, //默认9
					success: function(res) {
						console.log(JSON.stringify(res.tempFilePaths));
						uni.compressImage({
							src: res.tempFilePaths[0],
							quality: 80,
							success: result => {
								console.log(JSON.stringify(result));
								uniCloud.uploadFile({
									filePath: result.tempFilePath,
									cloudPath: 'a.jpg',
									onUploadProgress: function(progressEvent) {
										console.log(JSON.stringify(progressEvent));
									}
								});
							}
						})
					}
				});
			}
		}
	}
</script>


<style></style>