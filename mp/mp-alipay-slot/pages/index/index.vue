<template>
    <view class="content">
        <view>使用作用域插槽时，后备内容没有展示</view>
        <test1>
            <template v-slot:default="{ listData }">
                <!-- {{ listData }} -->
            </template>
        </test1>
        <view style="margin-top: 20px;">未使用作用域插槽时，后备内容正常展示</view>
        <test1>
            <template v-slot:default></template>
        </test1>
    </view>
</template>

<script setup lang="ts">
import test1 from './test1.vue';
</script>

<style></style>