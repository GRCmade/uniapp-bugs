<template>
  <view class="container">演示Vue3版微信小程序import错误</view>
</template>
<script>
// #ifdef VUE3
/**
 * VUE3编译：app端不再支持require
 * 微信小程序调试时全部支持，发行版不支持export defaut。（不知道什么不统一！！！，可能通过微信开发者查看源码是uniapp官方的问题)
 */
import { filepickerESM } from '../../static/js/wxy-file-picker-esm.js'
console.log('filepickerESM =>', filepickerESM)
//微信小程序调试时支持，但发行版时是undefined。查看微信开发者中源码是uniapp编译的问题
import filepickerMixin from '../../static/js/wxy-file-picker-mixin.js'
console.log('filepickerMixin =>', filepickerMixin)
// #endif
export default {
  // #ifdef VUE3
  // mixins: [filepickerESM],
  mixins: [filepickerMixin], //微信小程序编译发行版，因为    filepickerMixin是undefined导致失败报错
  // #endif
  data() {
    return {}
  },
  onReady() {
    this.test1()
  },
  methods: {
    test1() {
      // console.log('test =>', this.test('Hello World'))
    }
  }
}
</script>

<style lang="scss">
.container {
  padding: 10px 20px;
}
</style>
