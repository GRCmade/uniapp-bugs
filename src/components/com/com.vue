<template>
  <view>
    com
    <view>
      <view style="padding: 20px;">
        <uni-forms :modelValue="formData" label-position="top">
          <uni-forms-item label="姓名" name="name">
            <input type="text" v-model="formData.name" placeholder="请输入姓名" />
          </uni-forms-item>
          <uni-forms-item label="年龄" name="age">
            <input type="text" v-model="formData.age" placeholder="请输入年龄" />
          </uni-forms-item>
        </uni-forms>
        <button @click="submitForm">Submit</button>
      </view>
    </view>
  </view>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const str = ref < string > ('123')
const formData = ref({
  name: '',
  age: ''
})
const submitForm = () => {
  console.log('submitForm', formData.value)
}
const click = () => {
  console.log('click', str.value)
}
</script>


<style></style>
