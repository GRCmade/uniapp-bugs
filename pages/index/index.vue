<template>
	<view>
		<button @click="click">click</button>
		<picker mode="date" fields="year">
			<view class="uni-input">fields="year"</view>
		</picker>
		<picker mode="date" fields="month">
			<view class="uni-input">fields="month"</view>
		</picker>
		<picker mode="date" fields="day">
			<view class="uni-input">fields="day"</view>
		</picker>
		<picker mode="date" fields="day" :value="date">
			<view class="uni-input">fields="day" && value2 = {{date}}</view>
		</picker>
		<picker mode="date" fields="day" :value="123">
			<view class="uni-input">fields="day" && value2 = 123</view>
		</picker>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				date: "2024-02-10",
			}
		}
	}
</script>