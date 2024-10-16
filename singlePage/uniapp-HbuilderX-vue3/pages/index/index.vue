<template>
	<view class="">
		<uni-nav-bar title="导航栏组件" statusBar backgroundColor="#007aff"></uni-nav-bar>
		<uni-fab></uni-fab>
		<button @click="click">click</button>
		<uni-popup ref="popup">
			popup
		</uni-popup>
		<uni-table border stripe emptyText="暂无更多数据">
			<!-- 表头行 -->
			<uni-tr>
				<uni-th align="center">日期</uni-th>
				<uni-th align="center">姓名</uni-th>
				<uni-th align="left">地址</uni-th>
			</uni-tr>
			<!-- 表格数据行 -->
			<uni-tr>
				<uni-td>2020-10-20</uni-td>
				<uni-td>Jeson</uni-td>
				<uni-td>北京市海淀区</uni-td>
			</uni-tr>
			<uni-tr>
				<uni-td>2020-10-21</uni-td>
				<uni-td>HanMeiMei</uni-td>
				<uni-td>北京市海淀区</uni-td>
			</uni-tr>
			<uni-tr>
				<uni-td>2020-10-22</uni-td>
				<uni-td>LiLei</uni-td>
				<uni-td>北京市海淀区</uni-td>
			</uni-tr>
			<uni-tr>
				<uni-td>2020-10-23</uni-td>
				<uni-td>Danner</uni-td>
				<uni-td>北京市海淀区</uni-td>
			</uni-tr>

		</uni-table>


		<uni-datetime-picker type="datetime" :value="datetimesingle1" v-model="datetimesingle1"></uni-datetime-picker>
		<uni-load-more></uni-load-more>
		<uni-data-picker :localdata="items" popup-title="请选择班级" @change="onchange"
			@nodeclick="onnodeclick"></uni-data-picker>

	</view>
</template>

<script>
	export default {
		data() {
			return {
				title: 'Hello',
				datetimesingle1: '',
				items: [{
				    text: "摄录设备",
				    value: "1",
				    children: [{
				        text: "摄录一体机",
				        value: "2",
				        children: [
				            { text: "1", value: "数量" },
				            { text: "2", value: "数量" },
				            { text: "3", value: "数量" }
				        ]
				    }, {
				        text: "260电池",
				        value: "02365",
				        children: [
				            { text: "0", value: "数量" },
				            { text: "1", value: "数量" },
				            { text: "2", value: "数量" },
				            { text: "3", value: "数量" },
				            { text: "4", value: "数量" },
				            { text: "5", value: "数量" }
				        ]
				    }]
				}]
			}
		},
		onLoad() {
			this.Fun_date()
			console.log(uni.getWindowInfo().statusBarHeight)
		},
		methods: {
			click() {
				this.$refs.popup.open()
			},
			Fun_date() {
				let date = new Date();
				let year = date.getFullYear(); //当前年份
				let month = date.getMonth(); //当前月份
				let data = date.getDate(); //天
				let hours = date.getHours(); //小时
				let minute = date.getMinutes(); //分
				let second = date.getSeconds(); //秒
				let time = this.Fun_fnW(year) + "-" + this.Fun_fnW((month + 1)) + "-" + data + " " + this.Fun_fnW(hours) +
					":" + this.Fun_fnW(minute) + ":" + this.Fun_fnW(second);
				let time1 = this.Fun_fnW(year) + "年" + this.Fun_fnW((month + 1)) + "月" + data + "日";
				this.datetimesingle = time1;
				this.datetimesingle1 = time;
				console.log(this.datetimesingle);
				console.log(this.datetimesingle1);
			},
			//当某个字段不是两位数时补0
			Fun_fnW(str) {
				let num = '';
				str >= 10 ? num = str : num = "0" + str;
				return num;
			},

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

	.logo {
		height: 200rpx;
		width: 200rpx;
		margin-top: 200rpx;
		margin-left: auto;
		margin-right: auto;
		margin-bottom: 50rpx;
	}

	.text-area {
		display: flex;
		justify-content: center;
	}

	.title {
		font-size: 36rpx;
		color: #8f8f94;
	}
</style>