<template>
	<view>
		<uni-number-box @change="change" @blur="blur" :min="1" :max="999" background="transparent" v-model="goodsCount" />
	</view>
</template>

<script>
	export default {
		data() {
			return {
				goodsCount:0
			}
		},
		methods: {
			change(e){
				console.log("change",e)
			},
			blur(e){
				console.log("blur",e)
			}
		}
	}
</script>

<style>

</style>
