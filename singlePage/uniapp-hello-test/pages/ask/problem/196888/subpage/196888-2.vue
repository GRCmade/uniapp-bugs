<template>
	<view>
		
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		onLoad() {
			const pages = getCurrentPages()  
			const delta = pages.reverse().findIndex(item => item.route === 'pages/ask/problem/196888/196888')  
			console.log(pages, 'pages-----------',delta)  
			if (delta > 0) {  
			    uni.navigateBack({  
			        delta: delta  
			    })  
			    return  
			} 
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
