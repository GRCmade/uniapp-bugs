<template>
  <view>
    <!-- <uni-badge text="1"></uni-badge> -->
    <!-- <com></com> -->
    <view class="outer" @click="outerClick">
      外层元素
      <button @click.stop="innerClick">阻止冒泡按钮</button>
      <button @click="normalClick">普通按钮</button>
      <com @click.stop="handler"></com>
    </view>

  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

const outerClick = () => {
  console.log('外层元素被点击了')
}

const handler = () => {
  console.log('组件被点击了')
}

const innerClick = () => {
  console.log('内层按钮被点击了，不会触发外层事件')
}

const normalClick = (e: Event) => {
  console.log('普通按钮被点击了，会触发外层事件')
  // 手动阻止冒泡的另一种方式
  // e.stopPropagation()
}
</script>


<style>
.outer {
  padding: 20px;
  background-color: #f5f5f5;
  border: 1px solid #ddd;
  margin: 20px;
}
</style>
