<template>
  <view>
    <button @click="click">click</button>
    <uni-search-bar v-model="searchValue" @confirm="" placeholder="" />
    <view>{{ '文字：' + cancelTextI18n }}</view>
    <view>{{ '语言：' + local }}</view>
    <!-- <com></com> -->
  </view>
</template>


<script>
import { initVueI18n } from '@dcloudio/uni-i18n'
import messages from '../../common/i18n/index.js'
const { t } = initVueI18n(messages)
import com from './com.vue'
export default {
  components: {
    com
  },
  data() {
    return {
      searchValue: '',
      local: ''
    }
  },
  computed: {
    cancelTextI18n() {
      return this.cancelText || t("uni-search-bar.cancel")
    }
  },
  onLoad() {
    this.local = uni.getLocale()
  },
  methods: {
    click() {

    }
  }
}
</script>


<style></style>
