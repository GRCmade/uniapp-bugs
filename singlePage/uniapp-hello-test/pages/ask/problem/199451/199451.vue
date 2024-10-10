<template>
	<view>
		<button @click="click">click</button>
		<button @click="seek">seek</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				thisAudioContext:''
			}
		},
		methods: {
			seek(){
				this.thisAudioContext.seek(0) // 从开始时间开始播放
			},
			click(){
				const innerAudioContext = uni.createInnerAudioContext();
				this.thisAudioContext = innerAudioContext
				innerAudioContext.autoplay = true;
				innerAudioContext.src = 'https://web-ext-storage.dcloud.net.cn/uni-app/ForElise.mp3';
				innerAudioContext.onPlay(() => {
				  console.log('开始播放');
				});
				innerAudioContext.onError((res) => {
				  console.log(res.errMsg);
				  console.log(res.errCode);
				});

			}
		}
	}
</script>

<style>

</style>
