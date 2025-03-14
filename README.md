======== README.md ========

# h5 嵌套 iframe 和 页面上 createIntersectionObserver 的触发时机不同
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

链接 next 仓库

# 问题

代码由两个页面构成，第一个页面有个 webview ,webview 中是第二个页面
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250314195805721.png)
在这个页面，触发的时机，需要红色长方形完全消失，并且向下一段距离，才会触发

第二个页面是uniapp 页面，也就是第一个页面中的 webview 页面
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250314195908394.png)
在这个页面，触发的时机，就是红色长方形刚消失就会触发

======== END ========
