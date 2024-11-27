
<script>
	export default {
		options: {
			virtualHost: true
		}
	}
</script>
<template>  
    <view class="test">  
        <uni-icons type="close"  class="close"></uni-icons>  
    </view>  
</template>  
<style lang="scss" scoped>  
.test{  
    position: relative;  
    .close{  
        position: absolute;  
        bottom: 100rpx;  
        left: 50%;  
        transform: translateX(-50%);  
        :deep(.uni-icons){  
            font-size: 48rpx!important;  
            color: #FFF!important;  
        }  
    }  
}  
</style>  