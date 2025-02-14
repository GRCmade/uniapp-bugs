<template>
	<view>
		<button @click="click">click</button>
		{{src}}
		<image :src="src" mode=""></image>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				src: '/data/storage/el2/base/temp/HBuilder/compress/1739502265790_0.png'
			}
		},
		methods: {
			click() {
				var _this = this
				// console.log(navigator.userAgent);
				uni.chooseImage({
					count: 1, //默认9
					sizeType: ['original'], //可以指定是原图还是压缩图，默认二者都有
					sourceType: ['album'], //从相册选择
					success: function(res) {
						console.log(JSON.stringify(res.tempFilePaths));
						_this.src = res.tempFilePaths[0]
					}
				});
			}
		}
	}
</script>


<style></style>