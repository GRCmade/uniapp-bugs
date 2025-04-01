<template>
  <view>
    <button @click="click">上传空文件</button>
    <button @click="click2">上传文件</button>
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
      const result = await uni.uploadFile({
        url: 'http://192.168.3.1:3000/uploadfile',
        files: [],
        name: 'file',
        formData: {
          'user': 'test'
        },
      });
      console.log(JSON.stringify(result));
    },
    async click2() {
      const res = await uni.chooseImage({
        count: 1,
        sizeType: ['original', 'compressed'],
        sourceType: ['album', 'camera']
      });
      const tempFilePaths = res.tempFilePaths;
      console.log(tempFilePaths);
      const result = await uni.uploadFile({
        url: 'http://192.168.3.1:3000/uploadfile',
        files: [{
          name: 'file',
          type: 'image/jpeg',
          size: 1024,
          content: 'test'
        }],
      });
    }
  }
}
</script>


<style></style>
