<template>
	<view>
		<button
		  open-type="getAuthorize"
		  scope="userInfo"
		  :onGetAuthorize="getOpenUserInfo"
		  onError="handleAuthError"
		>
		会员基础信息授权
		</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			getOpenUserInfo(e){
				console.log(e)
			}
		}
	}
</script>

<style>

</style>
