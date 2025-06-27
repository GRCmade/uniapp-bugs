<template>
	<view>
		<view v-if="showMap">
			<map id="map" :latitude="latitude" :longitude="longitude"></map>
		</view>
		<button @click="click">button</button>
		<button @click="showMapvalue">showMapvalue</button>
		<button @click="canvas">canvas</button>
		<button @click="showcvalue">showcvalue</button>
		<view v-if="showcanvas">
			<canvas style="width: 300px; height: 200px;" canvas-id="myCanvas" id="myCanvas"></canvas>
		</view>
	</view>
</template>
<script lang="ts" setup>
	import { onReady } from '@dcloudio/uni-app'
	import { getCurrentInstance, ref } from 'vue'
	const heading = ref(0)
	const longitude = ref()
	const latitude = ref()
	const showMap = ref(false)
	const showcanvas = ref(false)
	const destination = ref({ longitude: 0, latitude: 0 })

	const showMapvalue = () => {
		showMap.value = !showMap.value
	}
	
	const showcvalue = () => {
		showcanvas.value = !showcanvas.value
	}

	const canvas = () => {
		const ctx = uni.createCanvasContext('myCanvas')
		
		// Draw coordinates
		ctx.arc(100, 75, 50, 0, 2 * Math.PI)
		ctx.setFillStyle('#EEEEEE')
		ctx.fill()
		
		ctx.beginPath()
		ctx.moveTo(40, 75)
		ctx.lineTo(160, 75)
		ctx.moveTo(100, 15)
		ctx.lineTo(100, 135)
		ctx.setStrokeStyle('#AAAAAA')
		ctx.stroke()
		
		ctx.setFontSize(12)
		ctx.setFillStyle('black')
		ctx.fillText('0', 165, 78)
		ctx.fillText('0.5*PI', 83, 145)
		ctx.fillText('1*PI', 15, 78)
		ctx.fillText('1.5*PI', 83, 10)
		
		// Draw points
		ctx.beginPath()
		ctx.arc(100, 75, 2, 0, 2 * Math.PI)
		ctx.setFillStyle('lightgreen')
		ctx.fill()
		
		ctx.beginPath()
		ctx.arc(100, 25, 2, 0, 2 * Math.PI)
		ctx.setFillStyle('blue')
		ctx.fill()
		
		ctx.beginPath()
		ctx.arc(150, 75, 2, 0, 2 * Math.PI)
		ctx.setFillStyle('red')
		ctx.fill()
		
		// Draw arc
		ctx.beginPath()
		ctx.arc(100, 75, 50, 0, 1.5 * Math.PI)
		ctx.setStrokeStyle('#333333')
		ctx.stroke()
		
		ctx.draw()

	}

	const click = () => {
		const instance = getCurrentInstance()
		uni.createMapContext('map', instance).getCenterLocation({
			complete: res => {
				console.log(res)
			}
		})
	}
</script>
<style></style>