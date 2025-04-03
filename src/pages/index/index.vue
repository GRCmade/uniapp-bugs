<template>
	<view>
		<view @click="jump">界面1</view>
	</view>
</template>

<script>
	
	export default {
		methods: {
			jump(){
				uni.navigateTo({
					url:'/pages/index/test1'
				})
			}
		},
	};
</script>