<template>
  <view>
    <button @click="click">click2</button>
  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  methods: {
    click() {
      uni.chooseImage({
        count: 1,
        sourceType: ['camera','album'],
        success: function (res) {
          uni.saveImageToPhotosAlbum({
            filePath: res.tempFilePaths[0],
            success: function () {
              console.log('save success');
            }
          });
        }
      });
    }
  }
}
</script>


<style></style>
