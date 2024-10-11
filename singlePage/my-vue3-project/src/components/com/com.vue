<template>
    <view v-if="show">
        <text>Component</text>
    </view>
</template>

<script>
export default{
    data(){
        return {
            show: false
        }
    },
    mounted(){
        console.log('mounted')
    },
    methods:{
        ChangeShow(){
            console.log("ChangeShow")
            this.show = true
        }
    }
}
</script>

<style lang="scss"></style>