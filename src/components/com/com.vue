<template>
  <view>console mounted</view>
</template>

<script lang="ts" setup>
import {
  onMounted
} from 'vue';

onMounted(() => {
  console.info('onMounted');
});
</script>