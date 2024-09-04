<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		onLoad() {
			
		},
		methods: {
			click(){
				let api = 'chooseMedia';
				// #ifndef H5  
				    api = 'chooseMedia';  
				// #endif  
				// #ifdef H5  
				    api = 'chooseImage';  
				// #endif  
				uni[api]({  
				    count: 1,  
				    mediaType: ['image']  
				})
			}
		}
	}
</script>

<style>

</style>
