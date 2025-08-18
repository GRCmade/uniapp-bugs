<script>
	export default {
		onLaunch: function () {
			console.log('App Launch')
		},
		onShow: function () {
			console.log('App Show')
		},
		onHide: function () {
			console.log('App Hide')
		},
	}
</script>

<style>
	/*每个页面公共css */
	.uni-title {
		font-size: 30rpx;
		font-weight: 500;
		padding: 20rpx 0;
		line-height: 1.5;
	}

	.uni-text {
		font-size: 28rpx;
	}

	.uni-title text {
		font-size: 24rpx;
		color: #888;
	}

	.uni-list {
		background-color: #ffffff;
		position: relative;
		width: 100%;
		display: flex;
		flex-direction: column;
	}

	@media (prefers-color-scheme: dark) {
		.uni-list {
			background-color: rgb(31, 31, 31);
		}
	}

	.uni-list:after {
		position: absolute;
		z-index: 10;
		right: 0;
		bottom: 0;
		left: 0;
		height: 1px;
		content: '';
		-webkit-transform: scaleY(0.5);
		transform: scaleY(0.5);
		background-color: #c8c7cc;
	}

	.uni-list-cell {
		position: relative;
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		align-items: center;
	}

	.uni-list-cell-hover {
		background-color: #eee;
	}

	.uni-list-cell-pd {
		padding: 22rpx 30rpx;
	}

	.uni-list-cell-left {
		white-space: nowrap;
		font-size: 28rpx;
		padding: 0 30rpx;
	}
</style>
