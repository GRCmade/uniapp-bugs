<template>
  <view class="content">
    <image class="logo" src="/static/logo.png"></image>
    <view class="text-area">
      <text class="title">{{ title }}</text>
    </view>
    <view class="text-area">
      <text class="title">接收参数:{{ data }}</text>
    </view>
    <button @click="sendNativeEvent">sendNativeEvent</button>
  </view>
</template>

<script>
export default {
  data() {
    return {
      title: 'index',
      data: ''
    }
  },
  onLoad() {
    const launchOptions = uni.getLaunchOptionsSync()
    if (launchOptions) {
      console.log("接收到参数:", JSON.stringify(launchOptions))
      this.data = launchOptions
    }
  },
  methods: {
    sendNativeEvent() {
      uni.sendNativeEvent('unimp-event', {
        msg: 'unimp message!!!'
      }, ret => {
        this.data = '宿主App回传的数据：' + ret;
      })
    }
  }
}
</script>

<style>
.content {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.logo {
  height: 200rpx;
  width: 200rpx;
  margin-top: 200rpx;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 50rpx;
}

.text-area {
  display: flex;
  justify-content: center;
}

.title {
  font-size: 36rpx;
  color: #8f8f94;
}
</style>
