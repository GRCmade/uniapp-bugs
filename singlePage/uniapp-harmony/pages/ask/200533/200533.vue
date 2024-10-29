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
					url: 'https://fc-mp-701e6f43-b3d1-467b-be68-d24d7eaaa29a.next.bspapp.com/testrequest/testRequest', //仅为示例，并非真实接口地址。
					data: {
						text: 'uni.request'
					},
					header: {
						'custom-header': 'hello' //自定义请求头信息
					},
					success: (res) => {
						console.log(JSON.stringify(res.data));
					}
				});

			}
		}
	}
</script>


<style></style>