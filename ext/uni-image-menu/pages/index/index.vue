<template>
	<button type="default" @click="showImageMenu">显示底部图标菜单</button>
</template>
<script>
	// #ifdef APP-HARMONY
	import { uniShare } from "@/uni_modules/uni-image-menu"
	// #endif
	// #ifndef APP-HARMONY
	import uniImageMenu from '@/uni_modules/uni-image-menu/js_sdk/uni-image-menu.js';
	// #endif
	export default {
		methods: {
			showImageMenu() {
				// #ifdef APP-HARMONY
				uniShare(['https://bjetxgzv.cdn.bspapp.com/VKCEYUGU-dc-site/9a952c80-6080-11eb-a16f-5b3e54966275.png',
					'https://bjetxgzv.cdn.bspapp.com/VKCEYUGU-dc-site/d84c6de0-6080-11eb-bdc1-8bd33eb6adaa.png'
				])
				// #endif
				// #ifndef APP-HARMONY
				uniImageMenu.show({
					list: [{
						"img": "https://bjetxgzv.cdn.bspapp.com/VKCEYUGU-dc-site/9a952c80-6080-11eb-a16f-5b3e54966275.png",
						"text": "uni-app"
					}, {
						"img": "https://bjetxgzv.cdn.bspapp.com/VKCEYUGU-dc-site/d84c6de0-6080-11eb-bdc1-8bd33eb6adaa.png",
						"text": "unicloud"
					}],
					cancelText: "取消"
				}, index => {
					uni.showToast({
						title: '你点了第' + (index + 1) + '个图标',
						icon: 'none'
					});
				})
				// #endif
			}
		}
	}
</script>