<template>
  <view>
   <view
     v-for="(item, index) in items"
     :key="index"
     :style="{ backgroundColor: selected === index ? 'lightgreen' : 'lightblue' }"
     style="display: inline-block; width: 60px; height: 50px;"
     @tap="selectItem(index)"
   >
     {{ item.name }}
   </view>
  </view>
</template>

<script>
export default {
  data() {
    return {
      items: Array.from({ length: 20 }, (_, i) => ({ name: `Item ${i + 1}` })),
      selected: null,
      left: 0
    };
  },
  methods: {
    selectItem(index) {
      this.selected = index;
      this.scrollToItem(index);
    },
    scrollToItem(index) {
      this.left = 50 * index;
    }
  }
};
</script>

<style>
/* 添加样式以确保 scroll-view 和子元素的正确显示 */
scroll-view {
  width: 100%;
  height: 100px;
  background-color: #f8f8f8;
}
</style>