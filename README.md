======== README.md ========

# app 上 switchTab 的拦截器，无法正确拦截
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

链接 next 仓库

# 问题

```
uni.addInterceptor('switchTab', {
  invoke(args) {
    console.log("切换tab", args)
    if(args.url == '/pages/tabbar/tabbar-2/tabbar-2') {
      uni.navigateTo({
        url: '/pages/index/index-next'
      })
      return false
    }
  }
})
```

这段代码，拦截之后，会进行跳转
在app上，tabbar 会保留在 2 的位置,并且页面显示的内容也不正确
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250321120058.png)

在 h5 上，tabbar会在切换前触发，也就是返回后，不会保留在2的位置
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250321120151.png)
======== END ========
