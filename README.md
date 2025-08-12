======== README.md ========

# uni.uploadFile在安卓平台，触发success后会再触发一次onProgressUpdate事件
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题
触发了一次 100 加载完成
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250303113811077.png)

但是在输出success的res之后，还是会触发一次100

ios 上效果相同


======== END ========
