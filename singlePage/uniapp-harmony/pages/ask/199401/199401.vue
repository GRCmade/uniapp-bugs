<template>
	<view>
		<uni-datetime-picker type="date" v-model="time" />
		<!-- <button @click="click">click</button> -->
		<picker mode="date" :value="date" fields="month" @change="bindChange">
			<view class="uni-calendar__header-text">
				{{date}}
			</view>
		</picker>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				time: '',
				date: ''
			}
		},
		methods: {
			click() {
				console.log(this.time)
			},
			bindChange(res){
				console.log(res)
			}
		}
	}
</script>

<style scoped>
	.uni-calendar__header-text {
		text-align: center;
		width: 100px;
		height:50rpx;
		font-size: 15px;
		color: #666;
		background-color: #333;
		color: #fff;
	}
</style>