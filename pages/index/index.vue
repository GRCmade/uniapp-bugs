<template>
  <view>
   <button @click="click">getSystemInfo</button>
   <uni-easyinput  v-model="input" placeholder="easyInput" />
	 <iframe src="https://www.baidu.com" frameborder="0"></iframe>
  </view>
</template>


<script>
export default {
  data() {
    return {
			input:""
		}
  },
  methods: {
    click(){
			console.log(JSON.stringify(uni.getSystemInfoSync()))
    }
  }
}
</script>


<style></style>

