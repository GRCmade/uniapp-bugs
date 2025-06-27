<script>
	export default {
		onLaunch: function() {
			console.log('App Launch')
			uni.addInterceptor("switchTab", {
				invoke() {
					console.log("invoke")
				},
				success(args) {
					// 请求成功后，修改code值为1
					console.log("interceptor-success", args)
				},
				fail(err) {
					console.log('interceptor-fail', err)
				},
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