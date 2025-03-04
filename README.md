======== README.md ========

# i18n传入第二个参数在APP中不生效
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题

使用国际化进行操作，`$t 的第二个参数`在不同平台效果不同

```
<template>
	<view>
		<view>1个参数： {{$t('global.pleaseInput')}}</view>
		<view>2个参数： {{$t('global.pleaseInput', { key: $t('login.tenantName') })}}</view>
	</view>
</template>
```

## vue2
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250304175440777.png)
对比安卓和h5
有参数的时候正常，无参数的时候，还是会显示参数内容

## vue3
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250304175640447.png)
安卓都不正常
h5 的时候，带参数，是正常的
======== END ========