<template>
	<view class="my">
		<!-- 自定义底部切换 -->
        <TabBar></TabBar>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				showModal: false
			}
		},
		onLoad() {
			
		},
		methods: {
			
		}
	}
</script>

<style scoped lang="scss">
	::v-deep {
		.u-cell__body {
			height: 110rpx;
		}
	}
    .my {
        min-height: 100vh;
        background-color: #F3F3F3;
    }
	.information {
		width: 100%;
		height: 270rpx;
		background: url('#{$http_url}rual-governance/static/me/my-banner.png');
        background-size: 100% auto;
        background-repeat: no-repeat;
		padding: 28rpx;
        .operate {
            justify-content: flex-end;
            height: 40rpx;
        }
		.user {
			.photo {
				width: 128rpx;
				height: 128rpx;
				border-radius: 50%;
				overflow: hidden;
				margin-right: 32rpx;

				image {
					width: 100%;
					height: 100%;
				}
			}

			.islogin {
                .userName {
                    font-size: 40rpx;
					color: #FFFFFF;
                }
				.phone {
					font-size: 32rpx;
					color: #FFFFFF;
				}
			}
            .authentication {
                margin-left: auto;
                margin-top: 100rpx;
            }
		}
	}
    .cell-box {
        width: 700rpx;
        margin: 0 auto;
        background-color: #FFFFFF;
        position: relative;
        top: -40rpx;
        border-radius: 16rpx;
    }
    .user-tag {
        width: 96rpx;
        height: 40rpx;
        border-radius: 8rpx;
        border: 1rpx solid #FFFFFF;
        background-color: transparent;
        font-size: 24rpx;
        font-weight: 400;
        color: #FFFFFF;
        text-align: center;
        margin-top: 10rpx;
    }
    .changeSf {
        margin-top: 100rpx;
        margin-left: auto;
    }
	.take-out {
		width: 500rpx;
		position: fixed;
		bottom: 200rpx;
		left: 50%;
		transform: translateX(-50%);
	}
</style>
