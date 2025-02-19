======== README.md ========

# 鸿蒙上的 measureText createCanvasContext 在执行几次页面跳转之后报错
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

index.vue

【switchtab】index3

【navigate】index2

之后再执行

```
const metrics = ctx.measureText("Hello World", (res) => {
	console.log("createATImg------------22---ctx.measureText", res);
});
```

napi_call_function 是华为的 nodeapi 的方法

```
14:05:00.445 Error: napi_call_function failed Error: webview 1 is not found.
14:05:00.445     at http://localhost/file5.js:25:29
14:05:00.445     at Object.invokeWebview (http://localhost/file5.js:131:56)
14:05:00.446     at Object.addEventListener (http://localhost/file5.js:64:22)
14:05:00.446     at wrapWebView (http://localhost/file5.js:111:15)
14:05:00.446     at Object.getLaunchWebview (http://localhost/file5.js:125:14)
14:05:00.446     at CanvasContext.measureText (http://localhost/file6.js:17601:54)
14:05:00.446     at Proxy.onCLick (app-service.js:586:29)
14:05:00.446     at app-service.js:598:86
14:05:00.446     at callWithErrorHandling (http://localhost/file6.js:3075:27)
14:05:00.446     at callWithAsyncErrorHandling (http://localhost/file6.js:3082:23)
```

# 问题

======== END ========