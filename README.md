======== README.md ========

# Vue3版本dom变化导致事件回调错乱 
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题

快速点击正常应该触发CB2 事件

但是会突然出现CB3 事件
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250225195215490.png)

产生的原因：存在一个dom更新的函数导致的

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250225195226861.png)

======== END ========