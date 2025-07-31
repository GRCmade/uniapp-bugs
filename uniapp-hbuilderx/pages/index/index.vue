<template>
	<view>
		<view class=""> slider : {{slider}}
		</view>
		<slider :value="slider" @change="sliderChange" step="1" />
		<button @click="setScreenBrightness(20)">setScreenBrightness 20</button>
		<button @click="setScreenBrightness(-10)">setScreenBrightness -10</button>
		<button @click="setScreenBrightness(1999)">setScreenBrightness 1999</button>
		<button @click="getScreenBrightness">getScreenBrightness</button>
		<button @click="setKeepScreenOn(true)">setKeepScreenOn true</button>
		<button @click="setKeepScreenOn(false)">setKeepScreenOn false</button>
	</view>
</template>
<script lang="ts" setup>
	import { ref } from 'vue'

	const setScreenBrightness = (value : number) => {
		console.log("click")
		slider.value = value
		uni.setScreenBrightness({
			value: value / 100,
			success: function () {
				console.log('success')
			},
			fail(res) {
				console.log('fail', res)
			}
		})
	}
	const getScreenBrightness = () => {
		uni.getScreenBrightness({
			success: function (res) {
				console.log('屏幕亮度值：' + res.value)
				uni.showToast({
					title: '屏幕亮度值：' + res.value
				})
			},
			fail() {
				console.log('fail')
			}
		})
	}

	const slider = ref(60)

	const sliderChange = (e) => {
		slider.value = e.detail.value
		setScreenBrightness(slider.value)
		console.log('value 发生变化：' + e.detail.value)
	}

	setScreenBrightness(slider.value)

	const setKeepScreenOn = (value : Boolean) => {
		uni.setKeepScreenOn({
			keepScreenOn:value,
			success(res) {
				console.log("res", res)
			},
			fail() {
				console.log('fail')
			},
		})
	}
</script>
<style></style>