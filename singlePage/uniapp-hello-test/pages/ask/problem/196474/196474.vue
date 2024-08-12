<template>
	<view>
		<view class="page-body">
			<view class="page-section page-section-gap">
				<map style="width: 100%; height: 300px;" :latitude="latitude" :longitude="longitude" :markers="covers" @callouttap="markerTap">
				</map>
			</view>
		</view>
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
					iconPath: '/static/api.png',
					callout: {
						content: '故宫博物馆',
						display: 'ALWAYS',
						fontSize: 22,
						bgColor: '#0180CC',
						color: '#000',
						markerId: 1,
					},
				}, {
					latitude: 39.90,
					longitude: 116.39,
					iconPath: '../../../static/location.png'
				}]
			}
		},
		methods: {
			markerTap(e){
				console.log(e)
			}
		}
	}
</script>