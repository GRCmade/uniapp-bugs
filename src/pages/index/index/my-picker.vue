<template>
  <view>
    <view class="uni-padding-wrap">
      <view class="uni-title">日期：{{ year }}年{{ month }}月{{ day }}日</view>
    </view>
    <picker-view
      v-if="visible"
      :indicator-style="indicatorStyle"
      :value="value"
      @change="bindChange"
      class="picker-view"
    >
      <picker-view-column>
        <slot name="years"></slot>
      </picker-view-column>
      <picker-view-column>
        <slot name="months"></slot>
      </picker-view-column>
      <picker-view-column>
        <slot name="days"></slot>
      </picker-view-column>
    </picker-view>
  </view>
</template>

<script>
  export default {
    data: function () {
      const date = new Date();
      const years = [];
      const year = date.getFullYear();
      const months = [];
      const month = date.getMonth() + 1;
      const days = [];
      const day = date.getDate();
      for (let i = 1990; i <= date.getFullYear(); i++) {
        years.push(i);
      }
      for (let i = 1; i <= 12; i++) {
        months.push(i);
      }
      for (let i = 1; i <= 31; i++) {
        days.push(i);
      }
      return {
        title: 'picker-view',
        years,
        year,
        months,
        month,
        days,
        day,
        value: [9999, month - 1, day - 1],
        visible: true,
        indicatorStyle: `height: 50px;`,
      };
    },
    methods: {
      click() {
        uni.chooseImage({
          count: 1,
          sourceType: ['camera', 'album'],
          success: function (res) {
            uni.saveImageToPhotosAlbum({
              filePath: res.tempFilePaths[0],
              success: function () {
                console.log('save success');
              },
            });
          },
        });
      },
      bindChange: function (e) {
        const val = e.detail.value;
        this.year = this.years[val[0]];
        this.month = this.months[val[1]];
        this.day = this.days[val[2]];
      },
    },
  };
</script>
<style>
  .picker-view {
    width: 750rpx;
    height: 600rpx;
    margin-top: 20rpx;
  }

  .item {
    line-height: 100rpx;
    text-align: center;
  }
</style>
