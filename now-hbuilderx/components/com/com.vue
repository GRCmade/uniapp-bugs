<template>
  <div>
    com 组件(自定义组件)
  </div>
</template>

<script>
export default {
  name: 'com',
  options: {
    virtualHost: true
  },
  props: {
    msg: {
      type: String,
      default: '默认消息'
    }
  }
}
</script>

<style scoped>

</style>