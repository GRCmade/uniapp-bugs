<template>
    <view class="index">
        <view>{{ t('首页') }}</view>
        <view v-for="(item,index) in listLang" :key="index" @tap="langChange(item.value)">
            {{ item.name }}
        </view>
    </view>
</template>

<script setup lang="ts">
import {computed, nextTick, reactive, ref, shallowRef} from 'vue'


import {useI18n} from "vue-i18n";

const {t, locale} = useI18n();


const listLang = ref([
    {
        name: '中文',
        value: 'zh-Hans'
    },
    {
        name: '英语',
        value: 'en'
    },
    {
        name: '阿语',
        value: 'ar'
    },
])

const langChange = (value: string) => {
    uni.setLocale(value)
    locale.value = value
}

</script>

<style lang="scss" scoped>

</style>
