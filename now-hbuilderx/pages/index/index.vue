<template>
  <view class="container">
    <view class="description">
      <text class="title">condition配置参数传递问题测试</text>
      <text class="subtitle">问题描述：在manifest.json中配置condition的query参数，在小程序中可以正常获取，但在Android和iOS基座中无法获取。</text>
    </view>
    
    <view class="buttons">
      <button @click="navigateToOrderList" class="primary-btn">跳转到订单列表页面</button>
    </view>
    
    <view class="instructions">
      <text>测试步骤：</text>
      <text>1. 确保在manifest.json中已配置condition（见README.md）</text>
      <text>2. 点击上方按钮跳转到订单列表页面</text>
      <text>3. 查看订单列表页面中显示的参数信息</text>
      <text>4. 在不同平台测试（小程序、Android基座、iOS基座）对比结果</text>
    </view>
  </view>
</template>

<script lang="ts" setup>
import { onMounted } from 'vue'

// 跳转到订单列表页面
const navigateToOrderList = () => {
  uni.navigateTo({
    url: '/pages/order/orderList/index?source=manual&time=' + new Date().getTime(),
    success: () => {
      console.log('跳转成功')
    },
    fail: (err) => {
      console.error('跳转失败', err)
    }
  })
}

// 页面加载完成
onMounted(() => {
  console.log('首页加载完成')
})
</script>

<style>
.container {
  padding: 20px;
}
.description {
  margin-bottom: 30px;
}
.title {
  font-size: 18px;
  font-weight: bold;
  margin-bottom: 10px;
  display: block;
}
.subtitle {
  font-size: 14px;
  color: #666;
  display: block;
  margin-bottom: 10px;
}
.buttons {
  margin-bottom: 30px;
}
.primary-btn {
  background-color: #007aff;
  color: #ffffff;
}
.instructions {
  border-top: 1px solid #eee;
  padding-top: 20px;
}
.instructions text {
  display: block;
  margin-bottom: 8px;
  font-size: 14px;
}
</style>
