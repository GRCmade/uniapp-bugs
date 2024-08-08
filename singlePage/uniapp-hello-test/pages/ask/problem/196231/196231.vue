<template>
	<view>

	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		onLoad() {
			uni.getLocation({
				type: 'wgs84',
				highAccuracyExpireTime: 5000,
				isHighAccuracy: true,
				success: function(res) {
					console.log('当前位置的经度：' + res.longitude);
					console.log('当前位置的纬度：' + res.latitude);
					commit('SET_LNGLAT_DATA', res)
				}
			});
		},
		methods: {

		}
	}
</script>

<style>

</style>