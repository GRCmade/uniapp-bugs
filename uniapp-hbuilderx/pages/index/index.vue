<template>
	<view>
		<button @click="click">click</button>
		<button @click="plusClick">plusClick</button>
	</view>
</template>
<script>
	// import { getRealPath } from '@dcloudio/uni-platform'
	export default {
		data() {
			return {
				tempFilePaths: ''
			}
		},
		methods: {
			async plusClick() {
				const res = await uni.chooseImage({
					count: 1,
					sizeType: ['original', 'compressed'],
					sourceType: ['album', 'camera']
				})
				// console.log("res",res)
				const tempFilePaths = res.tempFilePaths
				const uploader = plus.uploader.createUpload("http://192.168.31.211:3001/uploadfile", {
					timeout: 10000,
					retry: 0,
					retryInterval: 0,
				}, (upload, statusCode) => {
					if (statusCode) {
						console.log("statusCode", upload.responseText, statusCode)
					} else {
						console.log(`statusCode: ${statusCode}`)
					}
				})
				uploader.addFile(tempFilePaths, {
					key: 'file'
				})
				uploader.addEventListener('statechanged', (upload, status) => {
					console.log("statechanged-1",upload.uploadedSize)
					console.log("statechanged-2",upload.totalSize)
					if (upload.uploadedSize && upload.totalSize) {
						console.log("statechanged", upload.uploadedSize)
					}
				})
				uploader.start()
			},
			async click() {
				const res = await uni.chooseImage({
					count: 1,
					sizeType: ['original', 'compressed'],
					sourceType: ['album', 'camera']
				})
				console.log("res", res)
				const tempFilePaths = res.tempFilePaths
				const upTask = uni.uploadFile({
					url: 'http://192.168.31.211:3001/uploadfile',
					filePath: tempFilePaths[0],
					name: 'file',
					formData: {
						user: 'test'
					},
					success(res) {
						console.log(res)
					}
				})
				upTask.onProgressUpdate(res => {
					console.log('process', JSON.stringify(res))
				})
			}
		}
	}
</script>
<style></style>