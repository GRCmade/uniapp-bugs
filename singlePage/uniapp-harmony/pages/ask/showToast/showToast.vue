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
			uni.showToast({
				title: '超过四个字怎么办',
				icon: 'success'
			});
    }
  }
}
</script>


<style></style>

