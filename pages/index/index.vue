<template>
	<view>
		<button @click="click">click</button>
		<picker mode="date" fields="year" >
			<view class="uni-input">{{date}}</view>
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