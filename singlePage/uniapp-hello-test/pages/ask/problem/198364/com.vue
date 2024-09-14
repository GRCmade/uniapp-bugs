<template>  
    <view class="ft-test">  
        <view v-for="(p, index) in protocols" :key="index">  
            <slot name="test-slot" :protocol="p">  
                <text>test-slot-{{ index }}，</text>  
            </slot>  
            第{{ index }}条数据  
        </view>  
    </view>  
</template>  

<script>  
export default {  
    name: 'ft-test',  
    props: {  
        protocols: {  
            type: Array,  
            default: () => []  
        }  
    },  
    data() {  
        return {}  
    },  
    created() {  
        console.log('ft-test-this----', this, this.$slots)  
        console.log('ft-test-$scopedSlots----', this.$scopedSlots)  
    }  
}  
</script>