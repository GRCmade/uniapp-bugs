<template>
	<view>
		com-son
	</view>
</template>

<script>
	export default {
		name:"com-son",
		data() {
			return {
				
			};
		},
		created() {
			console.log("$parent",this.$parent.$options)
		}
	}
</script>

<style>

</style>