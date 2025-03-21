<template>
  <view>
    <button @click="click">click</button>
    <com></com>

  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  onLoad() {
    uni.addInterceptor('switchTab', {
      invoke(args) {
        console.log("切换tab", args)
        if(args.url == '/pages/tabbar/tabbar-2/tabbar-2') {
          uni.navigateTo({
            url: '/pages/index/index-next'
          })
          return false
        }
      }
    })
  },
  methods: {
    click() {
      // uni.navigateTo({
      //   url: '/pages/index/index-next'
      // })

    }
  }
}
</script>


<style></style>
