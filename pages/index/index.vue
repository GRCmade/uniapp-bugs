<template>
	<view>
		<button @click="click">chooseImage</button>
		<image :src="base64" mode=""></image>
		<button @click="setStorage">setStorage</button>
		<button @click="getStorage">getStorage</button>
		<button @click="click2">createCanvasContext</button>
		<canvas style="width: 300px; height: 200px;" canvas-id="myCanvas" id="myCanvas"></canvas>
		<view class="box">
			<view class="box-item">
				calc(15% - 10rpx)
			</view>
			<view class="box-item-2">
				15%
			</view>
			<view class="box-item-3">

			</view>
		</view>
	</view>
</template>


<script>
	export default {
		data() {
			return {
				data: [1, 2, 3, 4],
				base64: ''
			}
		},
		methods: {
			click2() {
				let imageUrl = "/static/logo.png";
				let ctx = uni.createCanvasContext('myCanvas');
				console.log("click2");
				ctx.drawImage(imageUrl, 0, 0, 200, 200);
				ctx.setFontSize(20);
				ctx.setFillStyle('black');
				ctx.setGlobalAlpha(0.5);
				let width = ctx.measureText('hello', {
					fontSize: 16
				}).width;
				ctx.fillText('hello wrold', 20, 180);
				ctx.draw(true, () => {
					uni.canvasToTempFilePath({
						canvasId: 'myCanvas',
						// x: 100,
						// y: 200,
						// width: 50,
						// height: 50,
						// destWidth: 100,
						// destHeight: 100,
						success: (res) => {
							console.log("success", res);
							uni.saveImageToPhotosAlbum({
								filePath: res.tempFilePath,
								success: function() {
									console.log('save success');
								}
							});
						},
						fail: (err) => {
							console.error('Error drawing watermark:', JSON.stringify(err));
						}
					});
				});
			},
			setStorage() {
				console.log("setStorage")
				const user = this.data
				console.log(JSON.stringify(user))
				uni.setStorageSync('userInfo', user)
			},
			getStorage() {
				console.log("getStorage")
				var userInfo = uni.getStorageSync('userInfo')
				console.log(JSON.stringify(userInfo))
			},
			click() {
				uni.chooseImage({
					success: (chooseImageRes) => {
						const tempFilePaths = chooseImageRes.tempFilePaths;
						uni.uploadFile({
							url: 'http://192.168.31.148:3000/uploadbase64', //仅为示例，非真实的接口地址
							filePath: tempFilePaths[0],
							name: 'file',
							formData: {
								'user': 'test'
							},
							success: (uploadFileRes) => {
								console.log(uploadFileRes.data);
								this.base64 = uploadFileRes.data.base64
							},
							fail(res) {
								console.log(res);
							}
						});
					}
				});

			}
		}
	}
</script>


<style>
	.box {
		width: 100%;
		height: 400px;
		background-color: red;
		/* display: flex; */
	}

	.box-item {
		width: 100px;
		height: calc(15% - 10rpx);
		background-color: blue;
	}

	.box-item-2 {
		width: 100px;
		height: 15%;
		background-color: aqua;
	}

	.box-item-3 {
		width: 100px;
		height: calc(15% - 10rpx - 0rpx);
		background-color: green;
	}
</style>