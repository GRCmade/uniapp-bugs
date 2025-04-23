<template>
    <view>e-chart<e-chart ref="chartRef" @ready="initData" :style="props.custstyle"></e-chart></view>
</template>

<script setup>
import * as echarts from 'echarts'
import {onMounted, ref, watch, nextTick} from 'vue'

const num = ref(0);
const chartRef = ref(null);
const props = defineProps({
    option:{
        type: Object,
        default:{}
    },
    custstyle:{
        type: String,
        default: 'width:750rpx; height:750rpx'
    }
})

const initData = () => {
    chartRef.value.init(props.option)
}

watch(
    () => props.option, 
    (newVal, oldVal) => {
        chartRef.value.setOption(props.option)
    },
    {
        deep: true
    }
)
// onMounted( ()=>{
//     // 组件能被调用必须是组件的节点已经被渲染到页面上
//     setTimeout(async()=>{
//         if(!chartRef.value) return
//         const myChart = await chartRef.value.init(echarts)
//         myChart.setOption(props.option)
//     },300)
// })


</script>

<style>
</style>