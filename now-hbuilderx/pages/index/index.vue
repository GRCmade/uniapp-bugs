<template>
  <view>
    <!-- <uni-badge text="1"></uni-badge> -->
    <!-- <com></com> -->
    <button @click="chooseImage">chooseImage</button>
    <button @click="chooseFile">chooseFile</button>
    <button @click="chooseVideo">chooseVideo</button>

  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const chooseImage = () => {
  uni.chooseImage({
    sizeType: ['original', 'compressed'],
    sourceType: ['album', 'camera'],
    success: ({ tempFilePaths, tempFiles }) => { },
    fail: (error) => {
      console.log("error", error)
    }
  })
}
const chooseFile = () => {
  uni.chooseFile({
    success: ({ tempFilePaths, tempFiles }) => { },
    fail: (error) => {
      console.log("error", error)
    }
  })
}
const chooseVideo = () => {
  uni.chooseVideo({
    success: () => { },
    fail: (error) => {
      console.log("error", error)
    }
  })
}
</script>


<style></style>
