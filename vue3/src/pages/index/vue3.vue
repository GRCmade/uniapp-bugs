<template>
  <view>
    <movable-area style="border: 1px solid red; width: 100%; height: 60rpx; margin-top: 30rpx">
      <movable-view :x="x" direction="horizontal" @change="onChange" @touchmove="touchmove" @touchend="endTouch">text</movable-view>
    </movable-area>
    {{ x }}
    <button @click="click">点击</button>
  </view>
</template>

<script setup>
import { ref, nextTick } from 'vue'

const x = ref(20)
const old_x = ref(20)
const onChange = e => {
  old_x.value = e.detail.x
}

const endTouch = e => {
  console.log('endTouch', e)
	setTimeout(()=>{
		x.value = old_x.value
		nextTick(() => {
		  x.value = 20
		})
	},100)
}

const touchmove = e => {
  // console.log('touchmove', e)
}

const click = () => {
  x.value = old_x.value
  nextTick(() => {
    x.value = 20
  })
}
</script>

<style></style>
