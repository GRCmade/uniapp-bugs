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
      uni.reLaunch({
        url: '/pages/index/relaunch'
      })
    }
  }
}
</script>


<style></style>
