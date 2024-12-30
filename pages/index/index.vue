<template>
	<view>
		<button @click="click">click 压缩</button>
		<button @click="click2">click 原图</button>
		<button @click="click3">click saveVideoToPhotosAlbum</button>
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
					sourceType: ['camera', 'album'],
					sizeType: ['compressed'],
					success: function(res) {
						uni.saveImageToPhotosAlbum({
							filePath: res.tempFilePaths[0],
							success: function() {
								console.log('save success');
							},
							fail(res) {
								console.log('save fail', JSON.stringify(res));
							}
						});
					}
				});
			},
			click2() {
				uni.chooseImage({
					count: 1,
					sourceType: ['camera', 'album'],
					sizeType: ['original'],
					success: function(res) {
						uni.saveImageToPhotosAlbum({
							filePath: res.tempFilePaths[0],
							success: function() {
								console.log('save success');
							},
							fail(res) {
								console.log('save fail', JSON.stringify(res));
							}
						});
					}
				});
			},
			click3() {
				uni.chooseVideo({
					sourceType: ['album', 'camera'],
					success: function(res) {
						uni.saveVideoToPhotosAlbum({
							filePath: res.tempFilePath,
							success: function() {
								console.log('save success');
							}
						});
					}
				});
			}
		}
	}
</script>


<style></style>