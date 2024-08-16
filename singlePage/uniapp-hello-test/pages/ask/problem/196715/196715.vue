<template>  
    <page-meta page-style="overflow:hidden"></page-meta>  
    <view class="reservationApply">  
        <view class="container">  
            <view class="container-box">  
                <view class="container-box-title">  
                    入园信息  
                </view>  
                <uni-forms err-show-type="toast" ref="form" :modelValue="formData" border label-width="100"  
                    :rules="rules">  
                    <uni-forms-item required label="司机姓名:" name="driverName" class="labelClass">  
                        <uni-easyinput type="text" :inputBorder="false" v-model="formData.driverName" placeholder="请输入"  
                            maxlength="10" />  
                    </uni-forms-item>  
                    <uni-forms-item required label="司机姓名:" name="driverName" class="labelClass">  
                        <uni-easyinput type="text" :inputBorder="false" v-model="formData.driverName" placeholder="请输入"  
                            maxlength="10" />  
                    </uni-forms-item>  
                    <uni-forms-item required label="司机姓名:" name="driverName" class="labelClass">  
                        <uni-easyinput type="text" :inputBorder="false" v-model="formData.driverName" placeholder="请输入"  
                            maxlength="10" />  
                    </uni-forms-item>  
                    <uni-forms-item required label="司机姓名:" name="driverName" class="labelClass">  
                        <uni-easyinput type="text" :inputBorder="false" v-model="formData.driverName" placeholder="请输入"  
                            maxlength="10" />  
                    </uni-forms-item>  
                    <uni-forms-item required label="司机姓名:" name="driverName" class="labelClass">  
                        <uni-easyinput type="text" :inputBorder="false" v-model="formData.driverName" placeholder="请输入"  
                            maxlength="10" />  
                    </uni-forms-item>  
                    <uni-forms-item required label="司机姓名:" name="driverName" class="labelClass">  
                        <uni-easyinput type="text" :inputBorder="false" v-model="formData.driverName" placeholder="请输入"  
                            maxlength="10" />  
                    </uni-forms-item>  
                    <uni-forms-item required label="司机姓名:" name="driverName" class="labelClass">  
                        <uni-easyinput type="text" :inputBorder="false" v-model="formData.driverName" placeholder="请输入"  
                            maxlength="10" />  
                    </uni-forms-item>  
                    <uni-forms-item required label="司机姓名:" name="driverName" class="labelClass">  
                        <uni-easyinput type="text" :inputBorder="false" v-model="formData.driverName" placeholder="请输入"  
                            maxlength="10" />  
                    </uni-forms-item>  
                    <uni-forms-item required label="司机姓名:" name="driverName" class="labelClass">  
                        <uni-easyinput type="text" :inputBorder="false" v-model="formData.driverName" placeholder="请输入"  
                            maxlength="10" />  
                    </uni-forms-item>  
                    <uni-forms-item required label="司机姓名:" name="driverName" class="labelClass">  
                        <uni-easyinput type="text" :inputBorder="false" v-model="formData.driverName" placeholder="请输入"  
                            maxlength="10" />  
                    </uni-forms-item>  
                    <uni-forms-item required label="司机姓名:" name="driverName" class="labelClass">  
                        <uni-easyinput type="text" :inputBorder="false" v-model="formData.driverName" placeholder="请输入"  
                            maxlength="10" />  
                    </uni-forms-item>  
                    <uni-forms-item required label="司机姓名:" name="driverName" class="labelClass">  
                        <uni-easyinput type="text" :inputBorder="false" v-model="formData.driverName" placeholder="请输入"  
                            maxlength="10" />  
                    </uni-forms-item>  
                    <uni-forms-item required label="司机姓名:" name="driverName" class="labelClass">  
                        <uni-easyinput type="text" :inputBorder="false" v-model="formData.driverName" placeholder="请输入"  
                            maxlength="10" />  
                    </uni-forms-item>  
                    <uni-forms-item required label="司机姓名:" name="driverName" class="labelClass">  
                        <uni-easyinput type="text" :inputBorder="false" v-model="formData.driverName" placeholder="请输入"  
                            maxlength="10" />  
                    </uni-forms-item>  
                </uni-forms>  
            </view>  
        </view>  
        <view class="container-btn">  
            <u-button shape="circle" type="primary" text="提交审核"></u-button>  
        </view>  
    </view>  
</template>  

<script>  
    // import dayjs from 'dayjs';  
    export default {  
        data() {  
            return {  
                formData: { //申请单表单项  
                    driverName: '', //司机姓名  
                },  
            }  
        },  
        onLoad(opt) {},  
        computed: {},  
        watch: {},  
        methods: {  

        }  
    }  
</script>  

<style scoped lang="scss">  
    .reservationApply {  
        width: 100%;  
        background-color: #f4f4f4;  
        background-size: 100% 100%;  
        overflow-y: auto;  
        height: 100vh;  
        padding-top: 40rpx;  
        position: relative;  
    }  

    .container {  
        width: 100%;  
        height: auto;  
        background-color: #f4f4f4;  
        background-size: 100% 100%;  
        overflow-y: auto;  
        padding: 0 20rpx;  
        position: relative;  

        .container-box {  
            background-color: #ffffff;  
            padding: 32rpx 24rpx;  
            width: 100%;  
            height: auto;  
            overflow-y: auto;  
            box-sizing: border-box;  
            border-radius: 20rpx;  

            ::v-deep .uni-forms-item__label {  
                font-size: 28rpx !important;  
                color: rgba(0, 0, 0, 0.90) !important;  
                text-align: right !important;  
                font-family: Helvetica !important;  
                font-weight: 400 !important;  
            }  

            ::v-deep .uni-easyinput__content-input {  
                font-size: 28rpx !important;  
                color: rgba(0, 0, 0, 0.90) !important;  
                text-align: right !important;  
                font-family: Helvetica !important;  
                letter-spacing: 0 !important;  
                font-weight: 400 !important;  
            }  

            ::v-deep .uni-easyinput__placeholder-class {  
                font-family: Helvetica;  
                font-size: 28rpx;  
                color: rgba(0, 0, 0, 0.40);  
                letter-spacing: 0;  
                font-weight: 400;  
            }  

            ::v-deep .content-clear-icon {  
                padding-right: 0 !important;  
                margin-top: 8rpx;  
            }  

            ::v-deep .uni-forms-item__error {  
                text-align: right;  
            }  

            .container-box-title {  
                height: 50rpx;  
                font-family: PingFangSC-Regular;  
                font-size: 36rpx;  
                color: rgba(0, 0, 0, 0.90);  
                font-weight: 400;  
                margin-bottom: 24rpx;  
            }  

        }  

    }  

    .container-btn {  
        background-color: #ffffff;  
        height: 188rpx;  
        display: flex;  
        align-items: center;  
        margin-top: 48rpx;  
        padding: 84rpx;  
    }  
</style>