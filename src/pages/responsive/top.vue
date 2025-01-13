<template>
	<view class="page-responsive-top">
		<view>
			<!--宽屏菜单-->
			<match-media :min-width="1025">
				<view>
					宽屏菜单
				</view>
			</match-media>
			<!--窄屏菜单-->
			<match-media :min-width="0" :max-width="1024">
				<view>窄屏菜单</view>
			</match-media>
		</view>
	</view>
</template>

<script>
	/**
	 * 顶部内容
	 */
	export default {
		data() {
			return {}
		},
		mounted() {},
		methods: {}
	}
</script>

<style lang="scss">
	.page-responsive-top {
		height: 50px;
		overflow: hidden;
		-webkit-user-select: none;
		-moz-user-select: none;
		-ms-user-select: none;
		user-select: none;
	}

	.system {
		width: 160px;
		text-align: center;
		line-height: 50px;
	}

	.system-min {
		line-height: 50px;
		/* padding-left: 20px; */
		text-align: center;
	}

	.sysName {
		font-size: 18px;
	}

	.ver {
		padding-left: 5px;
		font-size: 12px;
		color: #666666;
		font-weight: normal;
	}

	.menuMin {
		flex: 1;
		line-height: 50px;
		padding: 0px 20px;
	}
</style>