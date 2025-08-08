<template >
    <view>
       1111
        <TabBar></TabBar>
    </view>
</template>
<script>
export default {
    data() {
        return {
            topList: [
                
            ],
            markers: [],
            // 泉西设计经纬度
            longitude: 118.496586,
            latitude: 32.086318,
            polygons: [],
            gridMapList: []
        }
    },
    onLoad(options) {
		
    },
    methods: {
    },
}
</script>
<style lang="scss">
    .map-style {
        width: 750rpx;
        height: calc(100vh - 288rpx);
        margin-top: 20rpx;
    }
</style>