======== README.md ========

# web 平台上, onUnmounted 会受 swiper 组件影响,不执行了

操作介绍: 第一个按钮是 redirectTo 到二级页面,点击之后,再从第二个页面回到第一个页面
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250416162711.png)
正常的执行情况是这样: index 先执行 onUnmounted , second 再执行 onUnmounted

但是,在加入 swiper 之后
second 页面执行了 onDeactivated 而没有执行 onUnmounted
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250416162935.png)

核心问题: 加入 swiper 之后, onUnmounted 这个声明周期在 redirectTo 的 second 页面就不执行了
======== END ========
