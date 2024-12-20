<template>
	<view>
		<uni-popup ref="popup" type="top">
			<view class="box" @touchmove.stop.prevent>
				<scroll-view scroll-y="true" class="scroll" :scroll-top="0">
					<view v-for="(item,index) in 100" :key="index">
						{{item}}
					</view>
				</scroll-view>
			</view>
		</uni-popup>
		<button @click="click">click</button>
		<view class="view2" v-for="(item,index) in 100" :key="index">
			{{item}}
		</view>
	</view>
</template>


<script>
	export default {
		data() {
			return {}
		},
		onLoad() {},
		methods: {
			click() {
				this.$refs.popup.open()
			}
		}
	}
</script>


<style>
	.scroll {
		height: 400px;
		width: 100%;
	}

	.scroll view {
		background-color: red;
		margin: 10px;
	}
	
	.view2 {
		background-color: blue;
		margin: 10px;
	}
</style>