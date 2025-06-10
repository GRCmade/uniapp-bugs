======== README.md ========

# 鸿蒙上 uni 小程序 sdk previewImage 第二次打开不显示

之前的实现是自定义弹窗,鸿蒙已经不推荐了:https://developer.huawei.com/consumer/cn/doc/harmonyos-guides/arkts-common-components-custom-dialog

现在需要改造为 == promptAction.openCustomDialog == :https://developer.huawei.com/consumer/cn/doc/harmonyos-references/js-apis-promptaction#promptactionopencustomdialog11

实现参考的文章: https://developer.huawei.com/consumer/cn/doc/harmonyos-guides/arkts-uicontext-custom-dialog

@Builder是一个函数:https://developer.huawei.com/consumer/cn/doc/harmonyos-guides/arkts-builder


发现非当前的问题:
- 传入 urls 不生效
- 传入 currrnet 的类型有问题(报错: previewImage: Invalid args: type check failed for args "current". Expected String with value "1", got Number with value 1.)
- 保存图片的时候会弹出去
- 长按不生效了
- 保存图片之后,showActionMenu的点击index都是 0 了 (传函数那种写法不生效 , 使用 .then 好了)


这个问题已经修复了，previewImage在之前使用的是这个：https://developer.huawei.com/consumer/cn/doc/harmonyos-guides/arkts-common-components-custom-dialog ， 现在更改了实现的方式，使用了：https://developer.huawei.com/consumer/cn/doc/harmonyos-guides/arkts-uicontext-custom-dialog 。 你可以替换文件测试一下

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250610165537673.png)

======== END ========

