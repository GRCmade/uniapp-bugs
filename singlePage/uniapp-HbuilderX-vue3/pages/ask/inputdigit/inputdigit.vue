<template>
	<view>
		<input type="text" @input="input" />
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			input(e){
				console.log(e);
			}
		}
	}
</script>

<style>

</style>
