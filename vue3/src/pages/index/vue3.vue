<template>
  <view>
    <button @click="chooseImage">chooseImage</button>
    <button @click="chooseMedia">chooseMedia</button>
  </view>
</template>

<script lang="ts" setup>
const chooseImage = () => {
  uni.chooseImage({
    count: 1,
    sourceType: ['album'],
    success: res => {
      try {
        getSyncFile(res.tempFilePaths[0])
      } catch (err) {
        console.log('readFileSync', err) //
      }
    },
    fail: err => {
      console.log('chooseMedia', err)
    }
  })
}

const chooseMedia = () => {
  uni.chooseMedia({
    count: 1,
    success: res => {
      getSyncFile(res.tempFiles[0].tempFilePath)
    },
    fail: err => {
      console.log('chooseMedia', err)
    }
  })
}

const getSyncFile = (path: string) => {
  console.log('getSyncFile', path)
  const fileSystemManager = uni.getFileSystemManager()
  const res = fileSystemManager.readFileSync(path)
  console.log(res)
}
</script>

<style></style>
