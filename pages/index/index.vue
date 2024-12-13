<template>
	<view>
		<button @click="click">click</button>
	</view>
</template>


<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				const data = "{\"key\":\"8aee060599e0221f32a03d99f7f31d86\",\"policyName\":\"原价\",\"showSeats\":[{\"salePrice\":300,\"snapshot\":\"十七区/3排20号\",\"fareLevel\":\"D\",\"suitCode\":null,\"id\":\"1858723193608245249\",\"price\":300,\"fareLevelVerboseName\":\"乙级票\"}],\"totalAmount\":300,\"deltaPrice\":0,\"buyProtocolOn\":false,\"buyProtocol\":\"Empty_String\",\"imageUrl\":\"https://res.dasheng.top/227/pro/ctms_tool/20241208/jpg/cebd003085e94068bfad67db82ba752a.jpg\",\"name\":\"【南京】2024-2025赛季CBA联赛常规赛南京赛区赛事\",\"venueAddress\":\"江苏省南京市鼓楼区华侨路街道双沟珍宝坊体育馆\",\"realNameType\":\"3\",\"id\":\"1838480455383248898\",\"performanceSource\":null,\"showTime\":\"2024-12-18 19:35:00\",\"showName\":\"2024-12-18 19:35 南京头排苏酒 VS 广东东阳光\",\"showId\":\"1858723021008441345\",\"douyinProductId\":\"7421175268624140326\",\"ticketOutletId\":\"\",\"plugInType\":1}";
				console.log("data",data)
				let options = {}
				options = JSON.parse(data)
				// try {
				// 	options = JSON.parse(data)
				// } catch (error) {
				// 	//TODO handle the exception
				// }
				console.log(options)
			}
		}
	}
</script>


<style></style>