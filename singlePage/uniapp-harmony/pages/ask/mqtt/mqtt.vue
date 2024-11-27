<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>

<script>
	// import {mqttUtil} from "@/uni_modules/mg-mqtt"
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			click(){
				mqttUtil()
			}
		}
	}
</script>

<style>

</style>
