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
				type: 'gcj02', //返回可以用于uni.openLocation的经纬度
				success: function (res) {
					const latitude = res.latitude;
					const longitude = res.longitude;
					uni.openLocation({
						latitude: latitude,
						longitude: longitude,
						name:"yuhe",
						address:"666",
						success: function () {
							console.log('success');
						}
					});
				},
				fail(res) {
					console.log("fail",JSON.stringify(res));
				}
			});

    }
  }
}
</script>


<style></style>

