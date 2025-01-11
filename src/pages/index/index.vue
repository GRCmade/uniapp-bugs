<template>
  <view>
    inputValue:{{ inputValue }}
    <view class="box" v-for="item in 2">
      <input type="text" v-model="inputValue" @input="change"/>
    </view>
  </view>
</template>
<script setup>
import { ref } from "vue";
const inputValue = ref('')
const change = () => {
  console.log("change");
};
</script>

<style lang="scss">
.box{
  background-color: #36d;
  margin: 10px;
  color: #fff;
}
</style>