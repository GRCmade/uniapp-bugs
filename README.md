======== README.md ========

# 支付宝小程序上 offNetworkStatusChange 无法使用

offNetworkStatusChange

uniapp-hbuilderx

问题原因:

在 next 仓库中, onNetworkStatusChange 在执行的时候,会 在 protocol 中,修改 linstener

在 processCallback 返回了一个新的 function

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250627171619520.png)

因为参数数值需要匹配

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250627171453691.png)

之后,由于这个listener 修改了, offNetworkStatusChange 无法直接使用

======== END ========
