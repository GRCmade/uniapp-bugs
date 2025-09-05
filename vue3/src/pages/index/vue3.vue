<template>
  <view>
    <button @click="click">index-next</button>
  </view>
</template>

<script lang="ts" setup>
const click = () => {
	uni.navigateTo({
		url:"/pages/index/index-next"
	})
}
</script>

<style></style>
