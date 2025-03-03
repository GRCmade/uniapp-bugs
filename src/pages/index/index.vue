<template>
  <view>
    <button @click="click">click</button>
    <uni-search-bar v-model="searchValue" @confirm="" placeholder=""/>
  </view>
</template>


<script>
export default {
  data() {
    return {
      searchValue: '1'
    }
  },
  methods: {
    click() {

    }
  }
}
</script>


<style></style>
