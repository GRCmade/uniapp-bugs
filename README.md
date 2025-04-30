======== README.md ========

# 微信小程序上,自定义组件的props不能直接传入函数

https://ask.dcloud.net.cn/question/70659

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250430100302478.png)

不建议使用 props 传递 function，建议统一使用事件机制实现类似功能

不同平台底层支持度不一样
微信小程序，支持 props 传递对象属性为 function（不能直接传递 function），
比如 :p="obj"，obj.fn = function(){}
但是百度，头条是不支持传递 function 的。


======== END ========
