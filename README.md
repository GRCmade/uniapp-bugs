======== README.md ========

# 鸿蒙平台的上 createWebviewContext 的 evalJS 在 setup 中执行不成功
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题

选项式的代码是正常的
```
click() {
	const res = uni.createWebviewContext('webviewid',this)
	let str = 'console.table("webview-yuhe")'
	res.evalJS(str)
},
```

改成setup就失败了
```
<template>
	<view>
		<button @click="click">click</button>
		<web-view style="margin-top: 200rpx;height: 200px;" id="webviewid" src="https://www.baidu.com"></web-view>
	</view>
</template>

<script setup>
import { getCurrentInstance } from 'vue'

	const click = () => {
		const instance = getCurrentInstance()
		const res = uni.createWebviewContext('webviewid',instance)
		let str = 'console.table("webview-yuhe")'
		res.evalJS(str)
	}
</script>


<style></style>
```


![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/undefined20250219165118494.png)
```
16:49:33.061 TypeError: Cannot read properties of null (reading '$page')
16:49:33.061     at getPageIdByVm (http://localhost/file6.js:16153:12)
16:49:33.062     at Object.createWebviewContext (http://localhost/file6.js:20947:20)
16:49:33.062     at click (app-service.js:575:25)
16:49:33.062     at callWithErrorHandling (http://localhost/file6.js:3075:21)
16:49:33.062     at callWithAsyncErrorHandling (http://localhost/file6.js:3082:17)
16:49:33.062     at UniElement.invoker (http://localhost/file6.js:10439:7)
16:49:33.062     at UniElement.dispatchEvent (http://localhost/file6.js:841:22)
16:49:33.062     at UniPageNode.fireEvent (http://localhost/file6.js:20080:14)
16:49:33.062     at onNodeEvent (http://localhost/file6.js:21109:16)
16:49:33.062     at http://localhost/file6.js:21124:11

```
======== END ========