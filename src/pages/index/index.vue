<template>
  <view>
    <button @click="click">click</button>
    <uni-badge text="1"></uni-badge>
    <com></com>

  </view>
</template>


<script lang="ts">
export default {
  data() {
    return {}
  },
  methods: {
    click() {
      // uni.navigateTo({
      //   url: '/pages/index/index-next'
      // })
      const res: string = '1'
      console.log(res)
    }
  }
}
</script>


<style></style>
