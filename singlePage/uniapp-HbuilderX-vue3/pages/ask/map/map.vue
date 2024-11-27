<template>
			<map style="width: 750rpx; height: 90vh;"
			:latitude="latitude" :longitude="longitude"
			:scale='scale'>
			</map>
			<button @click="changeScale">改变</button>
</template>

<script>
	export default {
		data() {
			return {
				latitude: 39.91092,
				longitude: 116.41338,
				scale: 6
			}
		},
		onLoad() {

		},
		methods: {
			changeScale() {
				this.scale == 7.5 ? this.scale = 5 : this.scale = 7.5;
				this.latitude = 30.651696; // 30.651696
				this.longitude = 104.076452; // 104.076452
				// this.latitude = 25.046432; // 30.651696
				// this.longitude = 102.709372; // 104.076452
			}
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>
