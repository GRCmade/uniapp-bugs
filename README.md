======== README.md ========

# 鸿蒙平台上，picker 设置为 date 会出现年份只能选择 1970 的情况
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题


```vue
<picker mode="date" fields="year" >
	<view class="uni-input">{{date}}</view>
</picker>
```

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/undefined20250210110914609.png)

这样获取到的日志是：
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/undefined20250210112532050.png)

问题出现在这个差异：
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/undefined20250210113454461.png)

在源码中，如果传递是数字，就会把日期变为 1970
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/undefined20250210113743639.png)



======== END ========