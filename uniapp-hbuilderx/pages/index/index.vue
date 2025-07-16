<template>
	<view>
		<button @click="handleClick">Click me</button>
		<uni-popup ref="popup" type="center">
			<view class="pop">
				底部弹出 Popup 自定义圆角
			</view>
		</uni-popup>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				message: 'Hello, World!'
			}
		},
		methods: {
			handleClick() {
				console.log('Button clicked')
				this.$refs.popup.open()
			}
		}
	}
</script>
<style scoped>
</style>