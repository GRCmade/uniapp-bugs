<script>
	export default {
		onLaunch: function() {
			console.log('App Launch')
			try{
				// require('./test.scss')
			}catch(e){
				console.log(e)
				//TODO handle the exception
			}
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
	/* @import "@/test.scss"; */
</style>
