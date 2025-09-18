<script>
	export default {
		onLaunch: function() {
			console.log('App Launch')
			uni.onHostEventReceive((event, data) => {
				console.log('Receive event(' + event + ') from HOST: ' + JSON.stringify(data));
			});
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
		}
	}
</script>
<style>
	/*每个页面公共css */
</style>