<template>  
  <view>  
    <view v-for="(item, index) in list" :key="index">  
      <slot :item="item"></slot>  
    </view>  
  </view>  
</template>

<script>
	export default {
		name:"com",
		props:['list'],
		data() {
			return {
				
			};
		}
	}
</script>

<style>

</style>