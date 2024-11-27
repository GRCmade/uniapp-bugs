<template>
  <!-- DOM 元素绑定到 ref -->
	<uni-popup ref="popup" type="top">
		<view ref="domRef" id="qwer">66666</view>
	</uni-popup>
	<h1 ref="domRef" id="qwer11">66666</h1>
</template>

<script setup lang="ts">
import { ref, onMounted } from 'vue';

// 声明 ref 引用
const popup = ref(null);

onMounted(() => {
  // Vue 模板渲染完成后，popup.value 会被赋值为绑定的 DOM 元素
  console.log('1 -->', popup); // ref 对象
  console.log('2 -->', popup.value); // DOM 元素
});
</script>


<style lang="scss" scoped>
/* 样式部分 */
</style>