<template>
  <view>
    <button @click="click">click</button>
    <uni-badge text="1"></uni-badge>
    <uni-badge text="2" type="success" @click="bindClick"></uni-badge>
    <uni-badge text="3" type="primary" :inverted="true"></uni-badge>
    <com></com>
  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  methods: {
    click() {
      // uni.navigateTo({
      //   url: '/pages/index/index-next'
      // })
      console.log("1. 调用前");
      uni.getSystemInfo({
        success: function (res) {
          console.log('getSystemInfo',res.appName)
        }
      });
			uni.setClipboardData({
				data: 'hello',
				success: function () {
					console.log('setClipboardData,success');
				}
			});

      console.log("2. 调用后");
    }
  }
}
</script>


<style></style>
