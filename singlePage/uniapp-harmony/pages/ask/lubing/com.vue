<template>
	<view class="navbar" :style="{'backgroundColor':bgColor}">
		<view class="navbar-placeholder" v-if="placeholder" >
			
		</view>
		<view class="sta-bar" :style="{'backgroundColor':bgColor}">
			
		</view>
		<view class="zwy-navbar"
			:style="{'backgroundColor':bgColor}">
			<view @click="goBack">
				<slot name="left">
					<u-icon size="20" name="arrow-left" v-if="autoBack"
						:color="leftIconColor" style="margin-right: 10px;" ></u-icon>
				</slot>
			</view>
			
			<slot name="center">
				<view class="title">
					{{title}}
				</view>
			</slot>
			
			<slot name="right" >
				<view class="right" @click="clickRight">
					{{rightText}}
				</view>
			</slot>
		</view>
	</view>
	
</template>

<script>
	export default {
		props:{
			autoBack:{
				type:Boolean,
				default:false
			},
			bgColor:{
				type:String,
				default:"#2e6efc"
			},
			leftIconColor:{
				type:String,
				default:"#fff"
			},
			placeholder:{
				type:Boolean,
				default:true
			},
			title:{
				type:String,
				default:""
			},
			rightText:{
				type:String,
				default:""
			},
		},
		name:"zwy-navbar",
		data() {
			return {
				
			};
		},
		methods:{
			goBack(){
				if(this.autoBack){
					uni.navigateBack()
				}
				this.$emit('leftClick')
			},
			clickRight(){
				this.$emit('rightClick')
			}
		}
	}
</script>

<style lang="scss" scoped>
	.navbar{
		height:88rpx;
		width:100%;
		.navbar-placeholder{
			height:88rpx;
			width:100%;
		}
		.sta-bar{
			position: fixed;
			top:0;
			left:0;
			width: 100vw;
			height:88rpx;
			z-index: 10000;
		}
		.zwy-navbar{
			position: fixed;
			top:88rpx;
			left:0;
			padding: 0 16px;
			width: 100%;
			height:88rpx;
			display: flex;
			justify-content: space-between;
			z-index: 10;
			box-sizing: border-box;
			align-items: center;
			.title{
				flex: 1;
				text-align: center;
			}
			.right{
				flex: 1;
				text-align: right;
				float: right;
			}
		}
	}
	
</style>