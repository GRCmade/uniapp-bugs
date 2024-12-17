<template>
	<view>
		<view class="page-body">
			<view class="page-section page-section-gap">
				<map style="width: 100%; height: 300px;" :scale="scale" :latitude="latitude" :longitude="longitude" :markers="covers">
				</map>
			</view>
		</view>
		<button @click="click(8)">设置8倍</button>
		<button @click="click(14.5)">设置14.5倍</button>
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
			scale:10,
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
		click(item){
			this.scale = item
		}
	}
}
</script>

<style></style>