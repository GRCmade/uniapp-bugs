<template>
  <view style="margin-top: 50px;" class="test-page">
    <movable-area>
      <movable-view direction="vertical" @touchstart="handleDragStart" @longpress="handleLongpress"
        @touchmove="handleTouchMove" @change="handleMoving" @touchend="handleDragEnd">text</movable-view>
    </movable-area>
  </view>
</template>

<script>
export default {
  components: {},
  data() {
    return {}
  },
  onLoad() {

  },
  onPageScroll(event) {
    console.log('0-0-0-0-0-0-0-0-0-0-0-0-0-0-');
  },
  methods: {
    handleDragStart(event) {
      console.log('---1111---开始拖动', event);
    },
    handleLongpress(event) {
      console.log('---2222---长按事件', event);
    },
    handleTouchMove(event) {
      console.log('---3333---TouchMove事件', event);
    },
    handleMoving(event) {
      console.log('---4444---change事件', event);
    },
    handleDragEnd(event) {
      console.log('---5555---拖动结束', event);
    }
  }
}
</script>

<style lang="scss" scoped>
.test-page {
  height: 100vh;
  overflow: auto;

  movable-view {
    display: flex;
    align-items: center;
    justify-content: center;
    height: 150rpx;
    width: 150rpx;
    background-color: #007AFF;
    color: #fff;
  }

  movable-area {
    height: 100vh;
    width: 100%;
    background-color: #D8D8D8;
    overflow: hidden;
  }

}
</style>