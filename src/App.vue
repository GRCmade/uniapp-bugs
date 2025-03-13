<script>
	export default {
		onLaunch: function() {
			console.log('App Launch')
      uni.addInterceptor('chooseImage', {
        invoke(args) {
          console.log('拦截器-addInterceptor-chooseImage', args)
        }
      })
      uni.addInterceptor('switchTab', {
        invoke(args) {
          console.log('拦截器-addInterceptor-switchTab', args)
        }
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

<style>
	/*每个页面公共css */
</style>
