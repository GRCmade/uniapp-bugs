<template>
	<view>
		<!-- logo 结束 -->
		<!-- 账号密码输入 开始 -->
		<view class="login-user">
			<view class="user-account">
				<input class="user-input" v-model="userAcc" placeholder="请输入账号adminyg"></input>
			</view>
			<view class="user-account">
				<input class="user-input" v-model="userPwd" placeholder="请输入密码111111"></input>
			</view>
		</view>
		<!-- 账号密码输入 结束 -->
		<!-- 登录 开始 -->
		<view class="login-btn">
			<button class="b-login" @click="login">登录</button>
		</view>
	</view>
</template>

<script>
	import Md5 from "js-md5"
	export default {
		data() {
			return {
				userAcc: 'adminyg',
				userPwd: "111111",
				cid: '787787878787878787878'
			};
		},
		methods: {
			login() {
				//获取当前系统名称IOS ANDROID HARMONY
				let osName = uni.getSystemInfoSync().osName;
				this.$rqt.login_login({
					loginCode: this.userAcc,
					loginPwd: Md5(this.userPwd),
					cid: this.cid,
					osName: osName
				}).then(res => {
					if (res.status) {
						uni.navigateTo({
							url: "/pages/index/index"
						});
					} else {
						uni.showToast({
							title: res.message,
							icon: "none"
						});
					}
				});
			}
		},
	}
</script>

<style lang="scss">
	page {
		background-color: #fff;
		// overflow-y: hidden;
	}

	.bg-top {
		position: fixed;
		top: 0;
		left: 0;
		right: 0;
		width: auto;
		z-index: 0;
	}

	.bg-bottom {
		position: fixed;
		bottom: 0;
		left: 0;
		right: 0;
		width: auto;
		z-index: -1;
	}

	.login-logo {
		display: flex;
		justify-content: center;
		align-items: center;
		flex-direction: column;
		padding-top: 220rpx // margin-top: 220rpx;
	}

	.login-user {
		padding: 0rpx 74rpx 20rpx 74rpx;
		position: relative;

		.user-account {
			display: flex;
			justify-content: center;
			align-items: center;
			background-color: #ebf1f9;
			height: 104rpx;
			border-radius: 50rpx;
			margin: 20rpx 0rpx;
			padding: 0 20rpx 0 20rpx;

			.user-icon {
				margin-left: 18rpx;
			}

			.user-input {
				margin-left: 28rpx;
			}
		}
	}

	.login-btn {
		padding: 0 74rpx 0 74rpx;
		position: relative;

		.b-login {
			border-radius: 50rpx;
			height: 110rpx;
			line-height: 110rpx;
			background-color: #3b86f6;
			box-shadow: 0 0 10px rgba(59, 134, 246, 0.2);
			color: #fff;
			font-size: 32rpx;
			font-weight: bold;
		}
	}

	.login-server {
		padding: 40rpx 74rpx 0 74rpx;
		display: flex;
		align-items: center;

		.s-tip {
			color: #92939e;
			font-size: 26rpx;
		}

		.s-name {
			color: #3b86f6;
			font-size: 26rpx;
			flex: 1;
			/* 占据剩余空间 */
			white-space: nowrap;
			/* 防止换行 */
			overflow: hidden;
			/* 超出部分隐藏 */
			text-overflow: ellipsis;
			/* 显示省略号 */
		}

		.s-set {
			font-size: 24rpx;
			color: #3b86f6;
			margin-left: 20rpx;
			background-color: #e3efff;
			padding: 4rpx 15rpx 4rpx 15rpx;
			border-radius: 50rpx;
		}
	}

	.login-agree {
		padding: 40rpx 74rpx 0 74rpx;
		position: fixed;
		bottom: 0;
		left: 0;
		right: 0;
		margin-bottom: 120rpx;

		checkbox {
			transform: scale(0.7)
		}

		.a-span {
			color: #92939e;
			font-size: 24rpx;
			margin-left: -5rpx;

			.a-text {
				color: #3b86f6;
			}
		}
	}
</style>