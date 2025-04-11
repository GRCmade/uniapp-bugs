<template>
  <view>
    <button open-type="share">share</button>
    <button open-type="openSetting">openSetting</button>
    <button open-type="contact">contact</button>
    <button open-type="getPhoneNumber" @getphonenumber="getPhoneNumber">getPhoneNumber</button>
    <button type="button" open-type="getUserInfo" lang="zh_CN" @getuserinfo="getUser">获取用户信息</button>  
  </view>
</template>

<script lang="ts">
export default {
  methods: {
    getUser(e: any) {
      console.log('用户信息', e)
    },
    getPhoneNumber(e: any) {
      console.log('获取手机号', e)
    }
  },
  onShareAppMessage() {
    return {
      title: '分享',
      path: '/pages/index/index'
    }
  }
}
</script>

<style></style>
