======== README.md ========

# 在 webview 中使用 uniapp 提供的 uni 方法（UniAppJSBridge）
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

- npx @dcloudio/uvm@latest
- pnpm add @dcloudio/uni-mp-weixin@/Users/gaoruicheng/Documents/DcloudProject/uni-app-next/packages/uni-mp-weixin

# 问题
一个 uniapp 项目中，包含一个 wev-view 组件

```
<template>
  <view>
    <button @click="click">click</button>
    <web-view src="http://192.168.31.148:5500"></web-view>
  </view>
</template>
```

在 web-view 组件中，使用宿主的 uni 方法
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250313133608053.png)


但是发现，无法调用 chooseImage , 能够调用 switchTab
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250313133733439.png)
======== END ========
