<template>  
  <list class="scroll" :id="pageId" fix-freezing>  
    <slot name="refresh"></slot>  
    <cell ref="head">  
      <slot name="header"></slot>  
    </cell>  
    <cell :style="{ height: pageHeight }" @appear="setEffects">  
      <slot name="sticky"></slot>  
      <waterfall  
        ref="waterfall"  
        class="scroll"  
        fix-freezing  
        :bounce="false"  
        :show-scrollbar="false"  
        :left-gap="gap32"  
        :right-gap="gap32"  
        :column-gap="gap24"  
        :column-width="colWidth"  
        :column-count="colCount"  
        v-bind="$attrs"  
      >  
        <slot name="default"></slot>  
        <slot name="footer"></slot>  
      </waterfall>  
    </cell>  
  </list>  
</template>  

<script>  
export default {  
  data() {  
    return {  
      pageId: `page-id-${Date.now()}`,  
      headHeight: null,  
      pageHeight: null,  
      gap32: uni.upx2px(32),  
      gap24: uni.upx2px(24),  
      colWidth: uni.upx2px(331),  
      colCount: 3,  
    }  
  },  
  async mounted() {  
    const sys = uni.getSystemInfoSync()  
    const rect = await getComponentRect(this.$refs.head)  
    this.headHeight = rect.height  
    this.pageHeight = sys.windowHeight - rect.top  
    this.setEffects()  
  },  
  methods: {  
    async setEffects() {  
      const id = this.pageId  
      const headerHeight = Math.round(this.headHeight)  
      await this.$nextTick()  
      this.$refs.waterfall.setSpecialEffects({ id, headerHeight })  
    },  
  },  
}  

const dom = weex.requireModule('dom')  

function getComponentRect(ref) {  
  return new Promise((resolve, reject) => {  
    dom.getComponentRect(ref, res => {  
      return res.result ? resolve(res.size) : reject(res.result)  
    })  
  })  
}  
</script>  

<style lang="scss" scoped>  
.scroll {  
  position: relative;  
  flex: 1;  
  width: 750rpx;  
}  
</style>