<template>
  <view class="container">
    <view class="header">
      <text class="title">uni.request GET请求参数重复测试</text>
    </view>

    <view class="test-section">
      <text class="section-title">测试说明:</text>
      <text class="description">测试uni.request方法GET请求时，参数填写重复是否会去重</text>
      <text class="description">预期：安卓平台应该去重，其他平台行为待验证</text>
    </view>

    <view class="buttons">
      <button @click="testNormalRequest" class="test-btn">正常请求</button>
      <button @click="testDuplicateParams" class="test-btn">重复参数请求</button>
      <button @click="testDuplicateParamsInUrl" class="test-btn">URL中重复参数</button>
    </view>

    <view class="result">
      <text class="result-title">请求结果：</text>
      <text class="result-text">{{ resultText }}</text>
    </view>
  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

// 定义响应数据类型
interface HttpBinResponse {
  data: {
    args: Record<string, any>
    headers: Record<string, string>
    url: string
  }
}

const resultText = ref('点击按钮开始测试...')

// 正常请求测试
const testNormalRequest = () => {
  resultText.value = '正常请求测试中...'

  uni.request({
    url: 'https://httpbin.org/get',
    method: 'GET',
    data: {
      param1: 'value1',
      param2: 'value2'
    },
    success: res => {
      console.log('正常请求结果：', res)
      const response = res as unknown as HttpBinResponse
      resultText.value = `正常请求成功：${JSON.stringify(response.data.args, null, 2)}`
    },
    fail: err => {
      console.error('正常请求失败：', err)
      resultText.value = `正常请求失败：${err.errMsg}`
    }
  })
}

// 重复参数请求测试（通过data对象）
const testDuplicateParams = () => {
  resultText.value = '重复参数请求测试中...'

  // 创建一个对象来测试重复参数的行为
  const testData: Record<string, any> = {
    param1: 'normal'
  }
  // 故意设置重复的参数来测试去重行为
  testData['test'] = 'value1'
  testData['test'] = 'value2' // 这会覆盖前面的值

  uni.request({
    url: 'https://httpbin.org/get',
    method: 'GET',
    data: testData,
    success: res => {
      console.log('重复参数请求结果：', res)
      const response = res as unknown as HttpBinResponse
      resultText.value = `重复参数请求成功：${JSON.stringify(response.data.args, null, 2)}`
    },
    fail: err => {
      console.error('重复参数请求失败：', err)
      resultText.value = `重复参数请求失败：${err.errMsg}`
    }
  })
}

// URL中重复参数测试
const testDuplicateParamsInUrl = () => {
  resultText.value = 'URL重复参数测试中...'

  uni.request({
    url: 'https://httpbin.org/get?test=value1&test=value2&param1=normal',
    method: 'GET',
    success: res => {
      console.log('URL重复参数结果：', res)
      const response = res as unknown as HttpBinResponse
      resultText.value = `URL重复参数成功：${JSON.stringify(response.data.args, null, 2)}`
    },
    fail: err => {
      console.error('URL重复参数失败：', err)
      resultText.value = `URL重复参数失败：${err.errMsg}`
    }
  })
}
</script>

<style scoped>
.container {
  padding: 20px;
}

.header {
  margin-bottom: 20px;
}

.title {
  font-size: 18px;
  font-weight: bold;
  color: #333;
}

.test-section {
  margin-bottom: 20px;
  padding: 15px;
  background-color: #f5f5f5;
  border-radius: 8px;
}

.section-title {
  font-size: 16px;
  font-weight: bold;
  color: #333;
  display: block;
  margin-bottom: 10px;
}

.description {
  font-size: 14px;
  color: #666;
  line-height: 1.5;
  display: block;
  margin-bottom: 5px;
}

.buttons {
  display: flex;
  flex-direction: column;
  gap: 10px;
  margin-bottom: 20px;
}

.test-btn {
  padding: 12px 20px;
  font-size: 14px;
  border-radius: 6px;
  background-color: #007aff;
  color: white;
  border: none;
}

.result {
  padding: 15px;
  background-color: #f8f8f8;
  border-radius: 8px;
  border: 1px solid #e0e0e0;
}

.result-title {
  font-size: 16px;
  font-weight: bold;
  color: #333;
  display: block;
  margin-bottom: 10px;
}

.result-text {
  font-size: 12px;
  color: #333;
  line-height: 1.4;
  word-break: break-all;
  white-space: pre-wrap;
}
</style>
