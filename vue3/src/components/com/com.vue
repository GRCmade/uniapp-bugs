<template>
  <button>
    <slot />
  </button>
</template>
<script lang="ts">
export default {
  inheritAttrs: false
}
</script>
<script setup lang="ts">
import { useAttrs } from 'vue'
const attrs = useAttrs()
console.log('attr', attrs)
</script>
