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
======== END ========