<template>
  <button @click="click">click 123</button>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

const num = ref(0)

const click = () => {
  console.log(num)
}
</script>

<style></style>
