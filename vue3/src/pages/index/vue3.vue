<template>
	<view>
		{{tempFilePath}}
		<image :src="tempFilePath" mode=""></image>
		<button @click="click">chooseMedia</button>
		<button @click="chooseImage">chooseImage</button>
	</view>
</template>
<script lang="ts" setup>
	import { ref } from 'vue';
	const tempFilePath = ref()
	const fileSystemManager = uni.getFileSystemManager()
	const click = () => {
		uni.chooseMedia({
			count: 1,
			mediaType: ['image'],
			sourceType: ['album', 'camera'],
			success: (res) => {
				tempFilePath.value = res.tempFiles[0].tempFilePath;
				console.log("chooseMedia", JSON.stringify(tempFilePath.value))
				try {
					const result = fileSystemManager.readFileSync(tempFilePath.value);
					console.log("readFileSync - result", JSON.stringify(result))
				} catch (err) {
					console.log('readFileSync', err)  //  
				}
			},
			fail: (err) => {
				console.log('chooseMedia', err);
			}
		})
	}

	const chooseImage = () => {
		uni.chooseImage({
			count: 1,
			albumMode: "system",
			// sizeType: ["original"],
			sourceType: ["album", "camera"],
			success: (e) => {
				console.log(e.tempFilePaths[0])
				try {
					let res = uni.getFileSystemManager().openSync({
						filePath: e.tempFilePaths[0]
					})
					console.log('success:', JSON.stringify(res))
					let fileStas = uni.getFileSystemManager().fstatSync({
						"fd": res
					})
					console.log('fileStas:', JSON.stringify(fileStas))
					// let readFile = uni.getFileSystemManager().readFileSync(e.tempFilePaths[0])
					// console.log('readFile:', JSON.stringify(readFile))
					uni.getFileSystemManager().readFile({
						filePath: e.tempFilePaths[0],
						success({ data } : any) {
							let base64 = uni.arrayBufferToBase64(data)
							console.log("base64", JSON.stringify(base64))
						},
						fail() {

						}
					})
				} catch (e) {
					console.log(e)
				}
			}
		})
	}
</script>
<style></style>