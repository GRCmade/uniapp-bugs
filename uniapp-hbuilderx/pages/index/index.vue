<template>
	<view>
			<view class="stickey">
				121233
			</view>
		<view v-for="(item,index) in 100" :key="index">

			<view >
				{{item}}
			</view>
		</view>
	</view>
</template>

<script>
export default {
	data() {
		return {
			message: 'Hello, World!',
			data:[]
		}
	},
	onLoad() {
		// this.data =
	},
	methods: {
		handleClick() {
			console.log('Button clicked')
		}
	}
}
</script>

<style scoped>
	view {
		min-height: 50px;
		padding: 10px;
	}
	.stickey{
		position: sticky !important;
		top: 0 !important;
		z-index: 10;
		background-color: white;
		width: 100%;
	}
</style>
