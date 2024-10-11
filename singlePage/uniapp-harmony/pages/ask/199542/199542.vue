<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>

<script>
	const staticList = [
		// 首页背景图片
		"http://101.42.30.128:8000/file/2024/06/fc45aadb-69e8-4144-828d-1b306744cf08_index.jpg",
		// 专家背景图片
		"http://101.42.30.128:8000/file/2024/06/26b6dd2e-4e68-46b0-985e-14fa1ba11ffb_zhuanjia.jpg",
		// 资料库背景图片
		"http://101.42.30.128:8000/file/2024/06/ef5f1b14-47ef-4f76-a5fa-a5f50f1dd7f1_ziliao.jpg",
		// 没有东西empty的图片
		"http://101.42.30.128:8000/file/2024/06/767871a0-fba9-430f-9a51-a05ba9e9bf9f_1709291435928808498.jpg"
	]
	export default {
		data() {
			return {

			}
		},
		methods: {
			click() {
				uni.previewImage({
					urls: staticList,
					// longPressActions: {
					// 	itemList: ['发送给朋友', '保存图片', '收藏'],
					// 	success: function(data) {
					// 		console.log('选中了第' + (data.tapIndex + 1) + '个按钮,第' + (data.index + 1) + '张图片');
					// 	},
					// 	fail: function(err) {
					// 		console.log(err.errMsg);
					// 	}
					// }
				});

			}
		}
	}
</script>

<style>

</style>