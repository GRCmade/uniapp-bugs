<template>
  <com class="btn" name="123" :d='1' :dname='undefined' :func="doCalc" @click="doCalc"><text>index</text></com>
</template>
<script setup lang="ts">
import BtnCustom from '@/components/BtnCustom/BtnCustom.vue'
function doCalc() {
  console.log(1 + 3)
}
</script>
<style scoped>
.btn {
  background-color: aqua;
}
</style>
