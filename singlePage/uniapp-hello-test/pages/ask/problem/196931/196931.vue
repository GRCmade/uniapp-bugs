<template>
	<view>
		{{deviceType}}
	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		computed: {
			deviceType: function() {
				return uni.getDeviceInfo().deviceType;
			}
		},
		methods: {

		}
	}
</script>

<style>

</style>