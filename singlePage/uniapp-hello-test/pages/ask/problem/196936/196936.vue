<template>
	<view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		onLoad() {
			uni.login({
				provider: 'weixin',
				success: res => {
					console.log(res)
				},
				fail: (res) => {
					console.log(res)
				},
				complete: () => {}
			});
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
