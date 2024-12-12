<template>
  <view>
   <button @click="click">click</button>
  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  methods: {
    click(){
			uni.setTabBarItem({
			  index: 1,
			  text: 'yuhe',
			  iconPath: '/static/tabbar/1.png',
			  selectedIconPath: '/static/tabbar/11.png'
			})
    }
  }
}
</script>


<style></style>

