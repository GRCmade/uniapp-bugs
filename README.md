======== README.md ========

# 鸿蒙平台 request 的内存泄露

请求一个 60mb 左右的 json 数组数据,会触发多次的

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20251104194943505.png)

日志:

11-04 16:25:21.390 20435 20435 I C03f00/ArkCompiler: [gc] /****************** GC Memory statistic: *****************/
11-04 16:25:21.390 20435 20435 I C03f00/ArkCompiler: [gc] AllSpaces        used:  478125KB     committed:  488448KB
11-04 16:25:21.390 20435 20435 I C03f00/ArkCompiler: ActiveSemiSpace  used:       0KB     committed:     256KB
11-04 16:25:21.390 20435 20435 I C03f00/ArkCompiler: OldSpace         used:  460699KB     committed:  469248KB
11-04 16:25:21.390 20435 20435 I C03f00/ArkCompiler: HugeObjectSpace  used:   10240KB     committed:   10240KB
11-04 16:25:21.390 20435 20435 I C03f00/ArkCompiler: NonMovableSpace  used: 1258.41KB     committed:    2560KB
11-04 16:25:21.390 20435 20435 I C03f00/ArkCompiler: AppSpawnSpace    used: 5671.73KB     committed:    5888KB
11-04 16:25:21.390 20435 20435 I C03f00/ArkCompiler: [gc] Anno memory usage size:  477     MB
11-04 16:25:21.390 20435 20435 I C03f00/ArkCompiler: Native memory usage size:68.8692 MB
11-04 16:25:21.390 20435 20435 I C03f00/ArkCompiler: NativeBindingSize:       63162.1 KB
11-04 16:25:21.390 20435 20435 I C03f00/ArkCompiler: NativeLimitSize:         201072  KB
11-04 16:25:21.390 20435 20435 I C03f00/ArkCompiler: ArrayBufferNativeSize:   63161   KB
11-04 16:25:21.390 20435 20435 I C03f00/ArkCompiler: ChunkNativeSize:         72      KB
11-04 16:25:21.390 20435 20435 I C03f00/ArkCompiler: [gc] Heap alive rate:         1.14722
11-04 16:25:21.390 20435 20435 E C03f00/ArkCompiler: [gc] ThrowOutOfMemoryError:1525 OutOfMemory when trying to allocate 480509952 bytes function name:  OldSpace::Merge
11-04 16:25:21.392 20435 20435 E C01317/AppKit: [main_thread.cpp:2013]
11-04 16:25:21.392 20435 20435 E C01317/AppKit: com.example.test.template is about to exit due to RuntimeError
11-04 16:25:21.392 20435 20435 E C01317/AppKit: Error type:OutOfMemoryError
11-04 16:25:21.392 20435 20435 E C01317/AppKit: Error name:OutOfMemoryError
11-04 16:25:21.392 20435 20435 E C01317/AppKit: Error message:OutOfMemory when trying to allocate 480509952 bytes function name:  OldSpace::Merge
11-04 16:25:21.392 20435 20435 E C01317/AppKit: Stacktrace:
11-04 16:25:21.392 20435 20435 E C01317/AppKit:     at anonymous @dcloudio/uni-app-runtime (UniAppRuntime/src/main/ets/uni-mp-sdk/sdk.js:4792:17)
11-04 16:25:21.392 20435 20435 E C01317/AppKit:     at anonymous @dcloudio/uni-app-runtime (UniAppRuntime/src/main/ets/uni-mp-sdk/sdk.js:4887:21)
11-04 16:25:21.392 20435 20435 E C01317/AppKit:     at invokeCallback @dcloudio/uni-app-runtime (UniAppRuntime/src/main/ets/uni-mp-sdk/sdk.js:4815:19)
11-04 16:25:21.392 20435 20435 E C01317/AppKit:     at invokeSuccess @dcloudio/uni-app-runtime (UniAppRuntime/src/main/ets/uni-mp-sdk/sdk.js:5042:10)
11-04 16:25:21.392 20435 20435 E C01317/AppKit:     at resolve @dcloudio/uni-app-runtime (UniAppRuntime/src/main/ets/uni-mp-sdk/sdk.js:5130:25)
11-04 16:25:21.392 20435 20435 E C01317/AppKit:     at anonymous @dcloudio/uni-app-runtime (UniAppRuntime/src/main/ets/uni-app-harmony/uni.api.ets:10393:22)
11-04 16:25:21.393 20435 20435 W C01317/AppKit: [main_thread.cpp:2024]hisysevent write result=0, send event [FRAMEWORK,PROCESS_KILL], pid=20435, processName=com.example.test.template, msg=Kill Reason:Js Error, foreground=1, isUncatchable=1


原因:

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20251104195048602.png)

https://developer.huawei.com/consumer/cn/doc/harmonyos-guides/gc-introduction#%E7%9B%B8%E5%85%B3%E5%8F%82%E6%95%B0

GC 回收中 old space 片区由于手机设备上限 350MB , 在请求数据之后,jsvm 中会遍历数组,导致了无法垃圾过多超过了限制,崩溃

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20251104195347912.png)


临时解决:

把 dataType 设为 string 之后在 uniapp 中json.parse 转一下

======== END ========
