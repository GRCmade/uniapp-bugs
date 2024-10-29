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
			uni.chooseLocation({
				success(e) {
					console.log(e)
				}
			})
    }
  }
}
</script>


<style></style>

