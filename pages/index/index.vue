<template>
  <view>
   <button @click="setStorage">setStorage</button>
   <button @click="getStorage">getStorage</button>
  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  methods: {
    setStorage(){
			console.log("setStorage")
			const user = {
				orgName : "dcloudio",
				position : ".net工程师"
			}
			console.log(JSON.stringify(user))
			uni.setStorageSync('userInfo',user)
    },
		getStorage(){
			console.log("getStorage")
			var userInfo = uni.getStorageSync('userInfo')
			userInfo.position = ".js工程师"
			uni.setStorageSync('userInfo',userInfo)
			console.log(JSON.stringify(userInfo))
		}
  }
}
</script>


<style></style>

