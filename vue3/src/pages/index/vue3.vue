<template>
  <view>
    <button @click="setScreenBrightness">setScreenBrightness</button>
    <button @click="getScreenBrightness">getScreenBrightness</button>
  </view>
</template>
<script lang="ts" setup>
const setScreenBrightness = () => {
	console.log("click")
  uni.setScreenBrightness({
    value: 0.6,
    success: function () {
      console.log('success')
    },
		fail() {
			console.log('fail')
		}
  })
}
const getScreenBrightness = () => {
  uni.getScreenBrightness({
    success: function (res) {
      console.log('屏幕亮度值：' + res.value)
    },
		fail() {
			console.log('fail')
		}
  })
}
</script>
<style></style>
