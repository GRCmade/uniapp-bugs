<template>
  <view>
    <!-- <uni-badge text="1"></uni-badge> -->
    <!-- <com></com> -->
    <button @click="click">click set-cookie </button>
    <button @click="clickData">click data </button>

  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const click = () => {
  uni.request({
    url: "http://192.168.31.148:3000/api/set-cookie",
    method: "GET",
    withCredentials:true,
    success(res) {
      console.log(res)
    }
  })
}

const clickData = () => {
  uni.request({
    url: "http://192.168.31.148:3000/api/cookie-data",
    method: "GET",
    withCredentials:true,
    success(res) {
      console.log(res)
    }
  })
}
</script>


<style></style>
