<template>
	<view>
		<button @click="click">click</button>
		<com @click="click"></com>
	</view>
</template>

<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				console.log("index.vue - click")
			}
		}
	}
</script>


<style></style>