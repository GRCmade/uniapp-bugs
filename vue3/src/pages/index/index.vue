<template>
  <view class="content">
    <image class="logo" src="/static/logo.png"></image>
    <view class="text-area">
      <button @tap="saveImage">保存图片到本地</button>
    </view>
    <view>
      <view class="padding">imagePath : {{ imagePath }}</view>
      <image :src="imagePath"></image>
      <view class="padding">https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png</view>
      <image :src="'https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png'"></image>
      <view class="padding">/data/storage/el2/base/cache/HBuilder/uni-download/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf(3).png</view>

      <image :src="'/data/storage/el2/base/cache/HBuilder/uni-download/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf(3).png'"></image>
    </view>
  </view>
</template>

<script>
export default {
  onLoad() {
    this.imagePath = uni.getStorageSync('imagePath')
    // uni.showModal({
    //   content: JSON.stringify(this.imagePath)
    // })
  },
  data() {
    return {
      title: 'Hello',
      imagePath: '/data/storage/el2/base/cache/HBuilder/uni-download/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf(3).png'
    }
  },
  methods: {
    saveImage() {
      uni.downloadFile({
        url: 'https://www.baidu.com/img/PCtm_d9c8750bed0b3c7d089fa7d55720d6cf.png',
        success: res => {
          this.imagePath = res.tempFilePath
          console.log('res.tempFilePath', res.tempFilePath)
          uni.setStorageSync('imagePath', res.tempFilePath)
        }
      })
    }
  }
}
</script>

<style>
.padding {
  padding: 20rpx;
}
</style>
