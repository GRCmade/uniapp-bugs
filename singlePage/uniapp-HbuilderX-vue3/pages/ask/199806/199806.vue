<template>
	<view>
		{{cdata}}
	</view>
</template>

<script>
	export default {
		data() {
			return {
				len: 3
			}
		},
		computed: {
			cdata() {
				const d = {}
				for (var i = 0; i < this.len; i++) {
					d[`a.${i}.b`] = 0
				}
				console.log(d);
				return d
			}
		},
		created() {
			// setInterval(() => {
			// 	this.len++
			// }, 1000)
		}
	}
</script>

<style>

</style>