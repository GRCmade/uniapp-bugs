<template>  
    <view class="container">
		<swiper circular class="swiper" :current="activeIndex" :indicatorDots="true" @change="swiperChange">
			<swiper-item v-for="item in list" :key="item.id" class="swiper_item" :style="{ backgroundColor: item.color }">  
				{{ item.name }}  
			</swiper-item>  
		</swiper>
        <button class="btn" @click="del">删除当前swiper-item</button>  
        <button class="btn" @click="click">获取current</button>  
    </view>  
</template>  

<script setup>  
import { ref,nextTick } from 'vue'  
const activeIndex = ref(0)  
const list = ref([  
    { name: '红色', color: 'red', id: 11 },  
    { name: '绿色', color: 'green', id: 22 },  
    { name: '蓝色', color: 'blue', id: 33 },  
    { name: '粉色', color: 'pink', id: 44 },  
    { name: '黄色', color: 'yellow', id: 55 }  
])  
const swiperChange = e => {
	console.log(e)
    activeIndex.value = e.detail.current  
}
const del = () => {
    list.value.splice(activeIndex.value, 1)
	if(activeIndex.value == list.value.length){
		activeIndex.value = 0
	}
}
const click = ()=>{
	console.log(activeIndex.value)
}
</script>  

<style lang="scss" scoped>  
.swiper_item {  
    display: flex;  
    justify-content: center;  
    align-items: center;  
    font-size: 58rpx;  
    color: #fff;  
}  
.btn {  
    margin: 50rpx 100rpx;  
}  
</style>  