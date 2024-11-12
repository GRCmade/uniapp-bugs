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
			uni.compressImage({
			  src: 'https://yuhepicgo.oss-cn-beijing.aliyuncs.com/logo.png',
			  quality: 80,
			  success: res => {
			    console.log(JSON.stringify(res.tempFilePath))
			  },fail(res) {
			  	console.log(JSON.stringify(res));
			  }
			})

    }
  }
}
</script>


<style></style>

