<template>
  <view>
    <button @click="click">button</button>
  </view>
</template>

<script lang="ts" setup>
import { onShow } from '@dcloudio/uni-app'
onShow(() => {
  console.log('页面显示')
})
const click = () => {
  uni.chooseImage({
    count: 1,
    success: res => {
      console.log('选择的图片:', res.tempFilePaths)
    },
    fail: err => {
      console.error('选择图片失败:', err)
    }
  })
}
</script>

<style></style>
