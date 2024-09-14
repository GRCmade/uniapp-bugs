<template>
	<view>
		<com :protocols="[{title: '步骤1'}, {title: '步骤2'}, {title: '步骤3'}]">  
		        <text slot="test-slot" :slot-scope="{protocol}">test-slot-{{ 'yuhe' }}，</text>  
		</com>
	</view>
</template>

<script>
	import com from './com.vue'
	export default {
		components:{
			"com":com
		},
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style>

</style>
