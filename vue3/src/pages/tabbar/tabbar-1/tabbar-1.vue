<template>
	<uni-data-select v-model="value" :localdata="range" @change="change"></uni-data-select>
</template>
<script>
	export default {
		data() {
			return {
				value: 0,
				range: [{ value: 0, text: 'tabbar1' }, { value: 1, text: '足球' }, {
					value: 2,
					text: '2541200000010427607625412000000104276076'
				}]
			}
		},
		methods: {}
	}
</script>
<style></style>