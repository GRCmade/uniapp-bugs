<script>
export default {
  onLaunch: function () {
    console.log('App Launch')
  },
	onThemeChange(res) {
		console.log("appvue,onThemeChange",JSON.stringify(res))
	},
  onShow: function () {
    console.log('App Show')
  },
  onHide: function () {
    console.log('App Hide')
  }
}
</script>

<style>
/*每个页面公共css */
</style>
