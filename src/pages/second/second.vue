<template>
  <view>
    页面b
    <button @click="redirectTo">redirectTo页面a</button>
    <button @click="navigateBack">navigateBack页面a</button>
  </view>
</template>

<script setup lang="ts">
import { onDeactivated, onUnmounted } from 'vue'

function redirectTo() {
  uni.redirectTo({ url: '/pages/index/index' })
}
function navigateBack() {
  uni.navigateBack()
}
onUnmounted(() => {
  // alert('页面卸载，已销毁')
  console.log('second页面卸载')
})
onDeactivated(() => {
  // alert('页面失活，没有销毁')
  console.log('页面失活，没有销毁')
})
</script>

<style></style>
