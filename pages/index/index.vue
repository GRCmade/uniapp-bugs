<template>
  <view>
    <button @click="getProviderSync">getProviderSync</button>
    <button @click="login">login</button>
    <button @click="getUserInfo">getUserInfo</button>
  </view>
</template>
<script setup>
const getProviderSync = () => {
  const provider = uni.getProviderSync({service: 'oauth'})
  console.log('provider :>> ' + JSON.stringify(provider));
}

const login = () => {
  uni.login({
    provider: 'huawei',
    success(res) {
      console.log(JSON.stringify(res))
    },
    fail(err) {
      console.log(JSON.stringify(err))
    },
  })
}

const getUserInfo = () => {
  uni.getUserInfo({
    provider: 'huawei',
    success(res) {
      console.log(JSON.stringify(res))
    },
    fail(err) {
      console.log(JSON.stringify(err))
    },
  })
}
</script>

