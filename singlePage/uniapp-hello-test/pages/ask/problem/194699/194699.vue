<template>
	<view>
		keyboardHeight
	</view>
</template>

<script>
	export default{
		onLoad() {
			uni.onKeyboardHeightChange(res => {
			  console.log(res.height)
			})
		}
	}
	// import {
	// 	onReady,
	// 	onLoad,
	// 	onUnload,
	// } from '@dcloudio/uni-app'
	// import {
	// 	nextTick,
	// 	onMounted
	// } from "vue"
	
	// onMounted(() => {
	// 	uni.onKeyboardHeightChange((e) => {
	// 		console.log('键盘高度变化', e.keyboardHeight); //无效
	// 	});
		
		
	// });
	// onLoad(()=>{
	// 	uni.onKeyboardHeightChange((e) => {
	// 		console.log('键盘高度变化', e.keyboardHeight); //无效
	// 	});
	// })
</script>

<style>

</style>