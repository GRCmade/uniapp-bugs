<template>
  <view>
   <button @click="click">click</button>
   <button @click="click2">click2</button>
  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  methods: {
    click(){
			const res = uni.getAppAuthorizeSetting()
			console.log(JSON.stringify(res));
    },
		click2(){
			uni.chooseImage({
				count:1,
				sourceType:['camera'],
				fail(res) {
					console.log(JSON.stringify(res));
				}
			})
		}
  }
}
</script>


<style></style>

