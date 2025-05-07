<template>
  <view>
    <view class="" style="margin-top: 100px"> </view>
    <button @click="openDocument(url1)">url1</button>
    <button @click="openDocument(url2)">url2</button>
  </view>
</template>

<script>
export default {
  data() {
    return {
      url1: 'https://www.ccfund.com.cn/main/files/2025/03/28/长城全球新能源汽车股票型发起式证券投资基金（QDII-LOF）基金产品资料概要更新.pdf',
      url2: 'https://www.ccfund.com.cn/main/files/2025/01/10/长城消费增值混合型证券投资基金招募说明书更新（2025年第1号）.pdf'
    }
  },
  onLoad() {},
  methods: {
    openDocument(url) {
      uni.downloadFile({
        url: url,
        success: function (res) {
          let filePath = res.tempFilePath
          console.log(res)
          uni.openDocument({
            filePath: filePath,
            success: function (res) {
              console.log('打开文档成功')
            },
            fail: e => {
              console.log(e)
            },
            complete() {
              uni.hideLoading()
            }
          })
        },
        fail(e) {
          console.log(e)
          uni.showToast({
            icon: 'none',
            title: '文件打开失败'
          })
        },
        complete(w) {
          console.log(w)
          uni.hideLoading()
        }
      })
    }
  }
}
</script>
