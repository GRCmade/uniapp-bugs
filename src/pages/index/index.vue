<template>
  <view>
    <button @click="click">上传空文件</button>
    <button @click="click1">上传空filePath文件</button>
    <button @click="click2">上传单个文件</button>
    <button @click="click3">上传多个文件</button>
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
      uni.uploadFile({
        url: 'http://192.168.3.1:3000/uploadfile',
        files: [],
        name: 'file',
        formData: {
          'user': 'test'
        },
        success: (uploadFileRes) => {
          console.log(uploadFileRes.data);
        },
        fail: (err) => {
          console.log(err);
        }
      });
    },
    async click1() {
      uni.uploadFile({
        url: 'http://192.168.3.1:3000/uploadfile',
        filePath: '',
        name: 'file',
        formData: {
          'user': 'test'
        },
        success: (uploadFileRes) => {
          console.log(uploadFileRes.data);
        },
        fail: (err) => {
          console.log(err);
        }
      });
    },
    async click2() {
      uni.chooseImage({
        success: (chooseImageRes) => {
          const tempFilePaths = chooseImageRes.tempFilePaths;
          uni.uploadFile({
            url: 'http://192.168.3.1:3000/uploadfile', //仅为示例，非真实的接口地址
            filePath: tempFilePaths[0],
            name: 'file',
            formData: {
              'user': 'test'
            },
            success: (uploadFileRes) => {
              console.log(uploadFileRes.data);
            },
            fail: (err) => {
              console.log(err);
            }
          });
        }
      });

    },
    async click3() {
      uni.chooseImage({
        count: 3,
        sizeType: ['original', 'compressed'],
        sourceType: ['album', 'camera'],
        success: (chooseImageRes) => {
          const tempFilePaths = chooseImageRes.tempFilePaths;
          uni.uploadFile({
            url: 'http://192.168.3.1:3000/uploadfiles',
            files: tempFilePaths,
            name: 'files',
            formData: {
              'user': 'test'
            },
            success: (uploadFileRes) => {
              console.log(uploadFileRes.data);
            },
            fail: (err) => {
              console.log(err);
            }
          });
        }
      });
    }
  }
}
</script>


<style></style>
