<template>
  <view class="page">
    <view class="card">
      <text class="title">Vue 3 简单测试示例</text>
      <text class="desc">点击下面的按钮，验证响应式数据更新和 markdown 解析是否正常。</text>

      <text class="label">当前点击次数：{{ count }}</text>
      <button class="button" @click="runTest">运行测试</button>

      <view class="result">
        <text class="result-title">测试结果</text>
        <text class="result-text">{{ result }}</text>
      </view>

      <view class="result">
        <text class="result-title">marked 输出</text>
        <text class="result-text selectable">{{ parsedMarkdown }}</text>
      </view>
    </view>
  </view>
</template>

<script lang="ts" setup>
import { computed, ref } from 'vue'
import { marked } from 'marked'

const count = ref(0)
const markdown = ref('# marked 解析 markdown\n\n- 支持 Vue 3 setup\n- 支持响应式更新')
const result = ref('点击按钮后查看结果')

const parsedMarkdown = computed(() => marked.parse(markdown.value))

const runTest = () => {
  count.value += 1
  result.value = `第 ${count.value} 次测试已执行`
  console.log('marked output:', parsedMarkdown.value)
}
</script>

<style scoped>
.page {
  padding: 24rpx;
  background: #f6f7fb;
  min-height: 100vh;
  box-sizing: border-box;
}

.card {
  padding: 32rpx;
  border-radius: 24rpx;
  background: #ffffff;
  box-shadow: 0 8rpx 24rpx rgba(15, 23, 42, 0.08);
}

.title {
  display: block;
  font-size: 36rpx;
  font-weight: 600;
  color: #1f2937;
}

.desc {
  display: block;
  margin-top: 16rpx;
  font-size: 28rpx;
  line-height: 1.6;
  color: #6b7280;
}

.label {
  display: block;
  margin-top: 24rpx;
  font-size: 30rpx;
  color: #111827;
}

.button {
  margin-top: 24rpx;
}

.result {
  margin-top: 24rpx;
  padding: 24rpx;
  border-radius: 16rpx;
  background: #f9fafb;
}

.result-title {
  display: block;
  font-size: 28rpx;
  font-weight: 600;
  color: #374151;
}

.result-text {
  display: block;
  margin-top: 12rpx;
  font-size: 26rpx;
  line-height: 1.6;
  color: #4b5563;
  word-break: break-all;
}

.selectable {
  user-select: text;
}
</style>
