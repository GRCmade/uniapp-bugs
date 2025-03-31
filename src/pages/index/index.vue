<template>
  <view>
    <button @click="click">click</button>
  </view>
</template>


<script>
export default {
  data() {
    return {
      tempFilePaths: ''
    }
  },
  methods: {
    async click() {
      // const res = await uni.chooseImage({
      //   count: 1,
      //   sizeType: ['original', 'compressed'],
      //   sourceType: ['album', 'camera']
      // });
      // const tempFilePaths = res.tempFilePaths;
      // console.log(tempFilePaths);
      const result = await uni.uploadFile({
        url: 'http://192.168.3.1:3000/uploadfile',
        files: [],
        name: 'file',
        formData: {
          'user': 'test'
        },
      });
      console.log(JSON.stringify(result));
    }
  }
}
</script>


<style></style>
