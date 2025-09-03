======== README.md ========

# 鸿蒙 textarea 中设置 showConfirmBar 造成

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250903151335218.png)

会报错
```
I     Uncaught TypeError: currentWebview.setStyle is not a function
I     [CONSOLE:14622] "Uncaught TypeError: currentWebview.setStyle is not a function", source: file:///data/storage/el1/bundle/entry/resources/resfile/apps/HBuilder/www/uni-app-view.umd.js (14622)
W     adjustResize is deprecated.
```

导致了 webview 之后的逻辑不执行了

导致页面还是会推到上方

======== END ========
