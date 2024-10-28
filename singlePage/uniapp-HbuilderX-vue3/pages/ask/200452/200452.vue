<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		onLoad() {


		},
		methods: {
			click() {
				let urls = [
					'https://mp-701e6f43-b3d1-467b-be68-d24d7eaaa29a.cdn.bspapp.com/cloudstorage/00b1f197-d7b8-492b-a361-f4d4ee3cfc7e.png'
				]
				uni.previewImage({
					urls: ['/static/logo.png'],
					success(e) {
						console.log("预览图片",e);
					},
					fail(e) {
						console.log(e);
					}
				})
			}
		}
	}
</script>

<style>

</style>