<template>
	<view>
		<uni-data-checkbox mode="button" icon="left" v-model="value" :localdata="range" @change="change"></uni-data-checkbox>
		<!-- <uni-data-checkbox mode="list" icon="right" v-model="value" :localdata="range" @change="change"></uni-data-checkbox> -->
	</view>
</template>

<script>
	export default {
		data() { 
			return {
				value: 0,
				range: [{"value": 0,"text": "篮球"	},{"value": 1,"text": "足球"},{"value": 2,"text": "游泳"}]
			}
		},
		methods: {
			change(e){
				console.log('e:',e);
			}
		}
	}
</script>
