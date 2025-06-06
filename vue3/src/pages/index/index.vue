<template>
	<view>
		<button @click="click">button</button>
		<span>src:{{ src }}</span>
		<web-view :src="src" style="margin-top: 200px" />
	</view>
</template>
<script lang="ts" setup>
	import { ref } from 'vue'
	import { onLoad } from '@dcloudio/uni-app'

	const src = ref('')
	const showWebview = ref(false)
	const options = ref({
		label: 'hello'
	})

	const onClick = (e:any) => {
		console.log('onClick', e.detail.text)
		this.options = {
			label: 'world'
		}
	}

	onLoad(() => {
		// await new Promise(resolve => setTimeout(resolve, 0))
		setTimeout(()=>{
			src.value = 'https://www.baidu.com'
		},0)
	})
	const click = async () => {
		await new Promise(resolve => setTimeout(resolve, 0))
		console.log("click")
		src.value = 'https://www.huawei.com'
	}
</script>
<style></style>