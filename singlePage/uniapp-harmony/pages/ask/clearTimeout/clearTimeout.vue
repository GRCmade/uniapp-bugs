<template>
  <div>
    <p>计数器: {{ counter }}</p>
    <button @click="startCounter">开始计时</button>
    <button @click="stopCounter">停止计时</button>
  </div>
</template>

<script>
export default {
  data() {
    return {
      counter: 0,
      intervalId: null,
    };
  },
  methods: {
    startCounter() {
      // 如果已经有一个计时器在运行，先清除它
      if (this.intervalId) {
        clearInterval(this.intervalId);
      }

      // 启动一个新的计时器，每秒递增计数
      this.intervalId = setInterval(() => {
        this.counter++;
      }, 1000);
    },
    stopCounter() {
      // 清除计时器
      if (this.intervalId) {
        clearInterval(this.intervalId);
        this.intervalId = null;
      }
    },
  },
  beforeDestroy() {
    // 在组件销毁前确保清除计时器
    if (this.intervalId) {
      clearInterval(this.intervalId);
    }
  },
};
</script>