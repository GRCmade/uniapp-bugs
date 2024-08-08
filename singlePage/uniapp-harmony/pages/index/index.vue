<template>
	<view class="box">
		<view v-for="(item,index) in ls" :key="index">
			<button @click="click(item)" size="mini" type="primary">{{item}}</button>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello',
				ls:[196265]
			}
		},
		onLoad() {
			
		},
		methods: {
			click(id){
				uni.navigateTo({
					url:`/pages/ask/${id}/${id}`
				})
			}
		}
	}
</script>

<style lang="scss">
	.box{
		display: flex;
		width: 100%;
		flex-wrap: wrap;
		button{
			margin: 10rpx;
			font-size: 30rpx;
			font-weight: 700;
			padding: 15rpx;
		}
	}
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
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
