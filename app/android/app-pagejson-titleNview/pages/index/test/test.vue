<template>
	<view>
		test
	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		onLoad() {
			uni.showToast({
				duration: 4000,
				title: this.type == 'edit' ? '更新成功' : '添加成功',
				icon: "none",
				success() {
					console.log("showToast-success")
				},
				complete() {
					// setTimeout(function(){
					// 	uni.navigateBack()
					// },2000)
					console.log("showToast-complete")
				}
			})

		},
		methods: {

		}
	}
</script>

<style>

</style>