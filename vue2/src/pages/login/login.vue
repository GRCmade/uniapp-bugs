<template>
	<view class="normal-login-container">
		<view class="logo-content">
			<image style="width: 160.39rpx;height: 160.39rpx;" src="@/static/logo/logo.png" mode="widthFix"></image>
			<text style="margin-top: 5px;font-weight: 500;font-size: 18px;">农芯数智治村</text>
		</view>
		<view v-show="!isOther" class="login-footer-icon">
		    <u-button
		        shape="circle"
		        openType="getPhoneNumber"	
		        @getphonenumber="getPhoneNumber"
		        :hoverStopPropagation="false"
		        type="primary"
		        text="手机号快捷登录" 
		        customStyle="width: 686rpx;height: 80rpx;background: #0052D9;margin-top:48rpx;border:unset"
			></u-button>
			<u-button
				@click="changeButton"
			    shape="circle"
			    :hoverStopPropagation="false"
			    text="手机号验证码登录" 
			    customStyle="width: 686rpx;height: 80rpx;border:unset"
			></u-button>
		</view>
		<view  v-show="isOther" class="login-form-content">
			<view style="border-bottom: 1px solid #E7E7E7;padding: 12rpx 0;">
				<u-input 
					v-model="loginForm.phoneCode" 
					:border="false" 
					placeholder="请输入手机号"
					placeholderStyle="font-size:34rpx;color: rgba(0, 0, 0, 0.4)"
					maxlength='11'
					@change="phoneChange"
					type='number'
					clearable>
				</u-input>
			</view>
			<view style="margin-top: 15px;border-bottom: 1px solid #E7E7E7;padding: 12rpx 0;">
				<u-input 
					:border="false"
					placeholder="请输入验证码" 
					v-model="loginForm.loginCode"
					maxlength="6"
					@change="phoneChange"
					placeholderStyle="font-size:34rpx;color: rgba(0, 0, 0, 0.4)">
					<template slot="suffix">
						<u-code 
							ref="uCode" 
							@change="codeChange"
							@start="codeStart"
							@end="codeEnd"
							seconds="60"
							changeText="x秒重新获取">
						</u-code>
						<text 
							@tap="getCode" 
							size="32rpx" 
							style="color: rgba(0, 0, 0, 0.4)"
							:text="codeText"
						>{{codeText}}</text>
					</template>
				</u-input>
			</view>
			<view @click="changeButton" class="back">
				返回
			</view>
			<view style="margin-top: 25px;">
				<u-button 
					type="primary" 
					class="login-btn" 
					:disabled="loginDisabled" 
					text="登录"
					@click="handleLogin">
				</u-button>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				codeUrl: "",
				loginDisabled: true,
				codeText: '获取验证码',
				loginForm: {
					phoneCode: "",
					loginCode: ""
				},
                isSend: true,
				isOther: false
			}
		},
		methods: {
            // 获取验证码
			getCode() {
				
			},
			phoneChange() {
				
			},
			codeChange(text) {
				
			},
            codeStart() {
                
            },
            codeEnd() {
                
            },
			// 手机号验证码登录
            async handleLogin() {
                
			},
			// 手机号一键登录
			async wxLogin(loginCode, phoneCode) {
				
			},
			// 权限控制，计入不同的页面
			handlePermission(data) {
				
			},
            // 获取网格信息
            async getGridInfo() {
                
            },
			// 个人认证状态
			async getStatus() {
			    
			},
			// 获取网格列表
            async getGridList() {
                
            },
			// 微信小程序获取手机号
            getPhoneNumber(e) {
               
            },
			changeButton() {
				
			}
		}
	}
</script>

<style lang="scss">
	page {
		background-color: #ffffff;
	}

	.normal-login-container {
		width: 100%;

		.logo-content {
			width: 100%;
			text-align: center;
			padding-top: 15%;
			display: flex;
			flex-direction: column;
			align-items: center;
			justify-content: center;
			image {
				border-radius: 4px;
			}
		}

		.login-form-content {
			text-align: center;
			margin: 20px auto;
			margin-top: 15%;
			width: 80%;

			.input-item {
				margin: 20px auto;
				background-color: #f5f6f7;
				height: 90rpx;
				
				.input {
					width: 100%;
					font-family: 'PingFang SC-Regular';
					font-size: 40rpx;
					line-height: 56rpx;
					text-align: left;
					padding-left: 15rpx;
				}
			}

			.login-btn {
				margin-top: 40px;
				height: 80rpx;
				border: none;
			}
			.back {
				text-align: right;
				color: #0052D9;
				font-size: 14px;
				margin-top: 8px;
				float: right;
				margin-bottom: 24rpx;
			}

		}
	}

	button::after {
		border: none;
	}
    // ::v-deep {
    //     .u-icon__img {
    //         width: 30px !important;
    //         height: 30px !important;
    //     }
    // }
</style>