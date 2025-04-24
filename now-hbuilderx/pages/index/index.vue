<template>
  <view>
    <van-cell-group>
      <van-field label="名称" placeholder="请输入菜谱名称" :value="name" />
    </van-cell-group>
    <van-button type="primary" size="large" round block class="save-button" @click="save"
      >保存</van-button>
  </view>
</template>

<script setup lang="ts">
import { ref } from 'vue'

const name = ref('')

function save() {
  name.value = Math.random()
}
</script>