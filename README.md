======== README.md ========

# uni-data-picker组件在readonly属性为true时选项匹配错误
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题

代码内容
```vue
<template>
  <view>
    <uni-data-picker v-model="temperature" placeholder="请选择最高气温"
      :localdata="temperaturePicker"></uni-data-picker>
  </view>
</template>

<script>
  export default {
    data() {
      return {
        temperature: "25",
        temperaturePicker: []
      }
    },
    onLoad() {
      for (var i = 50; i > -41; i--) {
        this.temperaturePicker.push({
          text: `${i}℃`,
          value: `${i}`
        });
      }
    }
  }
</script>
```

显示的效果：
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250305104925052.png)

在标签上，加入readonly之后：
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250305105342236.png)

======== END ========