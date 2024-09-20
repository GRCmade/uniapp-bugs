<template>
	<view>
		<uni-easyinput :focus="focus" v-model="input" placeholder="" />
		<button @click="click">click</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				input:'',
				focus:false
			}
		},
		onLoad() {
			
		},
		methods: {
			click(){
				this.focus = !this.focus
			}
		}
	}
</script>

<style>

</style>
