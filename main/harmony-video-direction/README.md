======== README.md ========

# 鸿蒙平台上video组件全屏

当前的video组件不能全屏是一个问题

当前通过在 webbuilder 中通过 arkts web 组件的 onFullScreenEnter和 onFullScreenExit 属性可以暂时实现横屏的效果

但是要注意：需要隐藏部分的页面内容
- tabbar
- 顶部导航栏
- 下方的安全区域

```
// 改变设备横竖屏状态函数
function  changeOrientation(isLandscape: boolean) {
  // 获取UIAbility实例的上下文信息
  let context: common.UIAbilityContext = getContext() as common.UIAbilityContext;
  // 调用该接口手动改变设备横竖屏状态
  window.getLastWindow(context).then((lastWindow) => {
    lastWindow.setPreferredOrientation(isLandscape ? window.Orientation.LANDSCAPE : window.Orientation.PORTRAIT)
  });
}

let handler:FullScreenExitHandler|null = null

export function showFullScreen(event:FullScreenEnterEvent){
  const webview = getCurrentWebview()
  if(webview){
    webview.pageState.isfullScreen = true
  }
  handler = event.handler
  let tabbar = getTabBar()
  if(tabbar){
    tabbar.hideTabBar()
  }
  let videoWidth = event.videoWidth ?? 0
  let videoHeight = event.videoHeight ?? 0
  if (videoWidth>0 && videoHeight>0 && videoWidth > videoHeight) {
    changeOrientation(true);
  }
}

export function hideFullScreen(){
  const webview = getCurrentWebview()
  if(webview && webview.pageState.isfullScreen){
    webview.pageState.isfullScreen = false
  }else{
    return
  }
  let tabbar = getTabBar()
  if(tabbar){
    tabbar.showTabBar()
  }
  if (handler) {
    handler.exitFullScreen()
    changeOrientation(false);
  }
}
```

## 当前存在的问题

当前的web组件，使用的是在web内部的展示方式，目前的实现只能够实现旋转，但是不能指定90度和-90度
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250815200054847.png)

当前想法是：看看能不能继承这个video进行一下重写
======== END ========
