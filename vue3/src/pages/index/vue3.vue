<template>
  <view>
    {{ audioSrc }}
    <button @click="click">button</button>
    <button @click="stop">stop</button>
  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

const audioContext = ref<any>(null)
const audioSrc = ref(
  'https://aizuowen-test.oss-cn-shenzhen.aliyuncs.com/audio/202507/20250701150516686388ac6227a.mp3?Expires=1751612716&OSSAccessKeyId=LTAI5tFRY33oR23Tatejksdx&Signature=nGvxvuAyheTXoazsdla%2Bh4BPQ4Y%3D'
)

const click = () => {
  audioContext.value = uni.createInnerAudioContext() // 创建音频上下文
  audioContext.value.src = audioSrc.value
  audioContext.value.play() // 开始播放
}
const stop = () => {
  audioContext.value.stop() // 停止播放
}
</script>

<style></style>
