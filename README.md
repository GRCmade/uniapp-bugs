======== README.md ========

# 鸿蒙平台上支持 uniapp 打开 小程序 sdk

https://nativesupport.dcloud.net.cn/UniMPDocs/UniappHost/unimpapi.html#%E5%AE%BF%E4%B8%BBapp%E4%B8%AD%E4%BD%BF%E7%94%A8%E7%9A%84api


加入了在 app 上支持 uniapp 打开小程序

uniapp-hbuilderx 是宿主
vue3 是小程序

## 调试问题

E     [UniAppRuntime][15260] 9 <- OH_JSVM_OpenInspector(runtime->env, "localhost", 9225) at /Users/gaoruicheng/Documents/DcloudProject/runtime-harmony/UniAppRuntime/src/main/cpp/napi_init_t.cpp:398

uniapp 本身有一个jsvm ，在 新调研 openUnimp 之后新开一个，就报错了

当前 jsvm 中打开调试端口，9225


======== END ========
