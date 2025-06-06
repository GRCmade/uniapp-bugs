<template>
  <view>
    当前页面： index-next
    <button @click="click">index-next</button>
  </view>
</template>

<script>
export default {
  data() {
    return {}
  },
  onLoad(options) {
    console.log('onload-options', options)
    let pages = getCurrentPages()
    console.log('getCurrentPages-options', pages[pages.length - 1].options)
  },
  methods: {
    click() {
      uni.navigateTo({
        url: '/pages/index/index-next-next'
      })
    }
  }
}
</script>

<style></style>
