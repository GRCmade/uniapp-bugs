<template>
  <div @click.stop="handler">
    com 组件(自定义组件1)
  </div>
</template>

<script>
export default {
  name: 'com',
  props: {
    msg: {
      type: String,
      default: '默认消息'
    }
  },
  methods: {
    handler() {
      console.log('com 组件被点击了')
    }
  }
}
</script>

<style scoped>

</style>