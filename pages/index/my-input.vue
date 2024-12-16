<template>
	<view class="">
		<view class="box" @click="click">
			<input type="text" v-model="keyword" class="input"  v-if="show" :focus="showSync"/>
		</view>
	</view>
</template>

<script>
	export default{
		data(){
			return{
				keyword:"",
				show:false,
				showSync:false
			}
		},
		methods:{
			click(){
				this.show = true
				this.$nextTick(()=>{
					this.showSync = true
				})
			}
		}
	}
</script>

<style>
	.box{
		height: 50px;
		background-color: red;
	}
</style>