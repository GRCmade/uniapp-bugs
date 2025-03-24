<script>
export default {
  onLaunch: function () {
    console.log('App Launch')
    uni.addInterceptor('switchTab', {
      invoke(args) {
        console.log("切换tab", args)
        // if (args.url == '/pages/tabbar/tabbar-2/tabbar-2') {
        //   uni.navigateTo({
        //     url: '/pages/index/index-next'
        //   })
        //   return false
        // }
      }
    })
  },
  onShow: function () {
    console.log('App Show')
  },
  onHide: function () {
    console.log('App Hide')
  }
}
</script>

<style>
/*每个页面公共css */
</style>
