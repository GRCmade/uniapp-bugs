<template>
  <view class="abc">
    <view id="draw" style="width: 100%; height: 300rpx; background-color: greenyellow">
      我是要截图的内容
    </view>
    <view
      class="btn"
      @click="canvasToImage.preservation"
      style="
        width: 100%;
        height: 80rpx;
        display: flex;
        align-items: center;
        justify-content: center;
        border: 1rpx solid #000;
        margin-top: 30rpx;
      ">
      点我截图
    </view>
  </view>
</template>
<script>
export default {
  methods: {
    showToast(type) {
      if (type == 'load') {
        uni.showLoading()
      } else {
        uni.hideLoading()
      }
    },
    saveToAlbum(url) {
      console.log('saveToAlbum', url)
      this.showToast()
    }
  }
}
</script>
<!-- #ifdef APP -->
<script module="canvasToImage" lang="renderjs">
import html2canvas from "html2canvas"
export default {
	data() {
		return {}
	},
	methods: {
		async preservation(event, ownerInstance) {
			console.log("preservation")
			ownerInstance.callMethod('showToast', 'load')
			var dom = document.getElementById('draw')
			try {
				console.log("dom",dom)
				const canvas = await html2canvas(dom, {
					background: '#fff',
					scale: 2,
					useCORS: true,
					allowTaint: true,
					logging: true
				})
				console.log("canvas", canvas)
				let url = canvas.toDataURL('image/png')
				ownerInstance.callMethod('saveToAlbum', url)
			} catch (error) {
				console.log(JSON.stringify(error))
				ownerInstance.callMethod('showToast', 'hide')
				//TODO handle the exception
			}
		},
	}
}
</script>
<!-- #endif -->
<style>
.controls {
  display: flex;
  justify-content: space-around;
  margin-top: 20rpx;
}
</style>
