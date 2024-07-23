<template>
	<view>
		<slot :data="data"></slot>
	</view>
</template>

<script setup>
import { ref } from 'vue';
	const data = ref([1,2,3])
</script>

<style>

</style>