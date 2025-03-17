======== README.md ========

# uni.getNetworkType() 的执行顺序是同步的
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

链接 next 仓库

# 问题

```
console.log("1. 调用前");  
uni.getNetworkType({  
  success: () => {  
    console.log("3. success回调");  
  }  
});  
console.log("2. 调用后");
```

执行的结果:
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250317195629486.png)

======== END ========
