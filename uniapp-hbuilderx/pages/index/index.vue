<template>
  <view>
    <button @click="click">button</button>
    <button @click="hideLoading">hideLoading</button>
  </view>
</template>

<script lang="ts" setup>
const click = () => {
  uni.showLoading({
    title: '加载中',
    mask: true
  })
  setTimeout(() => {
    uni.hideLoading()
  }, 4000)
}

const hideLoading = () => {
  uni.hideLoading()
}
</script>

<style></style>
