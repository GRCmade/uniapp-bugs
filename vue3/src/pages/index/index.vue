<template>
  <view>
    <button @click="chooseImage">chooseImage</button>
    <button @click="chooseVideo">chooseVideo</button>
    <button @click="chooseFile">chooseFile</button>
  </view>
</template>

<script setup lang="ts">
function chooseImage() {
  console.log("vue3");
  uni.chooseImage({
    success() {
      console.log("chooseImage success");
    },
    fail(result) {
      console.log("chooseImage fail", result);
    },
  });
}

function chooseVideo() {
  console.log("vue3");
  uni.chooseVideo({
    success() {
      console.log("chooseVideo success");
    },
    fail(result) {
      console.log("chooseVideo fail", result);
    },
  });
}

function chooseFile() {
  console.log("vue3");
  uni.chooseFile({
    success() {
      console.log("chooseFile success");
    },
    fail(result) {
      console.log("chooseFile fail", result);
    },
  });
}
</script>

<style>
/* 你可以根据需要加样式 */
</style>