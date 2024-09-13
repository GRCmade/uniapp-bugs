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

	defineOptions({
		name: "TestSub",
	});
	const props = defineProps({
		options: {
			type: [Array, Object],
			default: () => [],
		},
	});
</script>
<template>
	<view class="test-sub">
		<view>子组件</view>
		<template v-for="(item, index) in options" :key="index">
			<slot :name="item.prop">
				<!-- {{ item.prop }} -->
			</slot>
		</template>
	</view>
</template>
<style lang="scss">
	.test-sub {}
</style>