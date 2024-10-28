<template>
  <view >
    <text>Component,{{ type }}</text>
  </view>
</template>

<script lang="ts">
type Type =  "default" | "primary" | "warn"
export default {
  data() {
    return {
      show: false,
    }
  },
  props:{
    type:{
      type:String as PropType<Type>,
      default:'default'
    }
  },
  mounted() {
    console.log('mounted')
  },
  methods: {
    ChangeShow() {
      console.log("ChangeShow")
      this.show = true
    }
  }
}
</script>

<style lang="scss"></style>