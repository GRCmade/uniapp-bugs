
<template>
	<view class="content">
		<com-a></com-a>
		<!-- <view class="box">yuhe</view> -->
		<web-view :src="preview" :update-title="false" style="margin-top: 88rpx;">
		</web-view>
	</view>
</template>

<script>
	import com from './com.vue'
	import comA from './com-a.vue';
	export default {
		components:{com,comA},
		data() {
			return {
				title: 'Hello',
				preview:'https://www.baidu.com'
			}
		},
		onLoad() {
			console.log('123');
		},
		methods: {
		}
	}
</script>

<style>
	.box{
		height: 88rpx;
		width: 100%;
		background-color: #36d;
		/* z-index: 10000; */
	}
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
		margin-top: 88rpx;
	}

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
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
</style>
