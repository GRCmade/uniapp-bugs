======== README.md ========

# 鸿蒙上支持 plus loadURL

sdk.js 上修改这个

```
controller ? controller.loadUrl(url,Object.entries(additionalHttpHeaders).map(([k, v]) => ({
  headerKey: k,
  headerValue: v
}))) : "";
```

pdr.js 中把 methods 中增加 loadURL
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250717194551888.png)

======== END ========
