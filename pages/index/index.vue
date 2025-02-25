<template>
	<view>
		<button @click="click">click</button>
		<com-a ref="ModalRef" id=""></com-a>
	</view>
</template>
<script setup>
	// export default {
	// 	name: 'YourComponentName',
	// 	data() {
	// 		return {
	// 			// ModalRef: ''  // 使用 data 返回 ModalRef
	// 		};
	// 	},
	// 	methods: {
	// 		click() {
	// 			// 在 methods 中定义 click 方法
	// 			console.log("ModalRef", this.$refs.ModalRef);
	// 			const pages = getCurrentPages();
	// 			const page = pages[pages.length - 1];
	// 			console.log('当前页面', page.$vm.$refs);
	// 		}
	// 	}
	// }
	import { ref } from 'vue';
	const ModalRef = ref(null)
	const click = () => {
		console.log("ModalRef", ModalRef.value)
		ModalRef.value.comaconsole()
		var pages = getCurrentPages();
		var page = pages[pages.length - 1];
		console.log('当前页面', page.$vm.$refs);
	}
</script>
<style></style>