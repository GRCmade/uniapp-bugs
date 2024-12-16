<template>
  <view>
    <button @click="click">saveImageToPhotosAlbum</button>
    <my-picker>
      <template v-slot:years>
        <view class="item" v-for="(item, index) in years" :key="index">{{item}}年</view>
      </template>
      <template v-slot:months>
        <view class="item" v-for="(item, index) in months" :key="index">{{item}}月</view>
      </template>
      <template v-slot:days>
        <view class="item" v-for="(item, index) in days" :key="index">{{item}}日</view>
      </template>
    </my-picker>
		<image v-if="true" src="https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20241210113102.png"></image>
		<input type="text" v-model="input" class="input" :focus="inputFocus" @focus="focus" @blur="blur"/>
		<uni-load-more :status="'loading'"></uni-load-more>
  </view>
</template>

<script>
  import myPicker from './my-picker.vue';
  export default {
    data() {
      return {
        years: [],
        months: [],
        days: [],
				input:"",
				inputFocus:true
      }
    },
    components: { myPicker },
    created() {
      const date = new Date();
      for (let i = 1990; i <= date.getFullYear(); i++) {
        this.years.push(i);
      }
      for (let i = 1; i <= 12; i++) {
        this.months.push(i);
      }
      for (let i = 1; i <= 31; i++) {
        this.days.push(i);
      }
    },
    methods: {
      click() {
        uni.chooseImage({
          count: 1,
          sourceType: ['camera', 'album'],
          success: function(res) {
            uni.saveImageToPhotosAlbum({
              filePath: res.tempFilePaths[0],
              success: function() {
                console.log('save success');
              }
            });
          }
        });
      },
			focus(){
				
			},
			blur(){
				
			}
    }
  }
</script>

<style>
	.input{
		padding: 20px;
		border: 1px solid #000;
		background-color: aqua;
	}
</style>

