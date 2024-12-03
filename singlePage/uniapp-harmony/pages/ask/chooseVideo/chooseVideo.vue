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
				var self = this;
				uni.chooseVideo({
					sourceType: ['camera', 'album'],
					success: function(res) {
						console.log(JSON.stringify(res))
					}
				});
			}
		}
	}
</script>


<style></style>