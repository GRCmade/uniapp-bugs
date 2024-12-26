<template>
	<view>
		<button @click="setStorage">setStorage</button>
		<button @click="getStorageSync">getStorageSync</button>
		<button @click="getStorage">getStorage</button>
	</view>
</template>



<script>
	export default {
		data() {
			return {

			}
		},
		onLoad() {

		},
		methods: {
			setStorage(){
				let obj = { name:"yuhe" }
				uni.setStorageSync("itemabc", obj);
			},
			getStorage(){
				uni.getStorage({
					key:"itemabc",
					success(res) {
						let item = res.data
						console.log('item对象', JSON.stringify(item))
						res.data.pinyin = "12";
						console.log('赋值后', item.pinyin)
						console.log('赋值后', item)
						console.log('赋值后', res)
					}
				})
			},
			getStorageSync() {
				let obj = { name:"yuhe" }
				// uni.setStorageSync("itemabc", obj);
				let item = uni.getStorageSync("itemabc");
				console.log('item对象', JSON.stringify(item))
				item.pinyin = "12";
				item.name = 'yuhe1'
				console.log('赋值后', item.pinyin)
				console.log('赋值后', item)
				obj.pinyin ="13"
				console.log('obj', obj.pinyin)
				console.log('obj', obj)
			}
		}
	}
</script>




<style></style>