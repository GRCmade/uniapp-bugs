======== README.md ========

# 京东小程序上 plugins 与 input 相互冲突

在源代码中，使用到了修改 Object.getPrototypeOf 的方法

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250806144326247.png)

此方法若是去掉，会影响 input 的 @change 的方法

但是，若是在 manifest 中配置 plugins


======== END ========
