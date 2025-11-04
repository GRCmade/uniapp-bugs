<template>
  <view>
    <button @click="send">send - json</button>
  </view>
</template>

<script lang="ts" setup>
const click = () => {}
let count = 0
let requestTask = null
const send = async () => {
  console.log('start: ' + ++count)
  requestTask = uni.request({
    url: 'https://mp-740c4f25-0fdf-4df3-8af2-156cb0aab142.cdn.bspapp.com/test.json',
    dataType: 'string',
    success: (res: any) => {
      let ls = JSON.parse(res.data)
      console.log('------end1:', JSON.stringify(ls))
      console.log('------end2:', JSON.stringify(ls?.length))
      requestTask.abort()
      setTimeout(() => {
        send()
      }, 5000)
    },
    fail: err => {
      console.log(err)
    }
  })
}
</script>

<style></style>
