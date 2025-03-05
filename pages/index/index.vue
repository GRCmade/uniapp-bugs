<template>
	<view>
		<uni-data-picker v-model="temperature" placeholder="请选择最高气温"
			:localdata="temperaturePicker"></uni-data-picker>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				temperature: 25,
				temperaturePicker: [],
				show: false
			}
		},
		onLoad() {
			for (var i = 50; i > -41; i--) {
				this.temperaturePicker.push({
					text: `${i}℃`,
					value: i
				});
			}
		}
	}
</script>