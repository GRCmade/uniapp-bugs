======== README.md ========

# uni.request GET请求参数重复未去重测试

## 问题描述
在鸿蒙上 uni.request方法get请求的时候参数填写重复的话没有去重，在安卓上测试了是去重的，麻烦优化一下

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250708111436524.png)

安卓和 鸿蒙上的请求对比:
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250708145525072.png)

鸿蒙上的请求参数,如果有完全重复的,不会去重,会加入到请求参数中
======== END ========
