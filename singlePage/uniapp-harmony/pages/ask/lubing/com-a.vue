<template>
	<view>
		<view class="coma">
			<view class="navbar-placeholder" >
				
			</view>
			<view class="sta-bar" style="background-color: #36d;">
				coma
			</view>
			<view class="bar-heigth" style="background-color: #36d;">
				com-a-a
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		name:"com-a",
		data() {
			return {
				
			};
		}
	}
</script>

<style>
	.coma{
		height: 188rpx;
		width: 100%;
	}
/* 	.navbar-placeholder{
		height:88rpx;
		width:100%;
	} */
	.sta-bar{
/* 		position: fixed;
		top:0;
		left:0; */
		width: 100vw;
		height:88rpx;
		z-index: 10000;
	}
	.bar-heigth{
/* 		position: fixed;
		top:88rpx;
		left:0; */
		padding: 0 16px;
		width: 100%;
		height:88rpx;
		z-index: 10000;
	}
</style>