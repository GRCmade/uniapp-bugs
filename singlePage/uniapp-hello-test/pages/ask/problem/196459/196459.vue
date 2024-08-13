<template>
	<view>
		<uni-forms ref="form" :modelValue="formData">
			<uni-forms-item label="email" name="email">
				<uni-easyinput v-model="formData.email" placeholder="" />
			</uni-forms-item>
			<uni-forms-item label="phone" name="phone">
				<uni-easyinput v-model="formData.phone" placeholder="" />
			</uni-forms-item>
		</uni-forms>
		<button class="button" @click="submit">校验表单</button>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				formData: {
					email: '',
					phone: ''
				},
				rules: {
					email: {
						rules: [
							{
								required:true,
								errorMessage:'email and phone need input at least one'
							},{
							validateFunction: function(rule, value, data, callback) {
								console.log(rule, value, data, callback)
								if (data.email != '' || data.phone != '') {
									return true
								} else {
									callback('input at least one')
								}
							}
						}]
					},
					phone: {
						rules: [{
								required:true,
								errorMessage:'email and phone need input at least one'
							},{
							validateFunction: function(rule, value, data, callback) {
								console.log(rule, value, data, callback)
								if (data.email != '' || data.phone != '') {
									return true
								} else {
									callback('input at least one')
								}
							}
						}]
					}
				}
			}
		},
		onReady() {
			// 需要在onReady中设置规则
			this.$refs.form.setRules(this.rules)
		},
		methods: {
			submit(form) {
				if(this.formData.email != ''){
					this.rules.phone.rules[0].required = false
				}
				this.$refs.form.validate().then(res => {
					console.log('表单数据信息：', res);
				}).catch(err => {
					console.log('表单错误信息：', err);
				})
			}
		}
	}
</script>