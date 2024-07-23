<template>
	<child-component v-slot="data">
		使用了变量 {{data}}
	</child-component>
	<child-component v-slot="data">
		没有使用了变量
	</child-component>
	<child-component>
		什么都没有
	</child-component>
</template>

<script setup>
	import { ref } from 'vue';
	
</script>

<style>

</style>