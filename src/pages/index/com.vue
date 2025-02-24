<template>
  com
	<view :id="dropMenuId">view</view>
  <view>123</view>
</template>
<script setup lang="ts">
	import { ref } from 'vue';

	const dropMenuId = ref<string>(`dropMenuId${123123}`)

	const click = () => { }
</script>
<script lang="ts">
export default {
  name: 'wd-drop-menu',
  options: {
    virtualHost: true,
    addGlobalClass: true,
    styleIsolation: 'shared'
  }
}
</script>
<style></style>