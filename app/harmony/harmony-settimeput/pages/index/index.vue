<template>  
    <view style="text-align: center;" v-for="(value, key) in listData" :key="key">  
        <text>{{ value }}</text>  
    </view>  
</template>  

<script lang="ts">  
export default {  
    data() {  
        return {  
            listData: ['a', 'b', 'z']  
        };  
    },  
    onLoad() {  
        this.listData = ['a', 'b', 'z'];  
        this.listData.push('d'); 
        setTimeout(() => {  
            this.listData.push('e');  
            // this.listData.push(...['d', 'e', 'f']);  
        }, 2000);  
    } 
};  

// vue3响应式写法不支持呢  
// import { ref, onMounted } from 'vue';  

// const listData = ref();  

// onMounted(() => {  
//  listData.value = ['a', 'b', 'c'];  

//  setTimeout(() => {  
//      listData.value.push(...['d', 'e', 'f']);  
//  }, 2000);  
// });  
</script>  

<style></style>  