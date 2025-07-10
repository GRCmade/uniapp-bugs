<template>
  <view>
    <view>状态: {{ status }}</view>
    <button @click="startRequest">发送请求</button>
    <button @click="abortRequest" >中止请求</button>
  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

const status = ref('未开始')
let requestTask: any = null

const startRequest = () => {
  status.value = '请求中...'
  requestTask = uni.request({
    url: 'http://192.168.31.223:3001/set-timeout', //仅为示例，并非真实接口地址。
    method: 'GET',
    success: res => {
      console.log('success', res)
      status.value = '请求成功'
      requestTask = null
    },
    fail: res => {
      console.log('fail', res,status.value)
      // 检查是否是因为 abort 导致的失败
      if (status.value == '正在中止请求...') {
        status.value = '请求已中止'
      } else {
        status.value = '请求失败'
      }
      requestTask = null
    },
    complete: () => {
      console.log('complete')
    }
  })
}

const abortRequest = () => {
  if (requestTask) {
    requestTask.abort()
    status.value = '正在中止请求...'
  }
}
</script>

<style></style>
