<template>
  <view>
    页面a
    <!-- 引起bug的代码，以下条件缺一不可
     1：页面有for循环遍历的swiper-item子组件，有没有swiper父组件都无所谓
     2：swiper-item本身或者子组件有ref属性并在setup中已定义
     3：两个页面通过uni.redirectTo互相跳转
      -->
    <swiper v-if="isShowSwiper">
      <swiper-item v-for="item in 2" :key="item">
        <view ref="itemRef">{{ item }}</view>
      </swiper-item>
    </swiper>

    <button @click="redirectSecond" type="warn">redirectTo二级页面</button>
    通过uni.redirectTo跳转到页面b，页面b再uni.redirectTo回页面a，会导致页面b没有正常销毁
    <button @click="toSecond" type="primary">navigateTo二级页面</button>
    通过navigateTo跳转到页面b，页面b再正常返回或重定向，页面b会正常销毁
  </view>
</template>

<script setup lang="ts">
import { ref, onUnmounted } from 'vue'
import { onLoad, onShow } from '@dcloudio/uni-app'

const isShowSwiper = ref(true)

const itemRef = ref()

function redirectSecond() {
  uni.redirectTo({ url: '/pages/second/second' })
}
function toSecond() {
  uni.navigateTo({ url: '/pages/second/second' })
}
onShow(() => {
  // console.log('页面a', getCurrentPages())
})

onUnmounted(() => {
  // alert('页面卸载，已销毁')
  console.log('index页面卸载')
})
</script>

<style></style>
