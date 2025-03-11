<template>  
  <view class="content">  
    <com :list="[1, 2, 4]">  
      <template v-slot:default="{ item }">{{ item }}</template>  
    </com>  
  </view>  
</template>

<script>
	export default {
		data() {
			return {}
		},
		methods: {
			click() {
				
			}
		}
	}
</script>


<style></style>