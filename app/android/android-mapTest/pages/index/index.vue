<template>
		<view>
			<map id="map" :latitude="latitude" :longitude="longitude" :scale="scale"
				:markers="markerList" style="width: 100%; height: 1000px}"></map>
		</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello',
				latitude: 39.915,
				longitude: 116.404,
				scale: 8,
				markerList: []
			}
		},
		onLoad() {
			this.markerList.push({
				id: 1,
				latitude: 39.815,
				longitude: 116.404,
				iconPath: "/static/marker.svg",
				callout: {
					content: "设备编号：11111" + "\n" + 
									"安装地址：222222"
				}
			})
			console.log(this.markerList)
		},
		methods: {

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
</style>
