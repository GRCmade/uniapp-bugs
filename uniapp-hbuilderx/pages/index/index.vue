<template>
	<view>
		<button @click="installMP">Click installMP </button>
		<button @click="openMP">Click openMP </button>
		<button @click="closeUniMP">Click closeUniMP </button>
		<button @click="hideUniMP">Click hideUniMP </button>
		<button @click="showUniMP">Click showUniMP </button>
		<button @click="onUniMPEventReceive">Click onUniMPEventReceive </button>
		<button @click="sendUniMPEvent">Click sendUniMPEvent </button>
	</view>
</template>
<script>
	const mp = uni.requireNativePlugin('uniMP');
	export default {
		data() {
			return {
				message: 'Hello, World!',
				appid: '__UNI__3F0B853'
			}
		},
		methods: {
			log(str, obj) {
				console.log(str, JSON.stringify(obj))
			},
			installMP() {
				//通过获取小程序版本API来判断是否已经安装
				mp.getUniMPVersion(this.appid, (ret) => {
					this.log("getUniMPVersion", ret)
					if (0 != ret.code) { //获取失败可以认为没有安装此小程序
						mp.installUniMP({
							appid: this.appid,
							wgtFile: `/static/${this.appid}.wgt`
						}, (res) => {
							this.log('installUniMP', res);
						});
					}
				});
			},
			openMP() {
				mp.openUniMP({
					appid: this.appid
				}, (ret) => {
					this.log('openUniMP', ret);
				});
			},
			closeUniMP() {
				this.log("openUniMP并且  5s 后调用 closeUniMp")
				mp.openUniMP({
					appid: this.appid
				}, (r) => {
					this.log('openUniMP', r);
					setTimeout(() => {
						mp.closeUniMP(this.appid, (res) => {
							this.log('closeUniMP', res);
						})
					}, 5000)
				});
			},
			hideUniMP() {
				this.log("openUniMP并且  5s 后调用 hideUniMP")
				mp.openUniMP({
					appid: this.appid
				}, (r) => {
					this.log('openUniMP', r);
					setTimeout(() => {
						mp.hideUniMP(this.appid, (res) => {
							this.log('hideUniMP', res);
						})
					}, 5000)
				});
			},
			showUniMP() {
				this.log("openUniMP并且  5s 后调用 showUniMP")
				mp.showUniMP(this.appid, (t) => {
					this.log("showUniMP", t);
				})
			},
			onUniMPEventReceive() {
				mp.onUniMPEventReceive(this.appid, ret => {
					console.log("来自宿主 uniapp-hbuilderx")
					console.log('Receive event from MP: ' + JSON.stringify(ret));
				});
			},
			sendUniMPEvent() {
				mp.sendUniMPEvent(this.appid, 'event', '要传递的数据', (ret) => {
					//发送消息成功回调
					console.log("来自宿主 uniapp-hbuilderx")
					console.log('Send event to MP: ' + JSON.stringify(ret));
				});
			}
		}
	}
</script>
<style scoped>
</style>