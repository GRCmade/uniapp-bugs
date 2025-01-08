<template>
  <view class="h_wrapper">

    <view class="h_header">
      <text>{{ '---' + props.content + '---' }}</text>
    </view>

    <view class="h_body"></view>

    <view class="h_footer"></view>

  </view>
</template>

<script setup>
  const props = defineProps({
    content: String
  }) 

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