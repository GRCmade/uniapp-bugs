<template>
  <view>
   <button @click="click">click</button>
	 <web-view id="yuhe" style="width: 200rpx;height: 500rpx;" src="http://yuhe.space"></web-view>
  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  methods: {
    click(){
			uni.createWebviewContext("yuhe")
    }
  }
}
</script>


<style></style>

