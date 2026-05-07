<template>
	<view>
		<scroll-view style="height: 800px; background: #f5f5f5;" scroll-y="true">
			<rich-text :nodes="title"></rich-text>
		</scroll-view>
	</view>
</template>

<script setup>
	import { ref } from 'vue';

 const title = ref(
   'image11:<p><img src=\"https://wcw-prd.oss-cn-beijing.aliyuncs.com/202512/bca004547490433782366bfc5a6f9dfd.jpg?Expires=2713224548&OSSAccessKeyId=LTAI5tGK7bKsZYTZBVpVsPxf&Signature=dqU6Ekrem3r%2Br8HqsbFVOW6BbbA%3D\"/></p> image22 <p><img class=\"media-wrap image-wrap\" src=\"https://wcw-prd.oss-cn-beijing.aliyuncs.com/202512/d0268ff459c24e5fbf27da49251eed33.png?Expires=2713224466&OSSAccessKeyId=LTAI5tGK7bKsZYTZBVpVsPxf&Signature=Rul8fXdzoYL3KOhW3dqTmkm47Rk%3D\"/></p>'

   )
</script>

<style>
</style>