<template>
  <view>
    <button @click="click2">switchtab2</button>
    <button @click="click1">switchtab1</button>
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
        console.log("切换tab index", args)
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
    click2() {
      // uni.navigateTo({
      //   url: '/pages/index/index-next'
      // })
			uni.switchTab({
				url:"/pages/tabbar/tabbar-2/tabbar-2"
			})
    },
		click1() {
		  // uni.navigateTo({
		  //   url: '/pages/index/index-next'
		  // })
			uni.switchTab({
				url:"/pages/tabbar/tabbar-1/tabbar-1"
			})
		}
  }
}
</script>


<style></style>
