<template>
  <view>
    当前页面： index-next
    <button @click="loadURL">loadURL</button>
    <button @click="loadURLEmpty">loadURLEmpty</button>
    <button @click="close">close</button>
  </view>
</template>

<script>
export default {
  data() {
    return {}
  },
  methods: {
    loadURL() {
      let wv = plus.webview.create('', 'custom-webview', { height: '200px', width: '200px' })
      wv.loadURL('http://192.168.31.157:3000', { tes: 'yuhe' })
      wv.show()
    },
    loadURLEmpty() {
      let wv = plus.webview.create('', 'custom-webview', { height: '200px', width: '200px' })
      wv.loadURL('http://192.168.31.157:3000')
      wv.show()
    },
    close() {
      plus.webview.close('custom-webview', true)
    }
  }
}
</script>

<style></style>
