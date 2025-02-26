======== README.md ========

# 鸿蒙上downloadFile 下载文件的文件重命名
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题
downloadFile 这个接口没办法解析content-disposition里的文件名，用的是时间戳的文件名，后缀解析有误，那个正则应该是多了双引号，这个能否优先处理一下@scanf 
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250226200807309.png)


记录一个浏览器获取文件的地方：
- url 可以获取文件的名称和后缀
- contentDisposition 可以获取文件的后缀
- 服务器返回的 请求头中的 fileName 可以获取 文件名和后缀

======== END ========