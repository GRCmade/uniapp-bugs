======== README.md ========

# app 上的 createmapcontext 的方法失效

发送消息的部分:

operateMapWrap(this.id, this.pageId, 'getCenterLocation', options)

这个的参数应该是正常的

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250626142011693.png)

接收消息的部分:

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250627111758862.png)

这里出现了问题,本应该是 map.map 的方法,注册成为了 mapdefault.context 这个方法

这是由于腾讯地图的一次改动,将 map 命名为了 mapdefault

这个修改修复了: 6f3e1bb6eb8f76ab8204b94ffa12f072ddcee47a

fix(app): 修复地图组件的 createMapContext 相关方法调用失败的问题(ask/209825)

## 重要记录

在uniapp的通信中,有一部分是和webview 的通信

由 jsbridge 发起通信,到了 webview中,再由webview 返回到 js 的通信

这个过程中,代码过程中,会 regesiterViewMethod 在组件刚创建的时候,会注册方法

!! 同类问题排查的时候,可以现找到同类型的方法,再排查向上断点,找到失败的地方

======== END ========
