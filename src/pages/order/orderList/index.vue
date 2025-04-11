<template>
  <view class="container">
    <view class="header">
      <text class="title">订单列表页面</text>
    </view>
  </view>
</template>

<script >
export default {
  data() {
    return {
      title: '订单列表页面'
    }
  },
  onLoad(options) {
    console.log('onLoad', options)
  }
}
</script>

<style>
.container {
  padding: 20px;
}
.header {
  margin-bottom: 20px;
}
.title {
  font-size: 18px;
  font-weight: bold;
  text-align: center;
  display: block;
}
.section-title {
  margin-bottom: 10px;
  font-weight: bold;
}
.params-section {
  margin-bottom: 30px;
}
.params-card {
  background-color: #f5f5f5;
  border-radius: 5px;
  padding: 15px;
  margin-bottom: 15px;
}
.params-header {
  margin-bottom: 10px;
  padding-bottom: 5px;
  border-bottom: 1px solid #e0e0e0;
}
.params-content {
  font-size: 14px;
}
.param-item {
  margin-bottom: 5px;
  display: flex;
  flex-wrap: wrap;
}
.param-key {
  color: #666;
  margin-right: 5px;
}
.param-value {
  color: #007aff;
  word-break: break-all;
}
.no-params {
  color: #999;
  font-style: italic;
}
.route-info {
  display: flex;
  flex-direction: column;
}
.buttons {
  margin-top: 20px;
}
.back-btn {
  background-color: #f0f0f0;
  color: #333;
}
</style> 