<template>
  <corner></corner>
  <view class="coupon-card">
    <block v-for="(item, index) in list" :key="index.toString()">
      <view class="coupon-item" @click="onClick(item)">
        <view :class="`coupon-face-value ${item.couponAmount.length > 5 ? 'coupon-face-value-middle' : ''}`">
          <text class="amount">{{ item.couponAmount }}</text>
          <view class="unit">元</view>
        </view>
        <text class="coupon-item-extra">{{ item.extra }}</text>
        <view class="coupon-item-slogan">
          <text class="text">{{ item.isPlatActivity ? '下单立减' : '立即抢券' }}</text>
        </view>
      </view>
    </block>
  </view>
</template>

<script setup lang="ts">
import corner from '../corner/index.vue'

const props = withDefaults(
  defineProps<{
    list?: Array<any>
  }>(),
  {
    list: () => [],
  }
)

const emits = defineEmits<{
  (e: 'click', item: any): void
}>()

const onClick = item => {
  emits('click', item)
}
</script>
<style scoped lang="scss">
@import './index.scss';
@import '../index.scss';
</style>
