<template>
  <view>
    {{ text }}
    <textarea v-model="text"></textarea>
  </view>
</template>
<script>
export default {
  data() {
    return {
      numberValue: 100,
      digitValue: 100,
      text: '12',
      inputStatus: {
        isShowInputBox: true
      }
    }
  },
  methods: {
    click() { }
  }
}
</script>
<style>
.input-container {
  display: flex;
  flex-direction: column;
  gap: 10px;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.input-field {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
  transition: border-color 0.3s;
}

.input-field:focus {
  border-color: #007BFF;
  outline: none;
}
</style>