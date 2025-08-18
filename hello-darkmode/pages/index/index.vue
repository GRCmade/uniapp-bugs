<template>
	<view class="content">
		<image class="logo" src="/static/logo.png"></image>
		<view class="text-area">
			<text class="title">{{ title }}</text>
		</view>
		<view class="text-area" style="padding: 20rpx 0">
			<text class="title">当前主题：{{ theme }}</text>
		</view>
		<view></view>
		<navigator url="/pages/index/test2">
			<button>跳转至二级页面</button>
		</navigator>
		<view class="paragraph"><text style="font-weight: bold">后续暗黑模式将适配内置组件</text></view>
		<!-- #ifdef H5 -->
		<view class="paragraph">
			<text style="font-weight: bold">（PC-Web 端可使用 Edge 浏览器修改设置中的外观查看效果）</text>
		</view>
		<!-- #endif -->
		<!-- #ifdef APP -->
		<view class="paragraph"><text style="font-weight: bold">（App 端请使用自定义基座）</text></view>
		<!-- #endif -->
		<view class="paragraph">
			<view style="text-indent: 64rpx">
				<text>
					暗黑模式
					<text>（Dark Mode），</text>
					也被称为夜间模式或深色模式，是一种高对比度，或者反色模式的显示模式。是一种有利于在黑暗环境下观看手机的高对比度的模式。uni-app的暗黑模式，是帮助开发者完成自己应用的暗黑模式的一批配置和API。开发者可以参考通过以下按钮打开的文档实现自己应用的暗黑模式。
				</text>
			</view>
			<!-- #ifndef MP -->
			<button @click="openDoc">查看文档</button>
			<!-- #endif -->
			<!-- #ifdef MP -->
			<text>小程序复制到浏览器打开文档： {{ url }}</text>
			<!-- #endif -->

			<!-- #ifdef APP-PLUS -->
			<!-- <button class="button" @click="setUIStyle('light')">setUIStyle Light</button>
			<button class="button" @click="setUIStyle('dark')">setUIStyle Dark</button>
			<button class="button" @click="setUIStyle('auto')">setUIStyle Auto</button> -->
			<!-- #endif -->
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'DarkMode',
				theme: uni.getSystemInfoSync().theme,
				url: 'https://uniapp.dcloud.net.cn/tutorial/darkmode.html',
			}
		},
		onLoad() {
			this.setUIStyle('auto')
			uni.onThemeChange(({ theme }) => {
				console.log('onThemeChange', theme)
				this.theme = theme
			})
		},
		methods: {
			setUIStyle(style) {
				// #ifdef APP
				plus.nativeUI.setUIStyle(style)
				// #endif
			},
			openDoc() {
				// #ifdef APP
				plus.runtime.openWeb(this.url)
				// #endif
				// #ifdef H5
				let a = document.createElement('a')
				a.href = this.url
				a.target = '__blank'
				a.click()
				a = null
				// #endif
			},
		},
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 50rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}

	.mock-btn {
		display: flex;
		justify-content: center;
		align-items: center;
		color: rgba(0, 0, 0, 0.9);
		border: 1px solid #e5e5e5;
		background-color: #f7f7f7;
		border-radius: 5px;
		padding: 20rpx;
	}

	.paragraph {
		padding: 20rpx 40rpx 0;
	}

	@media (prefers-color-scheme: dark) {
		.mock-btn {
			color: hsla(0, 0%, 100%, 0.8);
			background-color: #1f1f1f;
			border-color: #373737;
		}
	}
</style>
