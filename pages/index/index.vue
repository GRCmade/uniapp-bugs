<template>
  <view class="content">
    <SomeTest ref="someRef" :content="someText"></SomeTest>
    <HighTest ref="testRef"></HighTest>
    <button @click="onButton">点击获取ref 3</button>
  </view>
</template>

<script setup lang="ts">
import { ref } from 'vue'
import SomeTest from './some-test.vue'
import HighTest from './high-test.vue'

const someText = ref('我是父组件内的内容！')

const someRef = ref(null)
const testRef = ref(null)

const onButton = () => {
  console.log('---czm someRef =', someRef.value)    // 这里打印一直是 null
  someRef.value?.open()
  console.log('----czm testRef = ', testRef.value)  // 可以正常获取到组件
  testRef.value?.open()
}

</script>

<style>
.content {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  width: 100%;
}
</style>