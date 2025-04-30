<template>
  <view>
    <!-- 1.我无法直接在模板里直接使用 typeof 但h5可以 -->
    <!-- 2. 
      Function类型的default值
      H5 function  小程序 string
    -->
    <view> defaultFuncType prop type: {{ defaultFuncType }} typeof {{ typeofDefault }}</view>
    <view> propFunc prop type: {{ propFuncType }} typeof {{ typeofProp }} </view>
  </view>
</template>

<script>
export default {
  name: "TestFunctionProp",
  props: {
    defaultFunc: {
      type: Function,
      default() {
        return "this is string";
      },
    },
    propFunc: {
      type: Function,
      default() {
        return "this is propFunc";
      },
    },
  },
  computed: {
    defaultFuncType() {
      return this.defaultFunc;
    },
    typeofDefault(){
      return typeof this.defaultFunc
    },
    propFuncType() {
      return this.propFunc;
    },
    typeofProp(){
      return typeof this.propFunc
    }
  },
  methods: {},
};
</script>

<style lang="scss" scoped></style>
