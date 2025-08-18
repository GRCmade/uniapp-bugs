<template>
	<view>
		<button @click="showModel">showModel</button>
		<button @click="showToast">showToast</button>
		<button @click="showLoading">showLoading</button>
		<button @click="showActionSheet">showActionSheet</button>
	</view>
</template>

<script>
export default {
	data() {
		return {}
	},
	methods: {
		showLoading() {
			uni.showLoading({
				title: 'loading',
				mask: true
			})
			setTimeout(uni.hideLoading, 1000)
		},
		showToast() {
			uni.showToast({
				title: '默认',
				icon: 'error',
				success: (res) => {
					this.exeRet = 'success:' + JSON.stringify(res)
				},
				fail: (res) => {
					this.exeRet = 'fail:' + JSON.stringify(res)
				}
			})
		},
		showModel() {
			uni.showModal({
				title: '提示',
				content: '这是一个模态弹窗',
				showCancel: true,
				success: (res) => {
					if (res.confirm) {
						console.log('用户点击确定')
					} else if (res.cancel) {
						console.log('用户点击取消')
					}
				}
			})
		},
		showActionSheet() {
			uni.showActionSheet({
				itemList: ['A', 'B', 'C'],
				success: function (res) {
					console.log('选中了第' + (res.tapIndex + 1) + '个按钮')
				},
				fail: function (res) {
					console.log(res.errMsg)
				}
			})
		}
	}
}
</script>

<style></style>
