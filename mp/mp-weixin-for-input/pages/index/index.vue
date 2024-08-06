<template>
	<view class="view">
		<view class="view">
			<view v-for="(item,index) in data" :key="index">
				<input type="text" v-model="item.num" @input="input" @blur="blur"/>
			</view>
			<button @click="click">clogData</button>
			<input type="text" v-model="num" @input="input" @blur="blur"/>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				num:3,
				data:[
					{
						num:2
					},{
						num:1
					}
				]
			}
		},
		onShow() {
			console.log("onShow-2",getCurrentPages())
			// uni.setTabBarItem({
			//  index: 0,  
			//  text: 'yuhe'  
			// })  
		},
		methods: {
			click(){
				console.log(this.data)
			},
			input(r){
				console.log(r)
			},
			blur(){
				
			}
		}
	}
</script>

<style>
	.view{
		margin-top: 150rpx;
	}
</style>
