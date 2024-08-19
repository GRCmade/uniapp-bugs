<template>
	<view>
		<input type="number" placeholder="请输入--." v-model="input" @input="inputInput" @confirm="inputConfirm"/>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				input:''
			}
		},
		methods: {
			inputInput(e){
				console.log(e)
			},
			inputConfirm(e){
				console.log("confirm",e)
			}
		}
	}
</script>

<style>

</style>
