<template>
	<view>
		<view class="page-body">
			<view class="page-section page-section-gap">
				<map style="width: 100%; height: 300px;" :latitude="latitude" :longitude="longitude" :markers="covers" @callouttap="onMarkerClick">
				</map>
			</view>
		</view>
	</view>
</template>


<script>
export default {
	data() {
		return {
			id:0, // 使用 marker点击事件 需要填写id
			title: 'map',
			latitude: 39.909,
			longitude: 116.39742,
			covers: [{
				id:101,
				latitude: 39.909,
				longitude: 116.39742,
				iconPath: '/static/logo.png',
				width:100,
				height:100,
				callout:{
					content:'yuhe'
				}
			}, {
				id:102,
				latitude: 39.90,
				longitude: 116.39,
				width:100,
				height:100,
				iconPath: '/static/logo.png'
			}]
		}
	},
	methods: {
		onMarkerClick(e){
			console.log("onMarkerClick",e)
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
