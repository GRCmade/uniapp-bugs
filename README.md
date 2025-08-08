======== README.md ========

# 鸿蒙平台的 overrides 只能在根目录的 oh-packages 生效

在一些 三方har 包中，引入的时候，会配置从ohpm中引入的格式
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250808111010282.png)

但是，它又没有提供ohpm仓库的下载方式

因此，三方包会提示需要在 oh-package 中配置 overrides 来覆盖此配置

但是在 uts 插件中，插件 oh-package 不是根目录的
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250808111225896.png)

非 根目录的 oh-package 不能使用 overrides ，会报错：
`ohpm WARN: Only project-level "overrides" is supported. "overrides" configured at "/Users/gaoruicheng/Documents/MyProject/uniapp-bugs/uniapp-bugs-now-cli/uniapp-hbuilderx/unpackage/dist/dev/app-harmony/uni_modules/harmony-button/oh-package.json5" will be ignored.`

非根目录的，会被覆盖。

因此需要在根目录中配置 overrides

## 解决方式

在 harmony-configs 下创建 oh-package （oh-package 源文件可以在 unpackage/dist/dev/app-harmony 中找到源文件，把这个文件复制到harmony-configs 中）

在这个文件中 添加 overrides , 路径需要指向 uni_modules 中的文件
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250808112438075.png)

======== END ========
