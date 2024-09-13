<template>
  <div id="container" class="map">
    <map class="map__content"
         :longitude="106.631187"
         :latitude="29.718143"
         :enable-poi="true"
         :enable-3D="true"
         :enable-building="true"
         :scale="11"
         :markers="markersList"
         :polyline="polylineList">
    </map>
  </div>
</template>

<script setup>  
  let markersList = [  
    {  
      id: 0,  
      latitude: '29.718143', // 纬度  
      longitude: '106.731187', // 经度  
      width: 30,  
      height: 40,  
      iconPath: 'https://mapapi.qq.com/web/lbs/javascriptGL/demo/img/start.png',  
      callout: {  
        content: '文本的内容',  
        color: '#ffe300',  
        fontSize: 14  
      }  
    },  
    {  
      id: 1,  
      latitude: '29.718143', // 纬度  
      longitude: '106.631187', // 经度  
      width: 30,  
      height: 40,  
      iconPath: 'https://mapapi.qq.com/web/lbs/javascriptGL/demo/img/end.png',  
      callout: {  
        content: '文本的内容1',  
        color: '#ffe300',  
        fontSize: 14  
      }  
    }  
  ]  

  let polylineList = [  
    {  
      points: [  
        {  
          latitude: '29.718143',  
          longitude: '106.731187'  
        },  
        {  
          latitude: '29.718143',  
          longitude: '106.711187'  
        },  
        {  
          latitude: '29.718143',  
          longitude: '106.691187'  
        },  
        {  
          latitude: '29.718143',  
          longitude: '106.651187'  
        },  
        {  
          latitude: '29.718143',  
          longitude: '106.631187'  
        }  
      ],  
      colorList: ['#ec410f', '#ff00ea', '#000dff', '#ffe300'],  
      width: 10  
    }  
  ]  
</script>  

<style scoped lang="scss">  
  .map {  
    width: 100vw;  
    height: 100vh;  

    &__content {  
      width: 100%;  
      height: 100%;  
    }  
  }  
</style>