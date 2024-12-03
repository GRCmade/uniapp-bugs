<template>
  <view>
    <button @click="click">click</button>
  </view>
</template>

<script>
export default {
  data() {
    return {
      currentServerName: "", // 初始化变量
    };
  },
  methods: {
    click() {
      // 假设 res 是某个 API 的响应结果，这里需要明确它的定义。
      const res = {
        data: {
          data: {
            List: {
              "@J.srvname": "服务器名称",
            },
          },
        },
      };

      try {
        // 使用 TextEncoder 和 TextDecoder 进行编码和解码
        const encoder = new TextEncoder("utf-8"); // 将 "GB2312" 替换为标准的 "utf-8"，因为 GB2312 不被 TextEncoder 支持
        const decoder = new TextDecoder("utf-8");

        const encoded = encoder.encode(res.data.data.List["@J.srvname"]);
        this.currentServerName = decoder.decode(encoded);

        console.log("Decoded server name:", this.currentServerName);
      } catch (error) {
        console.error("Error during encoding/decoding:", error);
      }
    },
  },
};
</script>

<style></style>