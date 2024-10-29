<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>


<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				const app = getApp().globalData
				console.log(JSON.stringify(app))
			}
		}
	}
</script>


<style></style>