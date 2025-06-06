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
