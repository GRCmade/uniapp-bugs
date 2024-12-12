<template>
  <view>
   <button @click="click">click</button>
	 <child-vue ref="childValue"></child-vue>
  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  methods: {
    click(){
			this.$refs.childValue.test()
    }
  }
}
</script>


<style></style>

