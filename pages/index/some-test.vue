<template>
  <view class="h_wrapper">
    <view class="h_header">
      <text>{{ '---' + content + '---' }}</text>
    </view>

    <view class="h_body"></view>

    <view class="h_footer"></view>
  </view>
</template>

<script>
export default {
  props: {
    content: String
  },
  methods: {
    open() {
      console.log('i m fine')
    }
  }
}
</script>

<style>
.h_wrapper {
  height: 100%;
  display: flex;
  flex-direction: column;
}
</style>