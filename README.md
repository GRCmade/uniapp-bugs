======== README.md ======== 

# 鸿蒙平台上 makePhoneCall 添加权限后报错
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题
用户反馈，拨打电话的接口调用后，失效
权限修改不正确
在华为官网中： https://developer.huawei.com/consumer/cn/doc/harmonyos-references-V13/js-apis-call-V13#calldialdeprecated 
显示需要一个权限：ohos.permission.PLACE_CALL
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250208111508185.png)
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/undefined20250208113558853.png)
> @卢兵 这个有个问题，call.dial 拨打电话这个API，在文档上显示，需要一个权限：ohos.permission.PLACE_CALL，但是经过实际测试，不加这个权限是可以执行的，加上这个权限反而会报错无法添加该权限，这个是什么原因？看文档，这个call.dial 是废弃了吗，需要使用call.makeCall 吗？


但是这个权限经过实际的测试发现
- 加上权限之后，提示没有签名权限
- 不加权限，是正常执行

======== END ========


