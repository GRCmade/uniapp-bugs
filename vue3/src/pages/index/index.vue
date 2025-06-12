<template>
  <view>
    <button @click="click">button</button>
    <view class="image-list">
      <view v-for="(item, index) in imageList" :key="item" @click="clickImage(index)">
        <image :src="item" mode="widthFix" />
      </view>
    </view>
  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

const imageList = ref<string[]>([
  'https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250610144702277.png',
  'https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250609172511009.png',
  'https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250606152202354.png',
  'https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250604144729362.png'
])

const ls = ref<number[]>([])
const click = () => {
  ls.value.push(1)
  ls.value.push(2)
  ls.value.push(3)
  uni.request({
    url: 'http://192.168.31.239:3000/api/test',
    method: 'POST',
    data: {
      data: ls.value
    },
    success: res => {
      console.log(res)
    },
    fail: err => {
      console.log('fail', err)
    }
  })
}

const clickImage = (item: number) => {
  uni.previewImage({
    urls: imageList.value,
    current: item
  })
}
</script>

<style>
.image-list {
  display: flex;
  flex-wrap: wrap;
}
.image-list image {
  width: 100px;
  height: 100px;
}
</style>
