<template>
  <view class="container">
    <text>WebSocket 连接状态: {{ status }}</text>
    <text>接收到的消息: {{ message }}</text>
    <button @click="requestFile">请求文件</button>
  </view>
</template>

<script>
export default {
  data() {
    return {
      status: '未连接',
      message: ''
    };
  },
  onLoad() {
    this.connectWebSocket();
  },
  methods: {
    connectWebSocket() {
      // 创建 WebSocket 连接
      this.status = '连接中...';
      const socket = uni.connectSocket({
        url: 'ws://localhost:8080', // 替换为你的 WebSocket 服务器地址
        success: () => {
          this.status = '已连接';
        },
        fail: () => {
          this.status = '连接失败';
        }
      });

      // 监听 WebSocket 打开事件
      socket.onOpen(() => {
        this.status = '连接已打开';
      });

      // 监听 WebSocket 消息事件
      socket.onMessage((res) => {
        const buffer = res.data;
        if (buffer instanceof ArrayBuffer) {
          // 使用 TextDecoder 解码 ArrayBuffer 数据
          const decodedMessage = new TextDecoder('utf-8').decode(buffer);
          this.message = decodedMessage;
        }
      });

      // 监听 WebSocket 关闭事件
      socket.onClose(() => {
        this.status = '连接已关闭';
      });

      // 监听 WebSocket 错误事件
      socket.onError((error) => {
        this.status = `连接错误: ${error}`;
      });

      // 保存 socket 实例
      this.socket = socket;
    },
    requestFile() {
      if (this.socket) {
        this.socket.send('请求文件');
      }
    }
  }
};
</script>

<style>
.container {
  padding: 20px;
}
</style>