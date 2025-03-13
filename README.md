======== README.md ========

# uni.hideHomeButton() 在 h5 上无法使用，但是 canIuse 为 true
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

- npx @dcloudio/uvm@latest
- pnpm add @dcloudio/uni-mp-weixin@/Users/gaoruicheng/Documents/DcloudProject/uni-app-next/packages/uni-mp-weixin
- pnpm add pnpm add @dcloudio/uni-h5@/Users/gaoruicheng/Documents/DcloudProject/uni-app-next/packages/uni-h5

# 问题
uni.hideHomeButton()  在文档中的描述是 h5 不支持
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250313162955138.png)
但是在调用` uni.canIUse('hideHomeButton') ` 时，显示为 true
在真正调用的时候，会报错
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250313163105421.png)
======== END ========
