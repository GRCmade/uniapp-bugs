<template>
  <view>
    <button @click="click">click</button>
    <uni-search-bar v-model="searchValue" @confirm="" placeholder="" />
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
      searchValue: ''
    }
  },
  computed: {
    cancelTextI18n() {
      return this.cancelText || t("uni-search-bar.cancel")
    }
  },
  methods: {
    click() {

    }
  }
}
</script>


<style></style>
