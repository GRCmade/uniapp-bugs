<template>
  <view class="coupon-corner">
    <view class="fill-up" />
    <view class="hot">
      <text class="hot-text">
        火爆开抢
      </text>
      <image class="hot-img" :src="hot" />
    </view>
  </view>
</template>

<script setup lang="ts">
import { ref } from 'vue'
const hot = ref(`https://onetravel-web.onetravelgz.com/onecode-travel/miniprogram/food/public/images/hot-tag.png`)
</script>
<style scoped lang="scss">
@import './index.scss';
</style>
