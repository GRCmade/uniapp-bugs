<template>
  <view>
    <button @click="click">button</button>
  </view>
</template>

<script lang="ts" setup>
import { onMounted } from 'vue'
onMounted(() => {
  console.log('页面 onMounted 执行')
})
const click = () => {}
</script>

<!-- <script>
export default {
  data() {
    return {}
  },
  mounted() {
    console.log('页面 Mounted 执行')
  }
}
</script> -->

<style></style>
