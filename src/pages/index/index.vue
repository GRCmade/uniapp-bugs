<template>
  <view>
    <button @click="click">click</button>
    <uni-badge text="1"></uni-badge>
    <uni-badge text="2" type="success" @click="bindClick"></uni-badge>
    <uni-badge text="3" type="primary" :inverted="true"></uni-badge>
    <temp></temp>
  </view>
</template>


<script>
import temp from './temp.jsx'
export default {
  components: {
    temp
  },
  data() {
    return {}
  },
  methods: {
    click() {

    }
  }
}
</script>


<style></style>
