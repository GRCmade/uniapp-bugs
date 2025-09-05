======== README.md ========

# 鸿蒙上支持 plus loadURL 和 webviewContext 的 loadUrl

sdk.js 上修改这个

```
controller ? controller.loadUrl(url,Object.entries(additionalHttpHeaders).map(([k, v]) => ({
  headerKey: k,
  headerValue: v
}))) : "";
```

pdr.js 中把 methods 中增加 loadURL
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250717194551888.png)


## 新增 APi 注意事项

新增一个API需要
与 颜总确认规范
在 synctax 中增加
在 uniapp 中增加 api
在 对应的 平台仓库中实现 api
======== END ========
