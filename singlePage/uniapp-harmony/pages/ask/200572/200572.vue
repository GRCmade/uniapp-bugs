<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				uni.request({
					url: 'http://192.168.31.220:3000/get', //仅为示例，并非真实接口地址。
					data: {
						text: 'uni.request'
					},
					withCredentials:true,
					header: {
						'custom-header': 'hello', //自定义请求头信
						// 'Cookie':'Cookie',
						// 'Cookies':'cookies',
						// cookie:'cookie'
					},
					success: (res) => {
						console.log(res);
						console.log(JSON.stringify(res));
					}
				});
			}
		}
	}
</script>

<style></style>