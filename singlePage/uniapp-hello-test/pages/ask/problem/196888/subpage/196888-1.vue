<template>
	<view>
		<button @click="nav">nav-2</button>
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
			const delta = pages.reverse().findIndex(item => item.route === 'pages/ask/index')  
			console.log(pages, 'pages-----------',delta)  
			if (delta > 0) {  
			    uni.navigateBack({  
			        delta: delta  
			    })  
			    return  
			} 
		},
		methods: {
			nav(){
				uni.navigateTo({
					url:"/pages/ask/problem/196888/subpage/196888-2"
				})
			}
		}
	}
</script>

<style>

</style>
