<template>
  <view>
    <video id="myVideo" src="https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/2minute-demo.mp4" @error="videoErrorCallback" :danmu-list="danmuList" enable-danmu danmu-btn controls>
      <cover-view class="video-mask">cover-view</cover-view>
      <view class="video-mask">view</view>
    </video>
  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const danmuList = ref([])
const videoErrorCallback = (e: any) => {
  console.log(e)
}
</script>

<style>
.video-mask {
  width: 100px;
  height: 100px;
  background-color: #0075ff;
  display: flex;
  justify-content: center;
  align-items: center;
}
</style>
