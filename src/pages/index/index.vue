<template>
  <view>
    <button @click="click">relaunch click</button>
  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  methods: {
    click() {
      console.log("uni.canIUse('hideHomeButton')", uni.canIUse('hideHomeButton'))
      console.log("uni.canIUse('scanCode')", uni.canIUse('scanCode'))
      // uni.reLaunch({
      //   url: '/pages/index/relaunch'
      // })
    }
  }
}
</script>


<style></style>
