<template>
	<view>
		<uni-easyinput @change="change" v-model="input1" placeholder="1" />
		<uni-easyinput @change="change" type="password"  v-model="input2" placeholder="2" />
	</view>
</template>

<script>
	export default {
		data() {
			return {
				input1:'',
				input2:''
			}
		},
		methods: {
			change(e){
				console.log(e)
			}
		}
	}
</script>

<style>

</style>
