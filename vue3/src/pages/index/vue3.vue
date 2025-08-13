<template>
  uniappx
  <view class="line wrapper">
    <view class="left">left</view>
    <view class="right">right</view>
  </view>
  uniapp
  <view class="line">
    <view class="wrapper">
      <view class="left">left</view>
      <view class="right">right</view>
    </view>
  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const radioValue = ref('选项1')
const click = () => {}
</script>

<style>
page {
  display: flex;
  flex-direction: column;
}

.line {
  display: grid;
  grid-template-columns: 1fr;
  align-items: center;
  height: 100px;
}

.wrapper {
  display: grid;
  grid-template-columns: 1fr auto;
  gap: 10px;
  width: 100%;
}

.left {
  background-color: #d0d0d0;
}

.right {
  background-color: #b0b0b0;
}
</style>
