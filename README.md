======== README.md ========

# 使用了 leftwindow 之后，在 h5 上，会出现语言变为英文
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

- npx @dcloudio/uvm@latest
- pnpm add @dcloudio/uni-mp-weixin@/Users/gaoruicheng/Documents/DcloudProject/uni-app-next/packages/uni-mp-weixin
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

======== END ========
