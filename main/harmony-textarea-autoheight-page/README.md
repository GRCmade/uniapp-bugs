======== README.md ========

# 鸿蒙上 textarea 配置 autoheight 页面还是会顶出去

需要主要的是,只有在textarea 非常高的时候才能够复现

```
<template>
  <view>
    <view>{{ text }}</view>
    <textarea class="textarea" v-model="text" auto-height	/>
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
  border: 1px solid #ccc;
  border-radius: 10px;
  padding: 10px;
  box-sizing: border-box;
  box-sizing: border-box;
}
</style>

```


![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250611115451545.png)
======== END ========
