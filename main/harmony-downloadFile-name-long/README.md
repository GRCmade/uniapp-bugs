======== README.md ========

# 鸿蒙上openDocument会报错:File name too long

在使用它下载的时候文件的时候

https://www.ccfund.com.cn/main/files/2025/03/28/长城全球新能源汽车股票型发起式证券投资基金（QDII-LOF）基金产品资料概要更新.pdf

这个文件,打开的时候,会报错:

Error message:File name too long

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250507103726469.png)

对应的华为文档: https://developer.huawei.com/consumer/cn/doc/harmonyos-references/errorcode-filemanagement#%E5%9F%BA%E7%A1%80%E6%96%87%E4%BB%B6io%E9%94%99%E8%AF%AF%E7%A0%81


uni-app-ts
api/uni-network/utssdk/app-harmony/network/downloadFile.uts.ts

在这之前,使用的是 URL 参数
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250507114918018.png)

新加一个:decodeURIComponent![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250507114954233.png)

这个转成中文

======== END ========
