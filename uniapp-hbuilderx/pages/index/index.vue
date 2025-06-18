<template>
	<view>
		<button @click="show">显示原生状态栏</button>
		<button @click="hide">隐藏原生状态栏</button>
	</view>
</template>
<script>
	import { showStatusBar, hideStatusBar } from '@/uni_modules/harmony-statusbar';
	export default {
		data() {
			return {
				message: 'Hello, World!'
			}
		},
		methods: {
			show() {
				showStatusBar()
			},
			hide() {
				hideStatusBar()
			}
		}
	}
</script>
<style scoped>
</style>