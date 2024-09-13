<script setup>
	import {
		ref,
		watch,
		computed,
		watchEffect,
		onMounted,
		onUnmounted,
		toValue
	} from "vue";
	import TestSub from "./components/test-sub.vue";
	defineOptions({
		name: "Test",
	});
	const props = defineProps({});

	const options = ref([{
			label: "选项1",
			prop: "slot1",
		},
		{
			label: "选项2",
			prop: "slot2",
		},
		{
			label: "选项3",
			prop: "slot3",
		},
	]);
</script>
<template>
	<view class="test">
		<view class="">测试环境</view>
		<TestSub :options="options">
			<!-- <template v-slot:default> </template> -->
			<template v-slot:slot1>
				<view>slot1插槽内容</view>
			</template>
			<template v-slot:slot2>
				<view>slot2插槽内容</view>
			</template>
			<template v-slot:slot3>
				<view>slot3插槽内容</view>
			</template>
		</TestSub>
	</view>
</template>
<style lang="scss">
	.test {}
</style>