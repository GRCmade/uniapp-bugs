<template>
  <scroll-view scroll-y class="scroll-content">
    <uni-swipe-action>
      <uni-swipe-action-item>
        <uni-card @click="card点击事件" class="uni-conntct-card">
        </uni-card>
        <template v-slot:left>
          <view class="right-slide" @click.stop="重命名点击事件()">
            <view>
              <uni-icons custom-prefix="iconfont" type="icon-zhongmingming" size="5vw" />
              <br />
              <text>重命名</text>
            </view>
          </view>
          <view class="right-slide" @click.stop="删除点击事件()">
            <view>
              <uni-icons type="trash-filled" size="5vw"></uni-icons>
              <br />
              <text>删除</text>
            </view>
          </view>
        </template>
      </uni-swipe-action-item>
    </uni-swipe-action>
  </scroll-view>
</template>

<script>
export default {
  data() {
    return {
      // 这里可以添加您需要的数据
    }
  },
  methods: {
    card点击事件() {
      console.log('卡片被点击了')
      uni.showToast({
        title: '卡片被点击',
        icon: 'none'
      })
    },
    重命名点击事件() {
      console.log('重命名按钮被点击了')
      uni.showToast({
        title: '重命名操作',
        icon: 'none'
      })
    },
    删除点击事件() {
      console.log('删除按钮被点击了')
      uni.showModal({
        title: '提示',
        content: '确定要删除吗？',
        success: (res) => {
          if (res.confirm) {
            uni.showToast({
              title: '删除成功',
              icon: 'success'
            })
          }
        }
      })
    }
  }
}
</script>

<style scoped>
.scroll-content {
  height: 80vh;
  /* Adjust height to leave room for the tabBar */
  overflow-y: scroll;
}

.uni-conntct-card {
  margin-bottom: 0% !important;
  height: 15vh;
  margin-left: 5%;
  margin-right: 5%;
}

.right-slide {
  overflow-wrap: anywhere;
  height: 100%;
  justify-content: center;
  width: 18vw;
  text-align: center;
  align-items: center;
  display: flex;
}
</style>