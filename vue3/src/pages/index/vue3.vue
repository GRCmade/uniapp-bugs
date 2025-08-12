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
      const res = await uni.chooseImage({
        count: 1,
        sizeType: ['original', 'compressed'],
        sourceType: ['album', 'camera']
      })
			console.log("res",res)
      const tempFilePaths = res.tempFilePaths
      const upTask = uni.uploadFile({
        url: 'http://192.168.31.211:3001/uploadfile',
        filePath: tempFilePaths[0],
        name: 'file',
        formData: {
          user: 'test'
        },
        success(res) {
          console.log(res)
        }
      })
      upTask.onProgressUpdate(res => {
        console.log('process', res.progress)
      })
    }
  }
}
</script>
<style></style>
