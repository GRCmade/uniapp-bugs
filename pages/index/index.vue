<template>
  <view>
   <button @click="click">click</button>
   <button @click="click2">click2</button>
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
			  // iconPath: '/static/tabbar/1.png',
			  iconPath: '../../static/img1/image/2.png',
			  selectedIconPath: '/static/tabbar/11.png'
			})
    },
		click2(){
			uni.setTabBarStyle({
			  color: '#FF0000',
			  selectedColor: '#00FF00',
			  backgroundImage:"/static/back.png"
			})

		}
  }
}
</script>


<style></style>


