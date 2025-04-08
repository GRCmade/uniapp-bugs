<template>
  <view>
    <!-- <uni-badge text="1"></uni-badge> -->
    <!-- <com></com> -->
    <button @click="click">click 123 </button>

  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
// 测试
const click = () => {
  const loadingOpts = { title: 'loading...' }
  uni.showLoading(loadingOpts)
  setTimeout(() => {
    uni.hideLoading()
    console.log(loadingOpts) // loadingOpts 对象已经被修改
    uni.showToast({ title: 'success' })
    setTimeout(() => {
      console.log(loadingOpts) // loadingOpts 对象已经被 showToast 方法修改

      // 这里会出现问题，loading 的提示内容会变成 'success' 而非 'loading...'
      uni.showLoading(loadingOpts)
    }, 2000)
  }, 2000)
}
</script>


<style></style>
