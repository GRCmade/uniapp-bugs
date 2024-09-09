<template>
	<view>
		<!-- <uni-number-box :min="parseFloat(currentNJ.rowSoacing)" :step="0.1" v-model="rwdata.rowSoacing" /> -->
		<uni-number-box :min="parseFloat(min)" :step="0.1" v-model="num" />
	</view>
</template>

<script>
	export default {
		data() {
			return {
				num:'',
				min:0
			}
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
