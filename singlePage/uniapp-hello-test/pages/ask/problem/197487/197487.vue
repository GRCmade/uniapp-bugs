<template>
	<view>
		<uni-datetime-picker type="datetimerange" start="2024-8-29 9:20:20" end="2024-8-29 23:20:20" @change="change"></uni-datetime-picker>
	</view>
</template>

<script>
	// http://localhost:8080/pages/test/test/test
	export default {
		data() {
			return {
					start:getDate(new Date(),-60).fullDate,
					endDate:getDate(new Date(),30).fullDate
			}
		},
		methods: {
			change(e){
				console.log(e)
			}
		}
	}
</script>

<style>

</style>
