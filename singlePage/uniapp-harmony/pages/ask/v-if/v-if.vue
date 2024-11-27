<template>
	<view>
		<block v-for="item,index in list">
			<view v-if="index>=3">{{item}}</view>
		</block>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				list:["1","1","1","2","2","2","2","2"]
			}
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
