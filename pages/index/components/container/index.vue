<template>
    <coupon :list="mock_couponInfo" :title="'demo'" />
</template>

<script setup lang="ts">
import Coupon from '../coupon/index.vue'
import { mock_couponInfo } from './coupon-info'
</script>
<style scoped lang="scss"></style>
