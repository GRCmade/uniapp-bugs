<template>
	<view class="container" :class="themeClass">
		<view class="info-section">
			<text class="title">系统主题信息</text>
			<view class="info-item">
				<text class="label">当前主题：</text>
				<text class="value">{{ appTheme }}</text>
			</view>
			<view class="info-item">
				<text class="label">系统版本：</text>
				<text class="value">{{ systemVersion }}</text>
			</view>
			<view class="info-item">
				<text class="label">平台：</text>
				<text class="value">{{ platform }}</text>
			</view>
		</view>

		<view class="button-group">
			<button @click="getThemeInfo" type="primary">获取主题信息</button>
			<button @click="setAppThemeLight" type="default">setAppThemeLight</button>
			<button @click="setAppThemeDark" type="default">setAppThemeDark</button>
		</view>

		<view class="result-section">
			<text class="subtitle">完整系统信息：</text>
			<text class="result-text">{{ systemInfoText }}</text>
		</view>
	</view>
</template>

<script>
	import { setAppThemeLight,setAppThemeDark } from '@/uni_modules/uni-getbatteryinfo';
export default {
	data() {
		return {
			appTheme: '',
			systemVersion: '',
			platform: '',
			systemInfoText: '',
			themeClass: 'light-theme'
		}
	},
	onLoad() {
		// 页面加载时获取主题信息
		this.getThemeInfo();
	},
	methods: {
		// 获取系统主题信息
		getThemeInfo() {
			uni.getSystemInfo({
				success: (res) => {
					console.log('系统信息：', res);

					// 获取主题信息
					this.appTheme = res.appTheme || '未知';
					this.systemVersion = res.system || '未知';
					this.platform = res.platform || '未知';

					// 根据主题设置样式
					this.themeClass = res.appTheme === 'dark' ? 'dark-theme' : 'light-theme';

					// 格式化显示完整信息
					this.systemInfoText = JSON.stringify(res, null, 2);

					// 提示用户
					uni.showToast({
						title: `当前主题: ${this.appTheme}`,
						icon: 'none'
					});
				},
				fail: (err) => {
					console.error('获取系统信息失败：', err);
					uni.showToast({
						title: '获取失败',
						icon: 'none'
					});
				}
			});
		},

		// 切换主题预览（仅用于演示UI效果）
		setAppThemeDark(){
			setAppThemeDark()
		},
		setAppThemeLight() {
			setAppThemeLight()
		}
	}
}
</script>

<style scoped>
.container {
	min-height: 100vh;
	padding: 40rpx;
	transition: background-color 0.3s, color 0.3s;
}

/* 浅色主题 */
.light-theme {
	background-color: #f5f5f5;
	color: #333;
}

.light-theme .info-section,
.light-theme .result-section {
	background-color: #fff;
	border: 1px solid #e0e0e0;
}

/* 深色主题 */
.dark-theme {
	background-color: #1a1a1a;
	color: #e0e0e0;
}

.dark-theme .info-section,
.dark-theme .result-section {
	background-color: #2a2a2a;
	border: 1px solid #404040;
}

.info-section {
	margin-bottom: 40rpx;
	padding: 30rpx;
	border-radius: 16rpx;
}

.title {
	font-size: 36rpx;
	font-weight: bold;
	margin-bottom: 30rpx;
	display: block;
}

.info-item {
	display: flex;
	margin-bottom: 20rpx;
	align-items: center;
}

.label {
	font-size: 28rpx;
	margin-right: 20rpx;
	opacity: 0.7;
}

.value {
	font-size: 28rpx;
	font-weight: bold;
}

.button-group {
	margin-bottom: 40rpx;
}

.button-group button {
	margin-bottom: 20rpx;
}

.result-section {
	padding: 30rpx;
	border-radius: 16rpx;
}

.subtitle {
	font-size: 32rpx;
	font-weight: bold;
	margin-bottom: 20rpx;
	display: block;
}

.result-text {
	font-size: 24rpx;
	line-height: 1.6;
	word-break: break-all;
	white-space: pre-wrap;
	font-family: monospace;
	display: block;
}
</style>
