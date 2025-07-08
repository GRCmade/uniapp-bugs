<template>
  <view class="container">
    <view class="header">
      <text class="title">uni.request GET请求参数重复测试</text>
    </view>

    <view class="test-section">
      <text class="section-title">测试说明:</text>
      <text class="description">测试uni.request方法GET请求时，URL和data中同名参数的处理</text>
      <text class="description">URL中有param=example，data中也有param:'example'</text>
      <text class="description">预期：安卓平台应该去重，鸿蒙平台可能未去重</text>
    </view>

    <view class="buttons">
      <button @click="testDuplicateParams" class="test-btn">测试重复参数</button>
    </view>

    <view class="buttons">
      <button @click="testDuplicateUrlParams" class="test-btn">测试重复url参数</button>
    </view>

    <view class="buttons">
      <button @click="testDuplicateUrlandDataParams" class="test-btn">
        测试重复url参数和 data 参数
      </button>
    </view>

    <view class="buttons">
      <button @click="testOtherParams" class="test-btn">测试其他参数</button>
    </view>

    <view class="result">
      <text class="result-title">请求结果：</text>
      <text class="result-text">{{ resultText }}</text>
    </view>
  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

const resultText = ref('点击按钮开始测试...')

// 重复参数测试
const testDuplicateParams = () => {
  resultText.value = '测试中...'

  uni.request({
    method: 'GET',
    url: 'http://192.168.31.172:3000?param=example',
    data: { param: 'example' },
    success: res => {
      console.log('请求结果：', res)
      resultText.value = `请求成功：${JSON.stringify(res.data, null, 2)}`
    },
    fail: err => {
      console.error('请求失败：', err)
      resultText.value = `请求失败：${err.errMsg}`
    }
  })
}

const testDuplicateUrlParams = () => {
  resultText.value = '测试中...'

  uni.request({
    url: 'http://192.168.31.172:3000?param=example&param=example',
    method: 'GET',
    success: res => {
      console.log('请求结果：', res)
      resultText.value = `请求成功：${JSON.stringify(res.data, null, 2)}`
    },
    fail: err => {
      console.error('请求失败：', err)
      resultText.value = `请求失败：${err.errMsg}`
    }
  })
}

const testDuplicateUrlandDataParams = () => {
  resultText.value = '测试中...'

  uni.request({
    url: 'http://192.168.31.172:3000?param=example&param=example',
    data: { param: 'example' },
    method: 'GET',
    success: res => {
      console.log('请求结果：', res)
      resultText.value = `请求成功：${JSON.stringify(res.data, null, 2)}`
    },
    fail: err => {
      console.error('请求失败：', err)
      resultText.value = `请求失败：${err.errMsg}`
    }
  })
}

const testOtherParams = () => {
  resultText.value = '测试中...'

  uni.request({
    url: 'http://192.168.31.172:3000?param=example&param=example&param2=other123&parm=#1',
    data: { param: 'example', param2: 'other' },
    method: 'GET',
    success: res => {
      console.log('请求结果：', res)
      resultText.value = `请求成功：${JSON.stringify(res.data, null, 2)}`
    },
    fail: err => {
      console.error('请求失败：', err)
      resultText.value = `请求失败：${err.errMsg}`
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
