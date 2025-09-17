<template>
  <view>
    {{ tempFilePath }}
    <image :src="tempFilePath" mode=""></image>
    <button @click="chooseMedia('fileNext')">chooseMedia - fileNext</button>
    <button @click="chooseImage('fileNext')">chooseImage - fileNext</button>
    <button @click="chooseMedia('fileOnlyReadFile')">chooseMedia - fileOnlyReadFile</button>
    <button @click="chooseImage('fileOnlyReadFile')">chooseImage - fileOnlyReadFile</button>
  </view>
</template>
<script lang="ts" setup>
import { ref } from 'vue'
const tempFilePath = ref()
const fileSystemManager = uni.getFileSystemManager()
const chooseMedia = (type: string) => {
  uni.chooseMedia({
    count: 1,
    mediaType: ['image'],
    sourceType: ['album', 'camera'],
    success: res => {
      tempFilePath.value = res.tempFiles[0].tempFilePath
      console.log('chooseMedia', res.tempFiles[0].tempFilePath)
      if (type == 'fileNext') fileNext(res.tempFiles[0].tempFilePath)
      if (type == 'fileOnlyReadFile') fileOnlyReadFile(res.tempFiles[0].tempFilePath)
    },
    fail: err => {
      console.log('chooseMedia', err)
    }
  })
}

const chooseImage = (type: string) => {
  uni.chooseImage({
    count: 1,
    albumMode: 'system',
    // sizeType: ["original"],
    sourceType: ['album', 'camera'],
    success: res => {
      tempFilePath.value = res.tempFilePaths[0]
      console.log('chooseImage', res.tempFilePaths[0])
      if (type == 'fileNext') fileNext(res.tempFilePaths[0])
      if (type == 'fileOnlyReadFile') fileOnlyReadFile(res.tempFilePaths[0])
    }
  })
}

const fileOnlyReadFile = (filePath: string) => {
  console.log('==== fileOnlyReadFile')
  try {
    const result = fileSystemManager.readFileSync(filePath)
    console.log('readFileSync - result', JSON.stringify(result))
  } catch (err) {
    console.log('readFileSync', err) //
  }
}

const fileNext = (filePath: string) => {
  console.log('==== fileNext')

  try {
    let res = uni.getFileSystemManager().openSync({
      filePath: filePath
    })
    console.log('openSync:', JSON.stringify(res))
    let fileStas = uni.getFileSystemManager().fstatSync({
      fd: res
    })
    console.log('fileStas:', JSON.stringify(fileStas))

    uni.getFileSystemManager().readFile({
      filePath: filePath,
      success({ data }: any) {
        let base64 = uni.arrayBufferToBase64(data)
        console.log('readFile success', JSON.stringify(base64))
      },
      fail(res) {
        console.log('readFile fail', res)
      },
      complete() {
        let readFile = uni.getFileSystemManager().readFileSync(filePath)
        console.log('readFileSync:', JSON.stringify(readFile))
      }
    })
  } catch (e) {
    console.log(e)
  }
}
</script>
<style></style>
