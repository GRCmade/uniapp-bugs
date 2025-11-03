<script setup lang="ts">
  import { ref } from 'vue';

  interface ITabBar {
    hasSafe ?: boolean
  }
  const props = withDefaults(defineProps<ITabBar>(), {

  });
  const tabData = [
    {
      "iconPath": "/static/tabbar/nav_home.png",
      "selectedIconPath": "/static/tabbar/nav_home_sel.png",
      "pagePath": "pages/home/index",
      "text": "首页",
      "visible": true
    },
    {
      "iconPath": "/static/tabbar/nav_home.png",
      "selectedIconPath": "/static/tabbar/nav_home_sel.png",
      "pagePath": "pages/picture/index",
      "text": "图片",
      "visible": true
    },
    {
      "iconPath": "/static/tabbar/nav_home.png",
      "selectedIconPath": "/static/tabbar/nav_home_sel.png",
      "pagePath": "pages/vip/index",
      "text": "会员",
      "visible": true
    },
    {
      "iconPath": "/static/tabbar/nav_home.png",
      "selectedIconPath": "/static/tabbar/nav_home_sel.png",
      "pagePath": "pages/column/index",
      "text": "人员",
      "visible": true
    },
    {
      "iconPath": "/static/tabbar/nav_home.png",
      "selectedIconPath": "/static/tabbar/nav_home_sel.png",
      "pagePath": "pages/user/index",
      "text": "我的",
      "visible": true
    },
  ]

  const emit = defineEmits(['change'])
  const active = ref(0)
  const sys = uni.getSystemInfoSync();

  const change = (index : number) => {
    active.value = index;
    emit('change', index)
  }
</script>
<style scoped lang="scss">
  .tabbar {
    border-top: 1px solid #ccc;
    padding-top: 10rpx;
    height: 50px;
    display: flex;
    flex-direction: row;


    &-item {
      height: 50px;
      display: flex;
      flex: 1;

      &-warp {
        height: 50px;
        flex: 1;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
      }

      &-image {
        height: 25px;
        margin-bottom: 2px;
      }
    }
  }
</style>
<template>
  <view class="tabbar" :style="{
    width: sys.windowWidth+'px',
    height: '50px',
    marginBottom: props.hasSafe ? sys.safeAreaInsets.bottom : 0 +'px'
  }">
    <view class="tabbar-item" v-for="(item, index) in tabData" :style="{
      width : sys.windowWidth /  tabData.length  + 'px'
    }">
      <view class="tabbar-item-warp" @click="() => change(index)">
        <image class="tabbar-item-image" :src=" index === active ? item.selectedIconPath: item.iconPath"
          mode="heightFix" />
        <text :style="{ color: active === index ? '#34A1EC': '#85C7F4', fontSize: '15px' }">{{item.text}}</text>
      </view>
    </view>
  </view>
</template>