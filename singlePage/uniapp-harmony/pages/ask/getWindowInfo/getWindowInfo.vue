<template>
  <view>
   <button @click="click">click</button>
  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  methods: {
    click(){
			console.log(JSON.stringify(uni.getWindowInfo().windowHeight));
    }
  }
}
</script>


<style></style>

