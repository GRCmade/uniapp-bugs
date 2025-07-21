<template>
  <view>
    <web-view id="webview" src="https://www.baidu.com" :fullscreen="false" style="width: 200px; height: 200px"></web-view>
    <button @click="click">button</button>
    <button @click="back">back</button>
    <button @click="loadUrl">loadUrl</button>
    <button @click="loadUrlEmpty">loadUrlEmpty</button>
    <button @click="navigateTo">navigateTo</button>
  </view>
</template>
<script>
export default {
  data() {},
  methods: {
    click() {
      this.webviewcontext = uni.createWebviewContext('webview', this)
      // this.webviewcontext.loadData({
      // 	data: 'yuhe',
      // 	baseURL: 'https://www.huawei.com'
      // })
    },
    back() {
      this.webviewcontext.back()
    },
    loadUrl() {
      this.webviewcontext.loadUrl({
        url: 'http://192.168.31.157:3000',
        headers: [{ headerKey: 'test', headerValue: 'yuhe' }]
      })
    },
		loadUrlEmpty() {
		  this.webviewcontext.loadUrl({
		    url: 'http://192.168.31.157:3000'
		  })
		},
    navigateTo() {
      uni.navigateTo({
        url: '/pages/index/index-next'
      })
    }
  }
}
</script>
<style></style>
