======== README.md ========

# 使用了 leftwindow 之后，在 h5 上，会出现语言变为英文
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

- npx @dcloudio/uvm@latest
- pnpm add @dcloudio/uni-mp-weixin@/Users/gaoruicheng/Documents/DcloudProject/uni-app-next/packages/uni-mp-weixin
- pnpm add @dcloudio/uni-h5@/Users/gaoruicheng/Documents/DcloudProject/uni-app-next/packages/uni-h5
# 问题
以 uni-search-bar 为例
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250303161102096.png)

这个组件在初始化的时候，使用了

```
import {
  initVueI18n
} from '@dcloudio/uni-i18n'
import messages from './i18n/index.js'
const {
  t
} = initVueI18n(messages)
```

在这个地方，使用了 initVueI18n ，之后，就会变成英文

经过实际测试，只要引入了leftWindow ，不管使用还是不使用，都会产生这个问题


## 用户反馈
```
经过调试，发现原因为在left/top/rightWindow优先main初始化，uni-search-bar使用initVueI18n(messages)初始化i18n
@dcloudio/uni-i18n中会走到getDefaultLocale，然后在当前环境中uni和global都是未定义，直接return LOCALE_EN了
根本原因还是此时读取不到uni变量，由此可以判断除了i18n，可能还会有其他相关问题
该问题会导致共用组件在main中也会表现出一样的问题，因为初始化代码只会执行一次，比如uni-search-bar虽然在window和main中都使用了，但是由于语言代码在初始化阶段就已经调用完了，后续是复用，所以在main中也会显示为英文
```
======== END ========
