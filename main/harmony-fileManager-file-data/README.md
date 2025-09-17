======== README.md ========

# 鸿蒙上 chooseMedia 返回 file 协议

## 说明

chooseMedia 从相册中,返回的 file 协议

chooseImage 从相册中
- 普通 返回 /data
- 原图 返回 file

核心: file转 data

```
function getSandbox (fileUri: string): string {
  const tempDirPath = `${getEnv().CACHE_PATH}/uni-media`;
	if (!fs.accessSync(tempDirPath)) {
		fs.mkdirSync(tempDirPath, true);
	}
	let fileName = new uri.URI(fileUri).getLastSegment();
  let fileSandboxPath = tempDirPath + '/' + fileName;

	const fileSandBox = fs.openSync(fileSandboxPath, fs.OpenMode.CREATE | fs.OpenMode.READ_WRITE);
	const file = fs.openSync(fileUri);

	fs.copyFileSync(file.fd, fileSandBox.fd);
	fs.closeSync(file);
	return fileSandboxPath;
}

function useGetRealPath(filepath: string): string {
  if (filepath.startsWith('/data/storage/')) return filepath
  if (filepath.startsWith('file://') && !filepath.startsWith('file:///')) return getSandbox(filepath)
  return (runtimeGetRealPath(filepath) as string).replace(/^file:\/\/\//, '/')
}
```

## 内容
“file://”和“/data”在鸿蒙（HarmonyOS）中是两种不同的文件路径表示方式，它们的使用场景和含义有所不同。

file://

file:// 是一种URL方案，用于标识文件系统中的文件或目录。在鸿蒙系统中，当我们在应用中访问本地文件时，可以使用file://作为路径的开头，这通常用于表示从设备的根目录开始的绝对路径。例如，file:///data/local/tmp/myfile.txt 表示从设备根目录出发，前往data/local/tmp目录下的myfile.txt文件。
/data

/data 是Android和鸿蒙系统内部的一个重要目录，用于存储应用的数据和缓存。这个目录下的文件通常包含应用的配置信息、缓存数据或其他运行时需要的信息。在鸿蒙系统中，/data目录是应用数据的主要存储地点，可以通过环境变量或API调用等方式访问。
使用场景

file:// ：当我们需要在应用中访问一个具体的文件或目录，并且需要在网络上标识这个位置时，通常使用file://作为路径的开头。这在分享文件链接或在不同应用之间传递文件信息时非常有用。
/data ：当我们在开发过程中需要在设备上存储应用的数据或配置文件时，通常使用/data目录下的相应子目录。这是管理应用数据和缓存的常用方式。
通过了解这两种路径的差异和用途，我们可以更好地在鸿蒙应用开发中有效地管理和使用文件资源。



## new 问题 0917

E     [UniAppRuntime][17952] 10 <- napi_call_function(workData->context->napiEnv, nullptr, callback, workData->args.size(), retArg, &ret) at /Users/gaoruicheng/Documents/DcloudProject/runtime-harmony/UniAppRuntime/src/main/cpp/napi_init_t.cpp:671
E     [UniAppRuntime][17952] 3 <- napi_get_value_string_utf8(env, value, nullptr, 0, &size) at /Users/gaoruicheng/Documents/DcloudProject/runtime-harmony/UniAppRuntime/src/main/cpp/napi_init_t.hpp:450
E     [UniAppRuntime][17952] 3 <- napi_get_value_string_utf8(env, value, &resultStr[0], size + 1, &size) at /Users/gaoruicheng/Documents/DcloudProject/runtime-harmony/UniAppRuntime/src/main/cpp/napi_init_t.hpp:453
E     [UniAppRuntime][17952] NT:JSVMCallFunction run failed: napi_call_function failed
          at openSync (UniAppRuntime/src/main/ets/uni-app-harmony/uni.api.ets:6371:26)
          at _invokeStoreReference (UniAppRuntime/src/main/ets/uni-mp-sdk/sdk.js:887:1)
          at invokeStoreReference (UniAppRuntime/src/main/ets/uni-mp-sdk/sdk.js:897:1)
          at anonymous (UniAppRuntime/src/main/ets/uni-mp-sdk/sdk.js:1070:1)
          at anonymous (UniAppRuntime/src/main/ets/uni-mp-sdk/sdk.js:974:1)
I     Error: No such file or directory at pages/index/vue3.vue:85
I     App Hide at App.vue:10


这个 10 代表了 arkts 中抛错到了 jsvm 中



https://developer.huawei.com/consumer/cn/forum/topic/0204166811541385910?fid=0109140870620153026


copyFileSync 之前需要 openSync
======== END ========
