<template>
  <view>
    <div>{{ notChange }}</div>
    <!-- <div>{{ scrollOffset }}</div> -->
    <div v-for="i in 100">{{ i }}</div>
  </view>
</template>

<script>

export default {
  data() {
    return {
      scrollOffset: 0,
    };
  },
  computed: {
    notChange() {
      return this.scrollOffset >= 0 ? 1 : 0;
    }
  },
  onPageScroll(e) {
    const { scrollTop = 0 } = e;
    this.scrollOffset = scrollTop;
    console.log('onPageScroll');
    this.$nextTick(() => {
      console.log('这里应该被调用，现在没有调用');
    });
  },
};
</script>