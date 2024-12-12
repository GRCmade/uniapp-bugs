<template>
  <view>
   <button @click="click">click</button>
  </view>
</template>


<script>
export default {
  data() {
    return {
			data:[{
				"userid":"123456",
				"ls":["0"]
			}]
		}
  },
  methods: {
    click(){
			uni.setStorageSync("data",this.data)
			const res = uni.getStorageSync("data")
			console.log(JSON.stringify(res))
    }
  }
}
</script>


<style></style>

