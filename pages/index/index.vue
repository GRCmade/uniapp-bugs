<template>
	<view>
		<button @click="click">click</button>
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
			click() {
				let obj = { "Sex": "1", "PosnLevel": "职员", "Email": "", "Phone": "17614632382", "Dept": "IT部", "Posname": "ERP实施工程师", "Id": "1310405787763347456", "Code": "J02012", "Name": "陈超", "User": true, "Children": [], "ProfileUrl": "" }
				uni.setStorageSync("itemabc", obj);
				let item = uni.getStorageSync("itemabc");
				console.log('item对象', JSON.stringify(item))
				item.pinyin = "测试";
				console.log('赋值后', item.pinyin)
			}
		}
	}
</script>




<style></style>