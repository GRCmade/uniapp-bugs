<template>
  <view>
    <button @click="click">button</button>
  </view>
</template>

<script lang="ts" setup>
const click = () => {
  uni.navigateTo({
    url: '/pages/index/index-next'
  })
}
</script>

<style></style>
