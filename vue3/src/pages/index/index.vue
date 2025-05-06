<template>
  <view>
    <!-- <uni-badge text="1"></uni-badge> -->
    <!-- <com></com> -->
    <button @click="click">click 123</button>
  </view>
</template>

<script lang="ts" setup>
  import { ref } from 'vue'
  const num = ref(0)
  const click = () => {
    console.log(num)
  }
</script>

<style></style>
