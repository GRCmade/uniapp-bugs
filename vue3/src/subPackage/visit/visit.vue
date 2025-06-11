<template>
  <view>
    <text>visit</text>
  </view>
</template>
<script lang="ts" setup>
import { onMounted } from 'vue'
import areas from '@/subPackage/static/areas.json'

onMounted(() => {
  console.log(areas)
})
</script>
<style lang="scss" scoped></style>
