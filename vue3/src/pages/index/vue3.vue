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
				console.log("chooseMedia", JSON.stringify(res))
				tempFilePath.value = res.tempFiles[0].tempFilePath;
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
			mediaType: ['image'],
			sourceType: ['album', 'camera'],
			success: (res) => {
				console.log("chooseImage", JSON.stringify(res))
				tempFilePath.value = res.tempFiles[0].path;
				try {
					const result = fileSystemManager.readFileSync(tempFilePath.value);
					console.log("readFileSync - result", JSON.stringify(result))
				} catch (err) {
					console.log('readFileSync', JSON.stringify(err))  //  
				}
			},
			fail: (err) => {
				console.log('chooseImage', err);
			}
		})
	}
</script>
<style></style>