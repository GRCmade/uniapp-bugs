======== README.md ========

# h5 的 uploadFile files = [] 时，还是会发送文件
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

链接 next 仓库

# 问题

```
const result = await uni.uploadFile({
  url: 'http://192.168.3.1:3000/uploadfile',
  files: [],
  name: 'file',
  formData: {
    'user': 'test'
  },
});
```

主要的内容： `files: []`

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250331194512.png)

还是会上传一个文件

后端会接收一个 html 文件

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250331194617.png)

原因是，在代码中，这个是 undefined

在代码中，会拼接成为 :` http://localhost:5173/undefined#/`

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250331194743.png)

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250331194644.png)

======== END ========
