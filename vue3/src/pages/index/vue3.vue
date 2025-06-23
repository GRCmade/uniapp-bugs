<template>
  <view>
    <button @tap="change">交换</button>
    <view v-if="flag" class="uni-margin-wrap">
      <swiper class="swiper">
        <swiper-item>
          <view class="swiper-item uni-bg-red">A</view>
        </swiper-item>
        <swiper-item>
          <view class="swiper-item uni-bg-green">B</view>
        </swiper-item>
        <swiper-item>
          <view class="swiper-item uni-bg-blue">C</view>
        </swiper-item>
      </swiper>
    </view>

    <view v-if="!flag" class="uni-margin-wrap">
      <swiper class="swiper">
        <swiper-item>
          <view class="swiper-item uni-bg-red">D</view>
        </swiper-item>
        <swiper-item>
          <view class="swiper-item uni-bg-green">E</view>
        </swiper-item>
        <swiper-item>
          <view class="swiper-item uni-bg-blue">F</view>
        </swiper-item>
      </swiper>
    </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      flag: true
    }
  },
  methods: {
    change() {
      this.flag = !this.flag
    }
  }
}
</script>
