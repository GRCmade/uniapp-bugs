<template>
  <view>
    <uni-search-bar v-model="searchValue" @confirm="" />
    {{ cancelTextI18n }}
  </view>
</template>

<script>
import {
  initVueI18n
} from '@dcloudio/uni-i18n'
import messages from '../../common/i18n/index.js'
const {
  t
} = initVueI18n(messages)
export default {
  data() {
    return {
      title: 'left-window',
      searchValue: ''
    }
  },
  computed: {
    cancelTextI18n() {
      return this.cancelText || t("uni-search-bar.cancel")
    }
  },
  mounted() {
    console.log(uni.getLocale())
  },
  methods: {

  }
}
</script>

<style>
.content {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.logo {
  height: 200rpx;
  width: 200rpx;
  margin-top: 200rpx;
  margin-left: auto;
  margin-right: auto;
  margin-bottom: 50rpx;
}

.text-area {
  display: flex;
  justify-content: center;
}

.title {
  font-size: 36rpx;
  color: #8f8f94;
}
</style>
