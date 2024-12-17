<template>
  <view class="content">
    <image class="logo" src="/static/logo.png"></image>
    <view class="text-area" @click="click">
      <text class="title">{{ title }}</text>
    </view>
    <button @click="click2">system</button>
    <button @click="click3">nav</button>
    <!-- <uni-load-more status="more"></uni-load-more> -->
  </view>
</template>

<script setup lang="ts">
  import { ref } from 'vue';
  const title = ref('Hello World yuhe test 1');
  const click = () => {
    uni.navigateTo({
      url: '/pages/mock/index',
    });
  };
  const click2 = () => {
    console.log('system', JSON.stringify(uni.getSystemInfoSync()));
  };
  const click3 = () => {
    uni.navigateTo({
      url: '/pages/index/index/index',
    });
  };
</script>

<style scoped lang="scss">
  .content {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
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
