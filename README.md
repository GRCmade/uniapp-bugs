======== README.md ========

# 鸿蒙 image 组件加载临时路径在页面刚加载的时候存在问题

在页面刚加载的时候 onready , data 中赋值,就不会生效

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250508151306593.png)

但是经过 button 点击之后 , 就会生效 , 或者说延迟一会赋值 , 就正常了

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250508151349111.png)

经过反馈 45 正常 45 之后失效了

======== END ========
