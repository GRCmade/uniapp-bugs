<template>
	<view>
		<button @click="click">nav</button>
		{{appid}}
		<uni-data-select collection="test" field="name as text,_id as value" label="应用选择"
			v-model="appid"></uni-data-select>
	</view>
</template>


<script>
	export default {
		data() {
			return {
				appid: ''
			}
		},
		methods: {
			click() {
				uni.navigateTo({
					url: "/uni_modules/test/pages/test/list"
				})
			}
		}
	}
</script>


<style></style>