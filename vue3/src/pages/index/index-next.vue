<template>
  <video
    id="courseVideo"
    src="https://qiniu-web-assets.dcloud.net.cn/unidoc/zh/2minute-demo.mp4"
    controls
    :picture-in-picture-mode="pictureInPictureMode"
    picture-in-picture-show-progress="true"
    picture-in-picture-init-position="right,0"></video>
</template>
<script>
export default {
  name: 'VideoPlay',
  data() {
    return {
      pictureInPictureMode: ['pop', 'push']
    }
  },
  onLoad(options) {},
  onReady() {},
  onHide() {
    console.log('页面隐藏')
  },
  onShow() {},
  onUnload() {
    console.log('页面卸载')
    // 页面卸载时，小窗会根据配置自动处理
  },
  methods: {}
}
</script>
<style lang="scss" scoped>
video {
  width: 300px;
  height: 225px;
}
</style>
