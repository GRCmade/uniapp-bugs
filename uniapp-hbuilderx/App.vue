<script>
	export default {
		onLaunch: function() {
			console.log('App Launch')
			this.interceptSwitchTab()
		},
		onShow: function() {
			console.log('App Show')
		},
		onHide: function() {
			console.log('App Hide')
		},
		methods: {
			interceptSwitchTab() {
				const tabPages = ['/pages/message/index'];
				uni.addInterceptor('switchTab', {
					invoke: (args) => {
						if (tabPages.includes(args.url)) {
							uni.navigateTo({
								url: '/pages/login/login'
							})
							return false
						}
						return true
					}
				});
			}
		}
	}
</script>

<style>
	/*每个页面公共css */
</style>
