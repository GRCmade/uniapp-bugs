<template>

	<view class="content flex">
		<button class="btn type-1" @click="clickTab1">按钮1</button>
		<button class="btn type-1" @click="clickTab2">按钮2</button>
	</view>
</template>

<script setup>
	import {
		ref
	} from 'vue'
	// const audio = uni.createInnerAudioContext()
	// audio.src = 'https://www.cambridgeenglish.org/images/153149-movers-sample-listening-test-vol2.mp3'

	// const clickTab1 = () => {
	// 	audio.play()
	// }

	const audioRef = ref(null)
	audioRef.value = uni.createInnerAudioContext()
	audioRef.value.src = 'https://www.cambridgeenglish.org/images/153149-movers-sample-listening-test-vol2.mp3'

	const clickTab2 = () => {
		audioRef.value.play()
	}
	
	// const audioRef = ref(null)
	// audioRef.value = uni.createInnerAudioContext()
	// audioRef.value.src = 'https://web-ext-storage.dcloud.net.cn/uni-app/ForElise.mp3'

	// const clickTab1 = ()=>{
	// 	audioRef.value.play()
	// 	// innerAudioContext.onPlay(() => {
	// 	//   console.log('开始播放');
	// 	// });
	// }
</script>

<style>

</style>