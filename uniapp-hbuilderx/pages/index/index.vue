<template>
	<view>
		<uni-data-picker placeholder="请选择地址" popup-title="请选择城市" collection="opendb-city-china"
			field="code as value, name as text" orderby="value asc" :step-searh="true" self-field="code"
			parent-field="parent_code" @change="onchange" @nodeclick="onnodeclick">
		</uni-data-picker>
	</view>
</template>
<script>
	export default {
		data() {
			return {}
		},
		methods: {
			onchange(e) {
				const value = e.detail.value
			},
			onnodeclick(node) {}
		}
	}
</script>