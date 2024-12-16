<template>
  <view v-if="type === 'default'" class="coupon">
    <text v-if="list.length > 0" class="coupon-label">
      {{ title || '优惠券' }}
    </text>
    <text v-else class="coupon-empty">
      暂无优惠券
    </text>
    <coupon-single v-if="list.length === 1" class="coupon-widget" :list="list" @click="onClick" />
    <coupon-couple v-if="list.length === 2" class="coupon-widget" :list="list" @click="onClick" />
    <coupon-three v-if="list.length === 3" class="coupon-widget" :list="list" @click="onClick" />
    <coupon-more v-if="list.length > 3" class="coupon-widget" :list="list" @click="onClick" />
  </view>
  <view v-else class="coupon-slip">
    <text v-if="!list || list?.length === 0" class="coupon-empty">
      暂无优惠券
    </text>
    <view v-for="(item, index) in list" v-else :key="index.toString()" class="coupon-item" :style="defaultItemStyle"
      @click="onClick(item)">
      <view class="coupon-item-text">
        <view class="coupon-item-value">
          {{ item.couponAmount }}<text class="text">
            元
          </text>
        </view>
        <text class="coupon-item-extra">
          {{ item.extra }}
        </text>
      </view>
      <image class="coupon-item-image" :src="coupon_slip" mode="heightFix" />
      <view class="coupon-item-slogan">
        <text class="text">
          立即抢券
        </text>
      </view>
    </view>
  </view>
</template>

<script setup lang="ts">
import { ref, defineProps, defineEmits, onBeforeMount } from 'vue'
import CouponSingle from './components/coupon-single/index.vue'
import CouponCouple from './components/coupon-couple/index.vue'
import CouponThree from './components/coupon-three/index.vue'
import CouponMore from './components/coupon-more/index.vue'

const coupon_slip = ref(`https://onetravel-web.onetravelgz.com/onecode-travel/miniprogram/food/public/images/coupon-slip.png`)

const props = withDefaults(
  defineProps<{
    type?: 'default' | 'slip'
    title?: string
    list?: Array<any>
    itemStyle?: any
  }>(),
  {
    type: 'default',
    title: '',
    list: () => [],
    itemStyle: {},
  }
)

const emits = defineEmits<{
  (e: 'detail', value: { id: string, type: number }): void
}>()

const defaultItemStyle = ref({})

onBeforeMount(() => {
  if (props.type === 'slip') {
    if (props.list?.length > 1) {
      defaultItemStyle.value = { minWidth: 'calc(50% - 12rpx)', ...props.itemStyle }
    }
    if (props.list?.length > 2) {
      defaultItemStyle.value = { minWidth: '319rpx', ...props.itemStyle }
    }
  }
})

const onClick = item => {
  const { useType, couponId: id, isPlatActivity } = item || {}
  if ((id || item?.id) && !isPlatActivity) {
    const cid = id || item?.id
    emits('detail', { id: cid, type: useType });
    // toWebView(`${foodWebRoute.coupon}${query2url({ id: cid, type: ECouponUseType[useType] })}`)
  }
}
</script>
<style scoped lang="scss">
@import './index.scss';
</style>
