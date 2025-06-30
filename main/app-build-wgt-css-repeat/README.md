======== README.md ========

# app 平台上打包的本地资源(wgt)的时候没有抽出 css 公共样式

在 uniapp-hbuilderx 上点击打包本地资源

有三个页面,每个页面上都有一个: uniui 组件
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250630175448286.png)

生成打包资源之后,会生成多个 css 文件
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250630180151000.png)

这个 css 文件中存在一个问题: 有多个重复样式,现在是每个页面都会包含所有引用的 css样式

这个是 index.css 和 index2.css 样式
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250630180259459.png)

每个页面中所有的样式都会重复打包出来

======== END ========
