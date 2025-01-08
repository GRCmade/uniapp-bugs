<template>
	<view>
		<button @click="connectSocket">连接 task</button>
		<button @click="connectSocket2">连接 uni.socket</button>
		<button @click="sendMessage">发送</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				socketOpen: false, // 表示 WebSocket 是否连接成功
				socketMsgQueue: ["1", "2"], // 待发送的消息队列
			};
		},
		methods: {
			// 发送消息方法
			sendSocketMessage(msg) {
				uni.sendSocketMessage({
					data: msg,
					success(res) {
						console.log("消息发送成功:", res);
					},
					fail(res) {
						console.error("消息发送失败:", res);
					},
				});
				// if (this.socketOpen) {

				// } else {
				// 	this.socketMsgQueue.push(msg);
				// 	console.log("WebSocket 未连接，消息已加入队列:", msg);
				// }
			},
			// 点击发送按钮时调用
			sendMessage() {
				this.sendSocketMessage("yuhe");
			},
			// 点击连接按钮时调用
			connectSocket() {
				let socketTask = uni.connectSocket({
					url: "ws://192.168.31.148:3000/connection", // 替换为您的 WebSocket 服务器 URL
					complete: ()=> {}
				});
				
				socketTask.onOpen((data)=>{
					console.log("socketTask.onOpen",JSON.stringify(data));
					socketTask.send({
						data:"socketTask.send",
						success(res) {
							console.log("socketTask.send",JSON.stringify(res));
						},
						fail(res) {
							console.log("socketTask.send-fail",JSON.stringify(res));
						}
					})
				})
				
			},
			connectSocket2(){
				uni.connectSocket({
					url: "ws://192.168.31.148:3000/connection", // 替换为您的 WebSocket 服务器 URL
					complete: ()=> {}
				});
				// WebSocket 连接成功
				uni.onSocketOpen(() => {
					console.log("WebSocket 连接已打开");
					this.socketOpen = true;
				
					// 发送队列中的消息
					while (this.socketMsgQueue.length > 0) {
						const message = this.socketMsgQueue.shift();
						this.sendSocketMessage(message);
					}
				});
				
				// WebSocket 连接失败
				uni.onSocketError((res) => {
					console.error("WebSocket 连接失败:", res);
				});
				
				// WebSocket 收到消息
				uni.onSocketMessage((res) => {
					console.log("收到消息:", res.data);
				});
				
				// WebSocket 关闭
				uni.onSocketClose(() => {
					console.log("WebSocket 已关闭");
					this.socketOpen = false;
				});
			}
		},
	};
</script>

<style>
	/* 样式部分可以根据需求调整 */
</style>