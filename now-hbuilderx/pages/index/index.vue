<template>
  <view class="container">
    <!-- <uni-badge text="1"></uni-badge> -->
    <!-- <com></com> -->
    <button @click="click">click 123 </button>

    <view class="test-section">
      <view class="title">输入框测试 (inputmode='none'问题)</view>
      <view class="input-wrapper">
        <input
          type="text"
          v-model="inputValue"
          placeholder="测试inputmode='none'与focus"
          :focus="isFocused"
          inputmode="none"
          class="test-input"
        />
        <view class="btn-group">
          <button @click="toggleFocus" class="test-btn">{{ isFocused ? '取消焦点' : '获取焦点' }}</button>
          <button @click="resetInput" class="test-btn">重置</button>
        </view>
        <view class="desc">
          <text>问题描述: 输入框设置了inputmode='none'应该隐藏键盘，但通过:focus=true获取焦点时，软键盘仍然弹出</text>
        </view>
      </view>
    </view>
  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'

const click = () => {
}

// 输入框测试相关
const inputValue = ref('')
const isFocused = ref(false)

const toggleFocus = () => {
  isFocused.value = !isFocused.value
}

const resetInput = () => {
  inputValue.value = ''
  isFocused.value = false
}
</script>


<style>
.container {
  padding: 20px;
}
.test-section {
  margin-top: 30px;
  border: 1px solid #eee;
  border-radius: 8px;
  padding: 15px;
}
.title {
  font-size: 16px;
  font-weight: bold;
  margin-bottom: 15px;
}
.input-wrapper {
  margin-top: 10px;
}
.test-input {
  width: 100%;
  height: 40px;
  border: 1px solid #ccc;
  border-radius: 4px;
  padding: 0 10px;
  margin-bottom: 15px;
}
.btn-group {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  margin-bottom: 15px;
}
.test-btn {
  flex: 1;
  height: 40px;
  background-color: #007AFF;
  color: #fff;
  margin: 0 5px;
}
.desc {
  font-size: 14px;
  color: #666;
  line-height: 1.5;
  padding: 10px;
  background-color: #f5f5f5;
  border-radius: 4px;
}
</style>
