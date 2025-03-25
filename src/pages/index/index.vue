<template>
  <view>
    <button @click="click">click</button>
    <uni-badge text="1"></uni-badge>
    <com></com>

  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  methods: {
    click() {
      uni.setClipboardData({
        data: "333",
        showToast: true,
        success: function (e) {
          console.log("copy result: ", e);
        },
				fail: function (e) {
				  console.log("copy fail: ", e);
				},
        complete: function (e) {
          console.log("copy result: ", JSON.stringify(e));
        }
      });
    }
  }
}
</script>


<style></style>
