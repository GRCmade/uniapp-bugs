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
			uni.chooseImage({
				count:1,
				success(res) {
					console.log(JSON.stringify(res));
				}
			})
    }
  }
}
</script>


<style></style>

