import Vue from 'vue'
export default{
	authLogin() {
		if (this.$store.state.vuex_token) {
			return
		}
		var code = ''
		uni.login({
			provider:"weixin",
			success: (res) => {
				console.log(res)
				code = res.code //微信临时登录凭证
			}
		})
		uni.getUserProfile({
			desc:'获取你的昵称、头像',
			success: info => {
				console.log(info)
				this.$u.vuex('vuex_token', code)
			}
		})
	}
}