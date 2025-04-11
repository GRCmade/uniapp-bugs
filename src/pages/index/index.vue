<template>
  <view>
    <!-- <uni-badge text="1"></uni-badge> -->
    <!-- <com></com> -->
    <button @click="click">click 123 </button>

  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const click = () => {
  uni.navigateTo({
    url: '/subPackage/pages/index'
  })
}
</script>


<style></style>
