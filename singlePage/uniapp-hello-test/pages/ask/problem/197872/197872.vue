<template>
	<view>
			<uni-datetime-picker type="datetime" v-model="datetimesingle" @change="changeLog" />
	</view>
</template>

<script>
	export default {
		data() {
			return {
				datetimesingle:''
			}
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
