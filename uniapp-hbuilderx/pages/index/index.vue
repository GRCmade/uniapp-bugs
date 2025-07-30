<template>
	<view>
		<uni-section title="多选使用插槽" subTitle="多选的时候,超过2个显示省略;" type="line">
			<view class="uni-px-5 uni-pb-5">
				<uni-data-select ref="uniDataSelect" v-model="multipleValue" multiple mode="underline" placement="bottom"
					:localdata="range">
					<template v-slot:selected="{selectedItems}">
						<view class="slot-box">
							<view v-for="item in sliceArray(selectedItems)" :key="item.value" class="slot-content-item">
								{{item.text}}
							</view>
							<view v-if="selectedItems.length > 2" class="slot-content-item"> +{{selectedItems.length - 2}} more
							</view>
							<view v-if="selectedItems.length == 0" class="slot-content-item"> 没有选择项 </view>
						</view>
					</template>
					<template v-slot:option="{item,itemSelected}">
						<view>
							<uni-list-item showSwitch :switchChecked="itemSelected" :title="item.text" :note="item.value+''"
								:disabled="item.disable"></uni-list-item>
						</view>
					</template>
					<!-- 可以拦截点击事件之后自定义
					<template v-slot:option="{item,itemSelected}">
						<view @click.stop>
							<uni-list-item showSwitch :switchChecked="itemSelected" :title="item.text" :note="item.value+''"
								:disabled="item.disable" @switchChange="switchChange($event,item)"></uni-list-item>
						</view>
					</template> -->
					<template v-slot:empty>
						<view class="empty-box">
							<uni-icons type="spinner-cycle" size="30"></uni-icons>
							<view>empty</view>
						</view>
					</template>
				</uni-data-select>
			</view>
		</uni-section>
		<uni-section title="云端数据" sub-title="" type="line">
			<uni-data-select collection="opendb-app-list" field="appid as value, name as text" label="应用选择" v-model="appid" :clear="false" />
		</uni-section>
		<uni-section title="form" sub-title="" type="line">
			
		</uni-section>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				multipleValue: [1, 2, 3],
				range: [{
					"value": 0,
					"text": "篮球运动",
					"disable": true
				}, {
					"value": 1,
					"text": "足球运动",
				}, {
					"value": 2,
					"text": "游泳健身运动"
				}, {
					"value": 3,
					"text": "跑步有氧运动",
				}, {
					"value": 4,
					"text": "网球运动"
				}, {
					"value": 5,
					"text": "羽毛球运动"
				}, {
					"value": 6,
					"text": "乒乓球运动"
				}, {
					"value": 7,
					"text": "保龄球运动"
				}]
			}
		},
		methods: {
			change(e) {
				console.log('单选值:', e);
				console.log("range", this.range)
				console.log("value", this.value)
			},
			switchChange(e, item) {
				console.log("switch change", e, item)
				// 传入由 slot 获取的 item 即可
				this.$refs.uniDataSelect.change(item)
			},
			// 支付宝小程序上需要这样
			sliceArray(ls) {
				if (Array.isArray(ls)) {
					return ls.slice(0, 2)
				}
				return ls
			}
		}
	}
</script>
<style lang="scss">
	.slot-content-item {
		background-color: #909399;
		padding: 2px 5px;
		border-radius: 5px;
		color: #fff;
	}

	.slot-box {
		gap: 5px;
		display: flex;
		flex-wrap: wrap;
	}

	.empty-box {
		width: 100%;
		height: 100px;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}

	.select-box {
		width: 100%;
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items: center;
	}

	.empty-box {
		width: 100%;
		height: 100px;
		display: flex;
		flex-direction: column;
		align-items: center;
		justify-content: center;
	}
</style>