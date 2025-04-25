<template>
  <view>
    <button @click="chooseImage">chooseImage</button>
    <button @click="chooseVideo">chooseVideo</button>
    <button @click="chooseFile">chooseFile</button>
  </view>
</template>

<script lang="ts">
import Vue from "vue";

export default Vue.extend({
  data() {
    return {
      title: "Hello",
    };
  },
  onLoad() {},
  methods: {
    chooseImage() {
      console.log("vue2");
      uni.chooseImage({
        success() {},
        fail(result) {
          console.log("fail", result);
        },
      });
    },
    chooseVideo() {
      console.log("vue2");
      uni.chooseVideo({
        success() {},
        fail(result) {
          console.log("fail", result);
        },
      });
    },
    chooseFile() {
      console.log("vue2");
      uni.chooseFile({
        success() {},
        fail(result) {
          console.log("fail", result);
        },
      });
    },
  },
});
</script>

<style></style>
