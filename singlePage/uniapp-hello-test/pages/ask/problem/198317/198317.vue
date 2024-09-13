<template>
	<view v-for="item in test" :key="item">  
	    <view v-if="patt.test(item)">{{ item }}</view>  
	    <view v-else>{{ item + 'false' }}</view>  
	  </view>
</template>

<script setup>
	import { ref } from 'vue';

const patt = /[,，;；]/;  
const test = ref(';1k2,'.split(''));  
</script>

<style>
</style>