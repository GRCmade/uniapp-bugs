<template>
  <view>
    <video id="myVideo" src="https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/2minute-demo.mp4" @error="videoErrorCallback" :danmu-list="danmuList" enable-danmu danmu-btn controls>
      <cover-view class="video-mask" @touchstart="handleTouchStart" @touchmove="handleTouchMove" @touchcancel="handleTouchCancel" @touchend="handleTouchEnd">cover-view</cover-view>
      <view class="video-mask" @touchstart="handleTouchStart" @touchmove="handleTouchMove" @touchcancel="handleTouchCancel" @touchend="handleTouchEnd">view</view>
    </video>
  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const danmuList = ref([])
const videoErrorCallback = (e: any) => {
  console.log(e)
}
const handleTouchStart = (e: any) => {
  console.log(e)
}
const handleTouchMove = (e: any) => {
  console.log(e)
}
const handleTouchEnd = (e: any) => {
  console.log(e)
}
const handleTouchCancel = (e: any) => {
  console.log(e)
}
</script>

<style>
.video-mask {
  width: 100%;
  height: 50px;
  margin-top: 50px;
  background-color: #0075ff;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
