<template>
	<view class="page-responsive-left">
		<view class="menu">
			菜单项
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {}
		},
		mounted() {
			const me = this
		},
		methods: {}
	}
</script>

<style lang="scss">
	.page-responsive-left {
		-webkit-user-select: none;
		-moz-user-select: none;
		-ms-user-select: none;
		user-select: none;
	}

	.icon {
		margin-right: 4px;
	}

	.menu {
		padding: 20px;
	}

	.menu view {
		padding: 6px;
		margin-top: 1px;
		margin-bottom: 1px;
		text-decoration: none;
		border-radius: 6px;
		cursor: pointer;
		transition: all 0.3s;
		-webkit-transition: all 0.3s;
	}

	.menu view:hover {
		padding: 6px;
		margin-top: 1px;
		margin-bottom: 1px;
		color: $uni-color-primary;
		background-color: #fff;
		text-decoration: none;
		border-radius: 6px;
		cursor: pointer;
		transition: all 0.3s;
		-webkit-transition: all 0.3s;
	}

	.menu view:active {
		padding: 6px;
		margin-top: 1px;
		margin-bottom: 1px;
		color: $uni-color-primary;
		background-color: #fff;
		text-decoration: none;
		border-radius: 6px;
		cursor: pointer;
		transition: all 0.3s;
		-webkit-transition: all 0.3s;
	}

	.link-selected {
		padding: 6px;
		margin-top: 1px;
		margin-bottom: 1px;
		color: $uni-color-primary;
		background-color: #fff;
		text-decoration: none;
		border-radius: 6px;
		transition: all 0.3s;
		-webkit-transition: all 0.3s;
	}
</style>