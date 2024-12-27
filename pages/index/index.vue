<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>


<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				var socketOpen = false;
				var socketMsgQueue = ["1","2"];

				uni.connectSocket({
					url: "http://192.168.31.148:3000/connection", // 替换为您的 WebSocket 服务器 URL  
				});
				console.log('连接HMsocket:connectSocket');
				uni.onSocketOpen(function (res) {
				  socketOpen = true;
				  for (var i = 0; i < socketMsgQueue.length; i++) {
				    sendSocketMessage(socketMsgQueue[i]);
				  }
				  socketMsgQueue = [];
				});
				uni.onSocketError(function(res) {
					console.log('WebSocket连接打开失败，请检查！');
				});
				function sendSocketMessage(msg) {
				  if (socketOpen) {
				    uni.sendSocketMessage({
				      data: msg
				    });
				  } else {
				    socketMsgQueue.push(msg);
				  }
				}
			}
		}
	}
</script>


<style></style>