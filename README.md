# uni-app 开发工具脚本

这个仓库包含了用于 uni-app 开发的辅助脚本，可以在不同设备上运行。

## 多设备使用指南

为了让脚本在不同设备上正常工作，我们使用了本地配置文件机制：

1. 复制 `local-config.example.js` 文件，并重命名为 `local-config.js`
2. 根据你的设备环境，修改 `local-config.js` 中的路径配置
3. 本地配置文件已被添加到 .gitignore（如果使用git），确保不会被提交到仓库

### Windows 用户注意事项

对于 Windows 用户，请确保使用双反斜杠或正斜杠来指定路径，例如：

```js
{
  next: "C:\\Users\\YourName\\Documents\\uni-app-next",
  // 或者
  next: "C:/Users/YourName/Documents/uni-app-next",
}
```

## 使用方法

运行小程序构建脚本：

```bash
node uni-app/mp.js 3 weixin  # Vue 3 版本的微信小程序
node uni-app/mp.js 2 weixin  # Vue 2 版本的微信小程序
```

参数说明：
- 第一个参数：Vue 版本（2 或 3）
- 第二个参数：小程序平台（weixin、kuaishou、toutiao、alipay、xhs）