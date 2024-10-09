<template>
	<scroll-view class="chat_scroll_view" :scroll-y="ableScroll" :scroll-with-animation="true"
		@scrolltolower="queryMsgList">
		<button @click="click">click</button>
		<view>
			<view class="msg_item_line" v-for="(item,index) in msgList" :key="item.id">
				<view class="msg_user_avatar">
					<image :src="item.photo" width="100%" :key="item.id" :keys="item.id" />
				</view>
				<view class="msg_text" v-html="item.message"></view>
			</view>
		</view>
	</scroll-view>
</template>
<script>
	export default {
		data() {
			return{
				msgList: [{
					"id": "1728353615067zdxsqyfw",
					"fromid": "5F5F62C5A4564FEF839F3B91EB7F0932",
					"toid": "607BCC56691C48E18E14F95FCA7B0766",
					"msgtype": 1,
					"message": "123",
					"status": 1,
					"createtime": 1728353615537,
					"name": "杨",
					"photo": "http://119.60.25.62:19000/user-photo/20240903/1724917237-compressed-IMG_1673_20240903143647A060.JPG"
				}]
			}
			
		},
		methods: {
			click(){
				this.handleMsgPush(this.msgList[0])
			},
			// 新消息插入  
			handleMsgPush(msgData) {
				this.msgList.unshift(msgData);
				this.$forceUpdate()

			},
		}
	}
</script>

<style>
	.msg_user_avatar{
		width: 200rpx;
		height: 200rpx;
	}
</style>