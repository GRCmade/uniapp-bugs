<template>
	<view>
		<view class="page-body">
			<view class="page-section page-section-gap">
				<map  show-location style="width: 100%; height: 300px;"  :markers="covers">
				</map>
			</view>
		</view>
	</view>
</template>


<script>
export default {
	data() {
		return {
			id:0, // 使用 marker点击事件 需要填写id:latitude="latitude" :longitude="longitude"
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
	methods: {

	}
}
</script>

<style>

</style>
