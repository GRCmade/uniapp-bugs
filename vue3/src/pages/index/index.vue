<template>
  <view class="content">
    <map id="map" class="map" :show-location="true" :latitude="latitude" :longitude="longitude"></map>
    <button @click="getCenterLocation">getCenterLocation</button>
  </view>
</template>
<script>
  const img = '/static/logo.png'
  export default {
    data() {
      return {
        latitude: 23.099994,
        longitude: 113.32452
      }
    },
    onReady() {},
    methods: {
      getCenterLocation() {
        this._mapContext = uni.createMapContext('map', this)
        this._mapContext.getCenterLocation({
          success(res) {
            console.log('getCenterLocation', res.latitude)
          }
        })
      }
    }
  }
</script>
<style>
  .content {
    flex: 1;
  }

  .map {
    flex: 1;
  }
</style>
