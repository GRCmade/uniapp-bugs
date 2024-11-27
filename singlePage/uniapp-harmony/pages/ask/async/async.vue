<template>
	<view>
		<button @click="click">click</button>
		<view style="color: #ffcc33;">1</view>
		<switch checked="true" color="#ffcc33" />
	</view>
</template>

<script setup>
	const fetdata = ()=>{
		return new Promise((resolve,reject)=>{
			setTimeout(()=>{
				resolve("back")
			},1000)
		})
	}
	
	const click = async()=>{
		const res = await fetdata()
		console.log(res);
		
	}
</script>

<style>

</style>
