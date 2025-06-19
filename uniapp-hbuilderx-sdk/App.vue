<script>
export default {
  onLaunch: function () {
    uni.onNativeEventReceive((event, data) => {
      console.log(`小程序收到宿主消息，事件：${event}，消息：${JSON.stringify(data)}`);
    })
    console.log('App Launch')
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
