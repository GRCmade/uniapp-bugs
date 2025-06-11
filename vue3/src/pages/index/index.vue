<template>
  <view>
    <view>{{ text }}</view>
    <textarea class="textarea" v-model="text" auto-height />
  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const text = ref('')
</script>

<style lang="scss" scoped>
page {
  background-color: aqua !important;
}
.textarea {
  width: 100%;
  height: 100px;
  border: 1px solid red;
  border-radius: 10px;
  padding: 10px;
  box-sizing: border-box;
}
</style>
