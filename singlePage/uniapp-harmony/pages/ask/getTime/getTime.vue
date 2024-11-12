<template>
  <div>
    <p>当前时间戳：{{ currentTime }}</p>
    <button @click="updateTime">获取当前时间戳</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      currentTime: null
    };
  },
  methods: {
    updateTime() {
      // 获取当前时间戳
      this.currentTime = new Date().getTime();
    }
  },
  mounted() {
    // 页面加载时显示当前时间戳
    this.updateTime();
  }
};
</script>