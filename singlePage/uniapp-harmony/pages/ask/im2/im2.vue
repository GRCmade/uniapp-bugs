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
			console.log("upx2px");
			console.log(uni.upx2px(84));
    }
  }
}
</script>


<style></style>

