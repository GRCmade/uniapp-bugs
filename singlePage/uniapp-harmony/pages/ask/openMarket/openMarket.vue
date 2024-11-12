<template>
	<view class="content">
		<button class="button" @click="openAppProductBtn">打开应用市场</button>
	</view>
</template>

<script lang="uts">
	import { openAppProduct } from "@/uni_modules/uni-openAppProduct"
	export default {
		data() {
			return {

			}
		},
		onLoad() {

		},
		methods: {
			openAppProductBtn() {
				openAppProduct({
					success: (res : any) => {
						console.log('success: ', JSON.stringify(res));
					},
					fail: (err : any) => {
						console.error('fail: ', JSON.stringify(err));
					},
					complete: (res : any) => {
						console.log('complete: ', JSON.stringify(res));
					}
				});
			}
		}
	}
</script>

<style>
	.content {
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}
	.button{
		width: 100%;
		margin: 10px;
	}
</style>
