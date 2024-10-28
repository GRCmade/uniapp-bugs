<template>
	<view>
		<view class="page-body">
			<view class="page-section page-section-gap" v-if="show">
				<map style="width: 100%; height: 300px;" :latitude="latitude" :longitude="longitude" :markers="covers"
					:rotate="rotate">
				</map>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				rotate: 62, //倾斜角度  
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
				}],
				show:true
			}
		},
		methods: {

		}
	}
</script>

<style>

</style>