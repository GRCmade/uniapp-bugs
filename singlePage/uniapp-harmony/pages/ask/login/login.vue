<template>
  <view>
   <button @click="click">click</button>
	 <button @click="click2">getProvider</button>
  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  methods: {
    click(){
			uni.login({
			  provider: 'huawei', //使用微信登录
			  success: function (loginRes) {
			    console.log(JSON.stringify(loginRes));
			  },
				fail(loginRes) {
					console.log(JSON.stringify(loginRes));
				}
			});

    },
		click2(){
			uni.getProvider({
				service: 'oauth',
				success: function (loginRes) {
					console.log(JSON.stringify(loginRes));
				}
			});

		}
  }
}
</script>


<style></style>

