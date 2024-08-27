<template>
	<PageEntry style="overflow: hidden">
    <view slot="main">
      <view class="content">
        <view class='bottom'>
          <view @click="handleClearDraw" class="btn clear-btn">
            <view>清除</view>
          </view>
          <view @click="handleSubmit" class="btn">
            <view>确定</view>
          </view>
        </view>
        <canvas 
          :style="{width: canvasW + 'px', height: canvasH + 'px'}" 
          class="canvas" 
          id="canvas" 
          canvas-id="canvas" 
          disable-scroll="true" 
          @touchstart="canvasStart" 
          @touchmove="canvasMove" 
          @touchend="canvasEnd" 
          @touchcancel="canvasEnd" 
          @error="canvasIdErrorCallback">
        </canvas>
        
        <view class="tips">
          <view class="tips-btn">
            <view class="tips-text">请</view>
            <view class="tips-text">横</view>
            <view class="tips-text">屏</view>
            <view class="tips-text">签</view>
            <view class="tips-text">名</view>
          </view>
        </view>
      </view>
    </view>
  </PageEntry>
</template>

<script>
	export default {
		data() {
			return {
        statusBarHeight: '',
        canvasW: 0,
        canvasH: 0,
        arrZ: [],
        arrY: [],
        arrX: [],
        context: null,
        signCxt: null,
        isButtonDown: false,
        canvasImgSrc: ''
			}
		},
    onShow() {
      const system = uni.getSystemInfoSync()
      this.statusBarHeight = system.statusBarHeight
      this.canvasW = system.windowWidth - 90
      this.canvasH = system.windowHeight
    },
    onLoad(options) {
      this.initCanvas()
    },
		methods: {
      handleClearDraw() {
        this.arrX = []
        this.arrY = []
        this.arrZ = []
        this.context.clearRect(0, 0,this. canvasW, this.canvasH)
        this.context.draw(true)
      },
      async handleSubmit() {
        if (this.arrX.length == 0) {
          uni.showModal({
            title: '提示',
            content: '签名内容不能为空！',
            showCancel: false
          });
          return
        };
        uni.canvasToTempFilePath({
          canvasId: 'canvas',
          success: function (response) {
            console.log('1111', response)
          },
          fail: function (fail) {
            console.log('2222', fail)
          },
          complete: function (complete) {
            console.log('3333', complete)
          }
        })
      },
      initCanvas() {
        this.context = uni.createCanvasContext('canvas')
        this.context.beginPath()
        this.context.setStrokeStyle('#000000')
        this.context.setLineWidth(4)
        this.context.setLineCap('round')
        this.context.setLineJoin('round')
      },
      canvasStart(event) {
        this.isButtonDown = true
        this.arrZ.push(0)
        this.arrX.push(event.changedTouches[0].x)
        this.arrY.push(event.changedTouches[0].y)
      },
      canvasMove(event) {
        if (this.isButtonDown) {
          this.arrZ.push(1);
          this.arrX.push(event.changedTouches[0].x);
          this.arrY.push(event.changedTouches[0].y);
        };
        for (var i = 0; i < this.arrX.length; i++) {
          if (this.arrZ[i] == 0) {
            this.context.moveTo(this.arrX[i], this.arrY[i])
          } else {
            this.context.lineTo(this.arrX[i], this.arrY[i])
          };
        };
        this.context.clearRect(0, 0, this.canvasW, this.canvasH);
        this.context.setStrokeStyle('#000000');
        this.context.setLineWidth(4);
        this.context.setLineCap('round');
        this.context.setLineJoin('round');
        this.context.stroke();
        this.context.draw(false);
      },
      canvasEnd(event) {
        this.isButtonDown = false
      },
      canvasIdErrorCallback(event) {
        console.error(event)
      },
		}
	}
</script>

<style lang="scss" scoped>
.content {
  display: flex;
  position: relative;
}
canvas {
  margin: 0 auto;
  background: #f7f7f7;
  flex: 1 1 auto;
}
.sign-canvas {
  visibility: hidden;
  position: absolute;
  margin-left: -300rpx;
}
.btn {
  width: 90rpx;
  height: 40%;
  display: flex;
  align-items: center;
  justify-content: center;
  border-radius: 18rpx;
  background: rgba(0, 212, 120, 1);
  font-size: 34rpx;
  color: #ffffff;
  text-align: center;
}
.btn view {
  transform: rotate(90deg);
}
.clear-btn {
  color: rgba(0, 212, 120, 1);
  background: #ffffff;
  border: 1px solid rgba(0, 212, 120, 1);
}
.bottom {
  padding: 0rpx 20rpx;
  display: flex;
  align-items: center;
  justify-content: space-evenly;
  flex-direction: column;
  flex: 0 0 90rpx;
  background-color: #ffffff;
  box-shadow: 10rpx 0rpx 10rpx #f3f3f3;
}
.tips {
  flex: 0 0 90rpx;
  display: flex;
  align-items: center;
}
.tips-btn {
  width: 90rpx;
  height: 260rpx;
  font-size: 30rpx;
  color: #ffffff;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  background-color: rgba(0, 212, 120, 0.5);
  border-radius: 62rpx;
}
.tips-btn .tips-text {
  transform: rotate(90deg);
}
</style>
