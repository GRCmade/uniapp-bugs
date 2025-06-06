<template>
	<embed class="native-button" tag="button" :options="options" @buttonclick="onClick"></embed>
</template>
<script>
	import { harmonyButton } from '@/uni_modules/harmony-button'
	export default {
		data() {
			return {
				options: {
					label: 'hello'
				}
			}
		},
		methods: {
			onClick(e) {
				console.log('onClick', e.detail)
				this.options = {
					label: 'world'
				}
			}
		}
	}
</script>
<style scoped>
	.native-button {
		display: block;
		width: 200px;
		height: 50px;
		margin: 10px auto;
	}
</style>