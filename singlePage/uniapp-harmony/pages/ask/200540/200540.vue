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
				console.log("click");
				uni.getLocation({
					type: 'wgs84',
					geocode: true,
					isHighAccuracy: true,
					success: function(res) {
						console.log('location===', JSON.stringify(res));
					},
					fail(e) {
						console.log(JSON.stringify(e));
					}
				})
			}
		},
	}
</script>


<style></style>