<template>
	<view class="content">
		<button style="margin-top: 100px;" class="button"></button>
		<button class="button" @click="chooseImage">chooseImage</button>
	</view>
</template>

<script lang="uts">
	
	import { hsReadFile } from '@/uni_modules/srh-readFile';
	
	export default {
		data() {
			return {

			}
		},
		onLoad() {

		},
		methods: {
			chooseImage() {
				uni.chooseImage({
				    count: 1, 
					sizeType: ['original', 'compressed'],
				    sourceType: ['album'],
				    success: async res => {
						console.log("res" , res)
						let tempFilePath = res.tempFilePaths[0];
						
						uni.saveFile({
						    tempFilePath: tempFilePath,
						    success: (res) => {
								console.log('res.savedFilePath',res.savedFilePath)
								hsReadFile(res.savedFilePath,(res)=>{
									console.log('res.savedFilePath',res)
								});				
						    },
							fail:(e) => {
								console.log(e)
								
							}
						})
				
				    },
					
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