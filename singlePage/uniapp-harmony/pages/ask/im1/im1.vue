<template>
	<view>
		<button @click="handleOpenAlbum">鎵撳紑鐩稿唽</button>
		<canvas canvas-id="canvasImage" style="height: 200rpx;width: 200rpx;"></canvas>
	</view>
</template>
<script setup>
	function handleOpenAlbum() {
		uni.chooseImage({
			count: 1,
			success: (res) => {
				createCanvas(res.tempFilePaths[0])
			}
		})
	}
	async function createCanvas(url) {
		var context = uni.createCanvasContext('canvasImage');
		context.drawImage(url, 0, 0, 150, 50);
		await new Promise((resolve) => {
			context.draw(false, () => {
				// resolve();
				uni.canvasToTempFilePath({
					canvasId: 'canvasImage',
					destWidth: 150,
					destHeight: 100,
					success: (rst) => {
						var path = rst.tempFilePath;
						console.log(path)
					},
					fail: (err) => {
						console.log(JSON.stringify(err))
					},
					complete: () => {
						uni.hideLoading();
					}
				});
			});
		});
	}
</script>