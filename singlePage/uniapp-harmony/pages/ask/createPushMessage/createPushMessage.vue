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
			uni.createPushMessage({
				title:"yuhe",
				content:"asdasd",
				category:"SOCIAL_COMMUNICATION",
				success(res) {
					console.log(res);
				}
			})
    }
  }
}
</script>


<style></style>

