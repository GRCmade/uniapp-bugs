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
			uni.getProvider({
				service:'payment',
				success(res) {
					console.log("res",JSON.stringify(res));
				}
			})
    }
  }
}
</script>


<style></style>

