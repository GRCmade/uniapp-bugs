======== README.md ========

# 鸿蒙上 image 组件不能加载临时路径
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题

问题是临时地址，不能显示在页面上
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/undefined20250214110652697.png)

出错的位置：
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/undefined20250214165413608.png)
onLoadIntercept部分代码，都注释了就可以了

可能的原因是：setPathAllowingUniversalAccess
https://developer.huawei.com/consumer/cn/doc/harmonyos-references-V13/js-apis-webview-V13#setpathallowinguniversalaccess12
======== END ========