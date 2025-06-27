<template>
	<view>
		<uni-card is-full>
			<text class="uni-h6"> 通过数据驱动的单选框和复选框，可直接通过连接 uniCloud 获取数据，同时可以配合表单组件 uni-forms 使用 </text>
		</uni-card>
		<uni-section title="本地数据" type="line">
			<uni-data-select v-model="value" :localdata="range" @change="change"></uni-data-select>
		</uni-section>
		<uni-section title="是否可清除已选项" type="line">
			<uni-data-select v-model="value" :localdata="range" @change="change" :clear="false"></uni-data-select>
		</uni-section>
		<uni-section title="配置左侧标题" type="line">
			<uni-data-select v-model="value" :localdata="range" @change="change" placement="top" label="应用选择"></uni-data-select>
		</uni-section>
		<button @click="click">click</button>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				value: 0,
				range: [{ value: 0, text: '篮球' }, { value: 1, text: '足球' }, {
					value: 2,
					text: '2541200000010427607625412000000104276076'
				}]
			}
		},
		methods: {
			change(e) {
				console.log('e:', e)
				if (e == 1) {
					this.value = 2
				}
			},
			click(){
				uni.switchTab({
					url:"/pages/tabbar/tabbar-1/tabbar-1"
				})
			}
		}
	}
</script>
<style lang="scss">
	.text {
		font-size: 12px;
		color: #666;
		margin-top: 5px;
	}

	.uni-px-5 {
		padding-left: 10px;
		padding-right: 10px;
	}

	.uni-pb-5 {
		padding-bottom: 10px;
	}
</style>