<template>
  <view>
   <view v-for="i in 10" class="box">{{ i }}</view>
  </view>
</template>


<script>
export default {
  data() {
    return {}
  },
  methods: {
    click(){
			
    }
  }
}
</script>


<style>
.box{
  height: 200px;
  width: 100%;
  background-color: #36d;
}
</style>

