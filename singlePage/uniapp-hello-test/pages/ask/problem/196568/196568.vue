<template>
	<view>
		<components a="66"></components>
	</view>
</template>

<script>
	import componentVue from './component.vue'
	export default {
		components:{
			"components":componentVue
		},
		data() {
			return {
				
			}
		},
		onLoad() {
			console.log("196568",getCurrentPages())
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
