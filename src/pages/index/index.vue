<template>
  <view>
    <button @click="click">click</button>
    <uni-badge text="1"></uni-badge>
    <com></com>
  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const str = ref<string>('123')
const click = () => {
  console.log('click', str.value)
}
</script>


<style></style>
