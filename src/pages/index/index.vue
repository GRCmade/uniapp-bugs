<template>
  <view class="content">
    <map id="map" ref="map" class="map" :latitude="latitude" :longitude="longitude" :markers="markers"
      :polyline="polyline" :scale="scale"></map>
    <view class="control-panel">
      <button class="btn" @click="startTrackPlayback">开始轨迹回放</button>
      <button class="btn" @click="resetTrackPlayback">重置</button>
    </view>
  </view>
</template>

<script lang="ts">
export default {
  data() {
    return {
      latitude: 39.908823,
      longitude: 116.397470,
      scale: 14,
      mapCtx: null as UniApp.MapContext | null,
      markers: [{
        id: 1,
        latitude: 39.908823,
        longitude: 116.397470,
        width: 30,
        height: 30,
        iconPath: '/static/logo.png',
      }],
      polyline: [{
        points: [
          { latitude: 39.908823, longitude: 116.397470 },
          { latitude: 39.909823, longitude: 116.398470 },
          { latitude: 39.910823, longitude: 116.399470 },
          { latitude: 39.911823, longitude: 116.400470 },
          { latitude: 39.912823, longitude: 116.402470 },
          { latitude: 39.913823, longitude: 116.403470 },
          { latitude: 39.914823, longitude: 116.404470 },
        ],
        color: '#FF0000',
        width: 4,
      }],
      trackPlaybackIndex: 0,
      mapReady: false
    }
  },
  onReady() {
    // 延迟创建地图上下文，确保地图组件已完全加载
    setTimeout(() => {
      this.mapCtx = uni.createMapContext('map', this)
      this.mapReady = true
      console.log('地图上下文已初始化')
    }, 300)
  },
  methods: {
    /**
     * 开始轨迹回放
     */
    startTrackPlayback() {
      if (!this.mapReady || !this.mapCtx) {
        uni.showToast({
          title: '地图尚未加载完成，请稍后再试',
          icon: 'none'
        })
        return
      }

      this.trackPlaybackIndex = 0
      // 初始化标记点位置
      const startPoint = this.polyline[0].points[0]
      // 先更新markers数组
      this.markers = [{
        id: 1,
        latitude: startPoint.latitude,
        longitude: startPoint.longitude,
        width: 30,
        height: 30,
        iconPath: '/static/location.png',
      }]

      // 确保标记点更新后再开始移动
      setTimeout(() => {
        this.translateMarker()
      }, 100)
    },

    /**
     * 重置轨迹回放
     */
    resetTrackPlayback() {
      this.trackPlaybackIndex = 0
      const startPoint = this.polyline[0].points[0]
      // 直接替换整个markers数组
      this.markers = [{
        id: 1,
        latitude: startPoint.latitude,
        longitude: startPoint.longitude,
        width: 30,
        height: 30,
        iconPath: '/static/location.png',
      }]
    },

    /**  
     * 绘制轨迹  
     */
    translateMarker() {
      const points = this.polyline[0].points
      if (this.trackPlaybackIndex >= points.length) {
        console.log('轨迹回放结束')
        return
      }
      const latitude = points[this.trackPlaybackIndex].latitude
      const longitude = points[this.trackPlaybackIndex].longitude

      console.log('开始移动标记，目标位置:', latitude, longitude)

      if (!this.mapCtx) {
        console.error('地图上下文未初始化')
        return
      }

      try {
        // 绘制轨迹  
        this.mapCtx.translateMarker({
          markerId: 1,
          autoRotate: false,
          rotate: 0,
          duration: 1000,
          destination: {
            latitude: 39.914823, longitude: 116.404470
          },
          animationEnd: () => {
            this.trackPlaybackIndex++
            this.translateMarker()
            console.log('animation end')
          },
          fail: (err: any) => {
            console.error('绘制轨迹失败:', err)
            // 如果移动失败，尝试直接更新marker位置并继续
            this.markers = [{
              ...this.markers[0],
              latitude,
              longitude
            }]
          },
        })
      } catch (error) {
        console.error('translateMarker执行错误:', error)
      }
    }
  }
}
</script>

<style>
.content {
  width: 100%;
  height: 100vh;
  display: flex;
  flex-direction: column;
}

.map {
  width: 100%;
  height: 80vh;
}

.control-panel {
  width: 100%;
  height: 20vh;
  display: flex;
  justify-content: center;
  align-items: center;
  padding: 20rpx;
}

.btn {
  margin: 0 20rpx;
}
</style>
