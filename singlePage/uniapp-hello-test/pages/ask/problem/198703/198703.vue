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
				uni.getPushClientId({
					success: (res) => {
						console.log(res.cid);
					},
					fail(err) {
						console.log(err)
					}
				})

		},
		methods: {
			
		}
	}
</script>

<style>

</style>
