======== README.md ========

# 鸿蒙上 chooseMedia 返回 file 协议

## 说明

chooseMedia 从相册中,返回的 file 协议

chooseImage 从相册中
- 普通 返回 /data
- 原图 返回 file

核心: file转 data

```
const getSandbox = (imgUri: string , cacheDir:string): string =>{
    let fileName = new uri.URI(imgUri).getLastSegment();
    let file = fs.openSync(imgUri)
    let fileSandbox = cacheDir + '/' + fileName;
    try {
        fs.copyFileSync(file.fd, fileSandbox)
    } finally {
        fs.close(file)
    }
    return fileSandbox;
}
const useGetRealPath = (filepath: string): string =>{
    if (filepath.startsWith('/data/storage/')) return filepath;
    if (filepath.startsWith('file://')){
        const tempDirPath = `${getEnv__4().CACHE_PATH}/uni-media`;
        return getSandbox(filepath,tempDirPath)
    }
    return (runtimeGetRealPath(filepath) as string).replace(/^file:\/\/\//, '/');
};
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

======== END ========
