<template>
    <view class="container">
        <view class="content">
            <u-icon name="map" label="浦口区" labelSize="32rpx" labelColor="#000000" space="12rpx" size="32rpx"></u-icon>
            <view class="district">
                <u-grid :border="false" col="1">
                    <u-grid-item>
                        <view style="margin:40rpx 40rpx 18rpx 40rpx; align-self:flex-start;">
                            <u-text text="所属街道" mode="text" bold="true" size="32rpx" lineHeight="48rpx" block="true">
                            </u-text>
                        </view>
                        <u-line length="90%"></u-line>
                    </u-grid-item>
                </u-grid>

                <view class="choose_district">
                    <view v-for="(item, index) in districtList" class="button-item">
                        <u-button
                            :custom-style="{
                                'color': districtCode == item.communityCode ? '#0052D9' : '#000000',
                                'font-size': '32rpx',
                                'border': districtCode == item.communityCode ? '2rpx solid #0052D9' : '2rpx solid #DCDCDC'
                            }"
                            shape="circle" 
                            plain="true" 
                            :text="item.name"
                            @click="clickDistrict(item.communityCode, item.name)">
                        </u-button>
                    </view>

                </view>
                <u-grid :border="false" col="1">
                    <u-grid-item>
                        <view style="margin:40rpx 18rpx 40rpx; align-self:flex-start;">
                            <u-text 
                                text="所属社区" 
                                mode="text" 
                                bold="true" 
                                size="32rpx" 
                                lineHeight="48rpx"
                                block="true">
                            </u-text>
                        </view>
                        <u-line length="90%"></u-line>
                    </u-grid-item>
                </u-grid>
                <view class="choose_district">

                    <view v-for="(item, index) in communityList" class="button-item">
                        <u-button
                            :custom-style="{
                                'color': communityCode == item.communityCode ? '#0052D9' : '#000000',
                                'font-size': '32rpx',
                                'border': communityCode == item.communityCode ? '2rpx solid #0052D9' : '2rpx solid #DCDCDC'
                            }"
                            shape="circle" 
                            plain="true" 
                            :text="item.name"
                            @click="clickCommunity(item.communityCode, item.name)">
                        </u-button>
                    </view>
                </view>

            </view>
            <view class="choose_button">
                <u-button 
                    color="#0052D9" 
                    :disabled="district == '' || community == ''" 
                    text="确认"
                    @click="saveCommunity"></u-button>
            </view>
        </view>

    </view>
</template>

<script>
export default {
    data() {
        return {
            rootCode: '320111',
            districtCode: '',
            district: '',
            communityCode: '',
            community: '',
            districtList: [],
            communityList: []
        };
    },
    onLoad() {
        this.districtCode = this.vuex_communityInfo ? this.vuex_communityInfo.districtCode : '',
        this.district = this.vuex_communityInfo ? this.vuex_communityInfo.district : '',
        this.communityCode = this.vuex_communityInfo ? this.vuex_communityInfo.communityCode : '',
        this.community = this.vuex_communityInfo ? this.vuex_communityInfo.community : '',
        this.loadDistrict();
    },
    methods: {
        loadDistrict() {
            // 加载街道数据
            let _this = this;
            uni.$u.api.index.getCommunity({ communityCode: this.rootCode }).then(res => {
                if (res.code == 200) {
                    if (res.data) {
                        res.data.forEach(function (item, index) {
                            _this.districtList.push(item);
                        });
                        if(this.districtCode) {
                            this.loadCommunity(this.districtCode);
                        }
                    }
                }
            })
        },

        loadCommunity(districtCode) {
            // 加载某个街道的社区
            let _this = this;
            uni.$u.api.index.getCommunity({ communityCode: districtCode }).then(res => {
                if (res.code == 200) {
                    if (res.data) {
                        _this.communityList = []
                        res.data.forEach(function (item, index) {
                            _this.communityList.push(item);
                        });
                    }
                }
            })
        },
        clickDistrict(id, name) {
            // 选择某个街道
            this.district = name;
            this.districtCode = id;
            if (this.districtCode) {
                this.loadCommunity(this.districtCode)
            }

        },
        clickCommunity(id, name) {
            // 选择某个社区
            this.community = name
            this.communityCode = id
        },
        saveCommunity() {
            // 跳转页面
            uni.reLaunch({
                url: '/pages/home/home',
                success: (success) => {
                    this.$u.vuex('vuex_communityInfo', {
                        district: this.district,
                        districtCode: this.districtCode,
                        communityCode: this.communityCode, 
                        community: this.community
                    })
                    uni.$emit('refresh', true)
                },
            });
        }

    }
}
</script>

<style lang="scss">
page {
    background: #F3F3F3;

    .content {
        padding: 24rpx;
    }

    .district {
        // height: 600rpx;
        background: #Ffffff;
        border-radius: 16rpx;
        margin-top: 16rpx;
        padding-bottom: 40rpx;

        .choose_district {
            display: flex;
            justify-content: space-between;
            margin: 0rpx 56rpx 0rpx 56rpx;
            flex-wrap: wrap;

            .button-item {
                margin-top: 48rpx;
                width: 256rpx;
                height: 80rpx;

                /* 修改自定义按钮按下装态的样式 */
                ::v-deep .u-button--active {
                    background-color: rgba(0, 82, 217, 0.8);
                    color: #ffffff !important;
                }
            }
        }


    }

    .choose_button {
        margin-top: 32rpx;
    }
}
</style>