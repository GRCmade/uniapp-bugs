<template>
  <view>
    <com></com>
    <button @click="click">click</button>
  </view>
</template>

<script lang="ts">
import Vue from 'vue';

export default Vue.extend({
  data() {
    return {
      title: 'Hello'
    }
  },
  onLoad() {

  },
  methods: {
    click(){}
  }
});
</script>

<style>
</style>
