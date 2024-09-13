
<template>  
    <view>Child</view>  
    <view>{{name}}</view>  
</template>  
<script setup>  
    import {defineProps} from "vue"  
    const props = defineProps({  
        name: String,  
    });  
    console.log("name=" + props.name); // id=10  
</script>  

<style>  
</style>  