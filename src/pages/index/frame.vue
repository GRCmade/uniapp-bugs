<!--
 * @Author: weisheng
 * @Date: 2024-06-02 00:24:26
 * @LastEditTime: 2024-06-02 00:37:58
 * @LastEditors: weisheng
 * @Description: 
 * @FilePath: /uni-preset-vue-vite-ts/src/pages/index/frame.vue
 * 记得注释
-->
<template>
  <view class="content">
    <image class="logo" src="/static/logo.png" />
    <view class="text-area">
      <text class="title">{{ title }}</text>
    </view>

    <view id="sticky" style="height: 40px;width: 120rpx;background-color: brown;">哈哈</view>

  </view>
</template>

<script setup lang="ts">
import { getCurrentInstance, onMounted, ref } from 'vue'
const title = ref('Hello')

const proxy = getCurrentInstance()

const createObserver = () => {
  const observer = uni.createIntersectionObserver(proxy)
  return observer
}

onMounted(() => {
  const observer = createObserver()
  observer.relativeToViewport({ top: -84 }).observe('#sticky', (res) => {
    console.log(res)
  })

})
</script>

<style>
.content {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 250vh;
}

.logo {
  height: 200rpx;
  width: 200rpx;
  margin-top: 200rpx;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 50rpx;
}

.text-area {
  display: flex;
  justify-content: center;
}

.title {
  font-size: 36rpx;
  color: #8f8f94;
}
</style>
