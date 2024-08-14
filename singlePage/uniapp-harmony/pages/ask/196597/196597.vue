<template>
	<view>
		<button @click="showtoast">showtoast</button>
		<button @click="setClipboardData">setClipboardData</button>

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
			showtoast() {
				uni.showToast({
					icon: 'none',
					position: 'bottom',
					title: "123"
				});
			},
			setClipboardData() {
				uni.setClipboardData({
					data: "2222",
					showToast: true,
					success(e) {
						console.log('success')
					},
					fail(e) {
						console.log(e)
					}
				})
			}
		}
	}
</script>

<style>

</style>