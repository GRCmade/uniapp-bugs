<template>
  <view>
    <com type="default1d"></com>
   <button @click="click">click</button>
  </view>
</template>


<script lang="ts" setup>
import com from '@/components/com/com.vue'
import { User, UserRole } from '@/types/com';

// 示例使用
const user: User = {
  id: 1,
  name: 'John Doe',
  email: 'john@example.com'
};

const role: UserRole = 'admin';

const click = ()=>{
  console.log('click')
}
</script>


<style></style>

