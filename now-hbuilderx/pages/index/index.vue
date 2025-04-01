<template>
  <view>
    <button @click="click">click 123 </button>
    <uni-badge text="1"></uni-badge>
    <com></com>
  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const str = ref<string>('123')
const click = () => {
  console.log('click', str.value)
  uni.uploadFile({
    url: 'http://192.168.1.100:8080/upload',
    filePath: '/Users/gaoruicheng/Documents/DcloudProject/uni-app-next/packages/uni-h5/dist/dev/uni.css',
    name: 'file',
    formData: {
      name: 'test'
    },
    success: (res) => {
      console.log('success', res)
    },
    fail: (err) => {
      console.log('fail', err)
    }
  })
}
</script>


<style></style>
