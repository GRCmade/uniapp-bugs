<template>
  <view>
    <text>subpage</text>
    <button @click="click">click</button>
  </view>
</template>

<script lang="ts" setup>
import { test } from '../utils/test'
import areas from '@/subPackage/static/areas.json'

console.log(areas)

const click = () => {
  test()
}
</script>
