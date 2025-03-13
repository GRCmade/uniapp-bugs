<template>
  <view>
    <button @click="click">caniuse click</button>
  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  methods: {
    click() {
      // uni.openBluetoothAdapter() 这个没在 todo 中写，就没报错
			// setScreenBrightness 这个在 todo中写了，就不会报错，会输出不支持
      console.log("app 支持 h5 不支持 openBluetoothAdapter", uni.canIUse('openBluetoothAdapter'))
      console.log("app 不支持 h5 支持 chooseFile", uni.canIUse('chooseFile'))
      console.log("app 支持 h5 支持 getNetworkType", uni.canIUse('getNetworkType'))
      console.log("app 不支持 h5 不支持 createMediaContainer", uni.canIUse('createMediaContainer'))
      // uni.reLaunch({
      //   url: '/pages/index/relaunch'
      // })
    }
  }
}
</script>


<style></style>
