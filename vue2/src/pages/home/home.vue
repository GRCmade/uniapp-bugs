<template>
	<view class="container">
		<Navbar 
            title="test" 
            class="header" 
            background="linear-gradient(to right, #4888F1 , #0153D9);" 
            back 
            @onBack="goBack">
        </Navbar>
        <TabBar></TabBar>
	</view>
</template>

<script>
	import Navbar from '@/common/navbar.vue'
	export default {
		components: {
			Navbar
		},
        computed: {
            iconPathMap() {
                return [
					
                ]
            }
        },
		data() {
			return {
				
			}
		},
		onLoad(params) {
            
            
		},
		methods: {
            
		}
	}
</script>

<style lang="scss" scoped>
	/* 容器 */
	.container {
		height: 100vh;
		overflow: scroll;
		background: linear-gradient(to right, #4888F1, #0153D9);

		/* 内容区域 */
		.content {
			height: 100%;
			padding-top: 40rpx;
			text-align: center;
			background: linear-gradient(180deg, #FFFFFF 0%, #F6F6F6 100%);
			border-top-left-radius: 32rpx;
			border-top-right-radius: 32rpx;
			padding-left: 28rpx;
			padding-right: 28rpx;
			padding-bottom: 22rpx;

			/* 地理定位、街道 */
			.location {
				// margin-left: 20rpx;
				margin-top: -20rpx;

				.distrct {
					background-color: #F3F3F3;
					width: 216rpx;
					height: 64rpx;
					border-radius: 52rpx;
					display: flex;
					align-items: center;
					justify-content: center;
				}
			}

			/* banner */
			.banner {
				margin-top: 20rpx;
			}

			/* 滚动公告 */
			.notice {

				margin-top: 20rpx;
				opacity: 0.9;

				::v-deep .u-notice-bar {
					border-radius: 66rpx;
				}
			}

			/* 中部的icon入口 */
			.entrance {
				margin-top: 32rpx;
                .tab-box {
                    width: 20%;
                    flex-shrink: 0;
                }
			}

			/* 通知公告 */
			.announcement {
				margin-top: 36rpx;
				border-top-left-radius: 16rpx;
				border-top-right-radius: 16rpx;
				background-color: #ffffff;

				.list {
					margin-top: 32rpx;
					text-align: left;
                    overflow: scroll;
				}
			}
		}

		.login-tips {
			padding: 24rpx 0 24rpx 0;
		}

		::v-deep .u-cell {
			&:first-child {
				height: 96rpx !important;
			}
		}



		::v-deep .u-cell {
			&:last-child {
				.u-line {
					display: none;
				}

			}
		}

		::v-deep .u-line {
			&:first-child {
				display: none;
			}

		}

		::v-deep .u-line {
			width: auto !important;
			margin-left: 26rpx !important;
			margin-right: 26rpx !important;
		}
	}
</style>