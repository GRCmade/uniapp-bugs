======== README.md ========

# app 平台上,组件 movable-area style的变化导致了页面响应式数据失效

在这里有一个这样的结构:
一个 com 组件和 一个text的结构,通过 v-if 来展示不同的结果
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250701155827523.png)

正常情况下,点击下一提之后,index++就会切换组件,就会显示组件 2
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250701155909207.png)
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250701155942453.png)

但是在 com 组件中,给 movable-area 的 height 发生变化之后,就会产生响应式数据不更新的问题
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250701160035693.png)
点击下一题:
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250701160121477.png)
响应式数据失效,并且组件消失
之后再点击第一题之后,响应式数据也不能够更新
======== END ========
