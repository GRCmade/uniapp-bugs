<template>
	<view>
		<view class="page-body">
			<view class="page-section page-section-gap">
				<map  id="map" style="width: 100%; height: 300px;" :latitude="latitude"
					:longitude="longitude" :markers="covers">
				</map>
			</view>
		</view>
		<button @click="click">click</button>
	</view>
</template>


<script>
	export default {
		data() {
			return {
				id: 0, // 使用 marker点击事件 需要填写id
				title: 'map',
				latitude: 39.909,
				longitude: 116.39742,
				covers: [{
					latitude: 39.909,
					longitude: 116.39742,
					iconPath: '/static/logo.png'
				}, {
					latitude: 39.90,
					longitude: 116.39,
					iconPath: '/static/logo.png'
				}]
			}
		},
		onReady() {
			this.mapContext = uni.createMapContext("map", this);

			this.covers.push({
				latitude: 31.850769,
				longitude: 117.152592,
				iconPath: '/static/logo.png'
			})
			
		},
		methods: {
			click(){
				this.mapContext.moveToLocation({
					latitude: 31.850769,
					longitude: 117.152592,
				});
			}
		}
	}
</script>


<style>

</style>