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
			uni.getLocation({
				type:'gcj02',
				geocode:true,
				isHighAccuracy:true,
				success(res) {
					
					console.log(JSON.stringify(res));
				},
				fail(res) {
					console.log(JSON.stringify(res));
				}
			})
    }
  }
}
</script>


<style></style>

