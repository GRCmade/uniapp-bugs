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
			console.log("click");
			const res = uni.upx2px(20)
			console.log(JSON.stringify(res));
    }
  }
}
</script>


<style></style>

