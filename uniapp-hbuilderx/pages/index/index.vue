<template>
  <view>
    <button @click="click">click</button>
    <canvas canvas-id="myCanvas"></canvas>
  </view>
</template>

<script>
export default {
  data() {
    return {}
  },
  methods: {
    click() {
      uni.canvasGetImageData({
        canvasId: 'myCanvas',
        x: 0,
        y: 0,
        width: 100,
        height: 100,
        success(res) {
          console.log("uniapp")
          console.log(JSON.stringify(res))
          console.log(JSON.stringify(res.data["0"]))
          // console.log(res.width) // 100
          // console.log(res.height) // 100
          // console.log(res.data instanceof Uint8ClampedArray) // true
          // console.log(res.data.length) // 100 * 100 * 4
        }
      })
    }
  }
}
</script>

<style></style>
