<template>  
    <view>Child</view>  
    <view>{{ name }}</view>  
</template>  

<script>  
export default {
    props: {
        name: {
            type: String,
            required: false
        }
    },
    methods: {
        test() {
            console.log("test method called!");
        }
    },
    created() {
        console.log("name=" + this.name);
    }
};
</script>  

<style>  
</style>  