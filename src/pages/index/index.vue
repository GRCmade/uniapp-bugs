<template>
  <view>
    <button @click="click">click 123 </button>

  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
type Style = {
	name:string
}
const styles = ref<Style[]>([]);
const click = () => {
  console.log(styles.value)
}
</script>


<style></style>
