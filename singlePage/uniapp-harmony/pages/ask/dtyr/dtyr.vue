<template>
  <div>
    <h1>动态导入 JS 文件示例</h1>
    <button @click="loadAndExecute">加载并执行函数</button>
    <p v-if="message">{{ message }}</p>
  </div>
</template>

<script>
export default {
  data() {
    return {
      message: ''
    };
  },
  methods: {
    loadAndExecute() {
   //    import("@/pages/ask/dtyr/utility.js").then((res)=>{
			// 	console.log(res);
			// })
    }
  }
};
</script>

<style scoped>
h1 {
  color: teal;
}
button {
  margin-top: 10px;
}
</style>