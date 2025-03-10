<template>
  {{ lon+' '+lat }}
  <map id="unimap" class="w-750 h-full" :longitude="lon" :latitude="lat" @markertap="markertap"
    @regionchange="regionchange"></map>
</template>

<script setup>
import { onMounted, ref, getCurrentInstance, nextTick } from 'vue';
const map = ref(null)
const { ctx } = getCurrentInstance();
const lon = ref(34)
const lat = ref(34)

// var map;
onMounted(() => {
  getre()
});

async function regionchange(event) {
  if(event.type == 'begin')return
  console.log('范围变化', event, map.value);
  lon.value = event.detail.centerLocation.longitude
  lat.value = event.detail.centerLocation.latitude
  getre()
}

async function getre() {
  uni.createMapContext('unimap', ctx).getRegion({
    success: function (res) {
      console.log('视野范围:', res);
    },
    fail: function (err) {
      console.error('获取视野范围失败:', err);
    },
    complete: () => { }
  });
}
</script>