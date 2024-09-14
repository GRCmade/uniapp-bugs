<template>
	<view>
		<uni-forms ref="form" v-model="formData">
			<uni-forms-item name="status" label="用户状态">
				{{formData.status}}
				<switch @change="binddata('status', $event.detail.value)" :checked="formData.status" />
			</uni-forms-item>
			<uni-forms-item name="input" label="输入框">
				{{formData.input}}
				<input @change="binddata('input', $event.detail.value)" />
			</uni-forms-item>
		</uni-forms>
		<button @click="click">click</button>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				formData: {
					status: false,
					input: ''
				}
			}
		},
		methods: {
			click() {
				console.log(this.formData)

			},
		}
	}
</script>

<style>

</style>