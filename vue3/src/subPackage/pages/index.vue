<template>
  <view>
    <text>subpage</text>
    <button @click="click">click</button>
  </view>
</template>

<script lang="ts" setup>
import { test } from '../utils/test'
const click = () => {
  test()
}
</script>
