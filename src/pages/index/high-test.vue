<template>
  <view class="h_wrapper">

    <view class="h_header">
      <text>测试内容</text>
      <text>测试内容</text>
      <text>测试内容</text>
      <text>测试内容</text>
    </view>

    <view class="h_body"></view>

    <view class="h_footer"></view>

  </view>
</template>

<script setup>
  const open = () => {
    console.log('i m fine')
  }

  defineExpose({
    open
  })
</script>
<style>
  .h_wrapper {
    height: 100%;
    display: flex;
    flex-direction: column;
  }
</style>