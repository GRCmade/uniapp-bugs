<script>
	export default {
		onLaunch: function() {
			console.log('App Launch')
			uni.onPushMessage((res)=>{
				console.log(res)
			})
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
		}
	}
</script>

<style lang="scss">
	/* #ifndef APP-NVUE */
	@import '@/static/customicons.css';
	
	page {
		background-color: #f5f5f5;
	}

	/* #endif */
	.example-info {
		font-size: 14px;
		color: #333;
		padding: 10px;
	}
</style>