======== README.md ========

# this.$emit('click') 在 h5 上会触发 2 次
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题

在一个组件中，this.$emit('click');

$emit('click');事件

在h5上，会触发2次，在微信小程序上会触发1次

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/undefined20250220172252681.png)

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/undefined20250220172305132.png)

======== END ========