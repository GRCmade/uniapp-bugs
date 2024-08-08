<template>
	<view>
		<view class="page-body">
			<view class="page-section page-section-gap">
				<map @tap.stop ref="mapref" id="map" style="width: 100%; height: 300px;" :latitude="latitude" :longitude="longitude"
					:markers="covers">
				</map>
			</view>
		</view>
		<view style="height: 1000rpx;">
			1
		</view>
		<button @click="click">click</button>
	</view>
</template>

<script setup>
	import {
		ref
	} from 'vue';
	let latitude = ref(39.909)
	let longitude = ref(116.39742)
	const mapref = ref()
	let covers = ref([{
		latitude: 39.909,
		longitude: 116.39742,
		iconPath: '/static/logo.png'
	}, {
		latitude: 39.90,
		longitude: 116.39,
		iconPath: '/static/logo.png'
	}])

	covers.value.push({
		latitude: 31.850769,
		longitude: 117.152592,
		iconPath: '/static/logo.png'
	})
	const click = ()=>{
		const mapContext = uni.createMapContext("map");
		mapContext.moveToLocation();
	}
	
</script>


<style>

</style>