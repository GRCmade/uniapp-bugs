<template>
	<view id="navId" class="nav-bg" :style="{background: background}">
        <u-navbar 
            :title="title" 
            safeAreaInsetTop 
            fixed 
            placeholder
            :autoBack="false" 
            :bgColor="background"
            :titleStyle="{
                color: color
            }"
        >
            <view class="u-nav-slot" slot="left">
                <u-icon :color="color" name="arrow-left" size="19" @click="goBack()"></u-icon>
                <u-line direction="column" :hairline="false" length="16" margin="0 8px"></u-line>
                <u-icon :color="color" name="home" size="20" @click="goHome()"></u-icon>
            </view>
        </u-navbar>
    </view>
</template>
 
<script>
	export default {
		data() {
			return {
				height: 0, 
				paddingTop: 0,
			}
		},
		props:{
			title:{ // 标题文字(默认为空)
				type:String,
				default:'标题'
			},
			color:{ // 标题和返回按钮颜色(默认白色)
				type:String,
				default:'#000'
			},
            //建议使用background  因为使用backgroundColor，会导致不识别渐变颜色
			background:{ // 背景颜色(不传值默认透明)
				type:String,
				default:'transparent'
			},
			customBack:{ // 自定义返回
				type:Boolean,
				default: false
			},
		},
        mounted() {
            const query = uni.createSelectorQuery().in(this);
            query.select('#navId').boundingClientRect(data => {
                this.height = data.height
                this.$emit('navHeight', this.height)
            }).exec();
        },
		methods: {
			goHome() {
				/* 返回主页 */
				uni.reLaunch({
					url: '/pages/index/index'
				});
			},
			goBack() {
                if(!this.customBack) {
                    /* 返回上一页 */
                    uni.navigateBack();
                } else {
                    this.$emit('goBack')
                }
			},
		}
	}
</script>
<style lang="scss">
	.u-nav-slot {
        display: flex;
        align-items: center;
        justify-content: space-between;
        border: 1rpx solid #E3E6EB;
        border-radius: 32rpx;
        padding: 3px 7px;
        opacity: 0.8;
    }
</style>