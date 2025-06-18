<template>
  <view :class="{ 'page-styled': isStyled }">
    当前页面： index-next
    <button @click="click">index-next</button>
  </view>
</template>
<script>
export default {
  data() {
    return {
      isStyled: false // 控制样式是否应用的状态
    }
  },
  methods: {
    click() {
      // 切换样式状态
      this.isStyled = !this.isStyled

      // 如果需要导航到其他页面，可以添加以下代码：
      // uni.navigateTo({
      //   url: '/pages/index/index-next'
      // })
    }
  }
}
</script>
<style>
/* 默认page样式 */
page {
  background-color: #fff;
}

/* 点击后添加的样式 */
.page-styled {
  padding: 20px;
  border: 20px solid #000;
  /* 用边框代替 padding */
  box-sizing: border-box;
  border-radius: 50px;
  background-color: #f0f0f0;
}
</style>
