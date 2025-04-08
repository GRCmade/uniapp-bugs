======== README.md ========

# v-if 用在 slot 上，在小程序下会触发 onMounted，和 H5 上不触发的表现不一致

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250408153842.png)

可以对比 微信小程序 和 h5 上的 表现,在微信小程序上会触发,在 h5 上不会触发

如果有这个组件,应该有 console mounted
```
<template>
  <view>console mounted</view>
</template>
```


======== END ========
