<template>
  <view>
   <button @click="click">click</button>
  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  methods: {
    click(){
			uni.shareWithSystem({
			  summary: '',
			  href: 'https://uniapp.dcloud.io',
			  success(){
			    // 分享完成，请注意此时不一定是成功分享
			  },
			  fail(){
			    // 分享失败
			  }
			})

    }
  }
}
</script>


<style></style>

