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
			uni.showModal({
				title: '提示',
				content: '这是一个模态弹窗',
				confirmColor:'#36D',
				success: function (res) {
					if (res.confirm) {
						console.log('用户点击确定');
					} else if (res.cancel) {
						console.log('用户点击取消');
					}
				}
			});

		},
		methods: {
			
		}
	}
</script>

<style>

</style>
