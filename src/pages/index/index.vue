<!--
 * @Author: weisheng
 * @Date: 2024-03-29 17:30:12
 * @LastEditTime: 2024-06-02 00:31:10
 * @LastEditors: weisheng
 * @Description: 
 * @FilePath: /uni-preset-vue-vite-ts/src/pages/index/index.vue
 * 记得注释
-->
<template>
  <view class="content">
    <image class="logo" src="/static/logo.png" />
    <view class="text-area">
      <text class="title">{{ title }}</text>
    </view>
    <button @click="handleNav">
      跳转至interSectionObserver
    </button>

    <iframe ref="iframe" id="demo" class="iframe demo-model" scrolling="auto" frameborder="0"
      src="http://localhost:5174/#/pages/index/frame"></iframe>

  </view>
</template>

<script setup lang="ts">
import { ref } from 'vue'
const title = ref('Hello')
function handleNav() {
  uni.navigateTo({
    url: '/pages/index/frame'
  })
}
</script>

<style>
.content {
  display: flex;
  flex-direction: column;
  align-items: center;
  /* justify-content: center; */
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

.demo-model {
  font-size: 16px;
  background-color: #fff;
  width: 330px;
  position: fixed;
  right: 40px;
  z-index: 10;
  margin: 0;
  right: 12px;
  top: 100px;
  box-sizing: border-box;
  background-repeat: no-repeat;
  background-size: 100%;
  box-shadow: 0 4px 25px 0 rgba(4, 40, 60, 0.18);
  overflow: hidden;
  background: #eff2f5;
  border-radius: 20px;
}

.iframe {
  height: 680px;
  width: 375px;
  border-radius: 20px;
}
</style>
