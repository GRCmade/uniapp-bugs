======== README.md ========

# Uniapp 的鸿蒙 next 应用中隐藏和显示系统状态栏
> 本示例至少需要在 HbuilderX 4.61 运行

在 uniapp 开发鸿蒙应用中,通过 UTS 插件,可以调用许多系统原生的 API,这里给出一个小功能:隐藏和显示系统状态栏

原始的界面效果:
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250618191338034.png)

隐藏系统状态栏之后的效果:
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250618191403171.png)

这个示例的参考文档有:
- 鸿蒙官方文档: https://developer.huawei.com/consumer/cn/doc/harmonyos-faqs/faqs-arkui-193
- UTS 插件: https://doc.dcloud.net.cn/uni-app-x/plugin/uts-plugin.html
- UTSHarmony 的使用: https://doc.dcloud.net.cn/uni-app-x/uts/utsharmony.html

核心页面代码:
```
<template>
	<view>
		<button @click="show">显示原生状态栏</button>
		<button @click="hide">隐藏原生状态栏</button>
	</view>
</template>
<script>
	import { showStatusBar, hideStatusBar } from '@/uni_modules/harmony-statusbar';
	export default {
		data() {
			return {
				message: 'Hello, World!'
			}
		},
		methods: {
			show() {
				showStatusBar()
			},
			hide() {
				hideStatusBar()
			}
		}
	}
</script>
<style scoped>
</style>
```

核心UTS插件代码:
```
import window from '@ohos.window';

let _window : window.Window;

UTSHarmony.onAppAbilityWindowStageCreate((windowStage : window.WindowStage) => {
	_window = windowStage.getMainWindowSync()
})

export const hideStatusBar = () => {
	_window.setWindowSystemBarEnable([])
}


export const showStatusBar = () => {
	_window.setWindowSystemBarEnable(['status', 'navigation'])
}
```

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/uniapp-hbuilderx.zip)
======== END ========
