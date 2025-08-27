<template>
  <page-meta>
    <navigation-bar background-color="#007AFF" :titleIcon="nbTitleIcon" :title="nbTitle" :subtitleText="nbSubtitle"
      title-icon-radius="20px" front-color="#F8F8F8" subtitle-color="#F8F8F8" titleAlign="left"></navigation-bar>
  </page-meta>
  <view class="page">
    <view class="title">{{title}}</view>
    <view class="title-time">{{titleTime}}</view>
    <view class="user-area">
      <view class="uni-icon">
        <image class="user-avatar" :src="userIcon"></image>
      </view>
      <view class="user-info">
        <view class="user-name">{{userName}}</view>
        <view class="user-level">{{userLevel}}</view>
      </view>
    </view>
    <view class="detail-content">
      <text class="richText">
        滚动页面，当用户头像区域底部消失时，更新titleNView
      </text>
    </view>
  </view>
</template>

<script>
  const USER_AREA_CLASS = ".user-area";
  export default {
    data() {
      return {
        title: '标题',
        userIcon: '/static/logo.png',
        userName: "uni-app",
        userLevel: "普通会员",
        titleTime: "1小时前",
        nbTitleIcon: "",
        nbTitle: "",
        nbSubtitle: ""
      }
    },
    onLoad(e) {
      this._scrollTopFlag = 0;
      this._userAvatarArea = null;
    },
    onReady() {
      uni.createSelectorQuery().in(this).select(USER_AREA_CLASS).boundingClientRect(
        (rect) => {
          this._userAvatarArea = rect;
          console.log(rect);
        }).exec();
    },
    onPageScroll(e) {
      if (!this._userAvatarArea) {
        return;
      }
      let userAvatarBottom = this._userAvatarArea.top + this._userAvatarArea.height;
      if (e.scrollTop < userAvatarBottom) {
        if (this._scrollTopFlag !== -1) {
          this.updateTitleView(null);
          this._scrollTopFlag = -1;
        }
      } else {
        if (this._scrollTopFlag !== 1) {
          uni.setNavigationBarTitle({
            title: ''
          });
          this.updateTitleView(this.userIcon, this.title, this.userName);
          this._scrollTopFlag = 1;
        }
      }
    },
    methods: {
      updateTitleView(icon, title, subtitle) {
        if (icon == null) {
          this.nbTitle = "";
          this.nbSubtitle = "";
          this.nbTitleIcon = "";
          return;
        }

        this.nbTitle = title;
        this.nbSubtitle = subtitle;
        this.nbTitleIcon = icon;
      }
    }
  }
</script>

<style>
  .page {
    padding: 10px 15px;
  }

  .title {
    font-size: 20px;
    line-height: 2;
  }

  .title-time {
    color: #8f8f94;
    font-size: 28upx;
    line-height: 1.5;
  }

  .user-area {
    padding: 10px;
    margin-top: 20px;
    display: flex;
    flex-direction: row;
    border-bottom: 1px solid #f0f0f0;
    border-top: 1px solid #f0f0f0;
  }

  .user-icon {
    position: relative;
    padding-top: 5px;
    padding-right: 10px;
  }

  .user-info {
    display: flex;
    flex-direction: column;
    margin-left: 15px;
  }

  .user-avatar {
    width: 40px;
    height: 40px;
  }

  .user-name {
    font-size: 14px;
  }

  .user-level {
    font-size: 14px;
    margin-top: 10px;
    opacity: .5;
  }

  .detail-content {
    height: 2000px;
    padding-top: 15px;
  }
  
  .richText {
    color: #999;
    line-height: 1.5;
  }
</style>
