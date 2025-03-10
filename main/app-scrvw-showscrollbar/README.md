不要动标记 `======== README.md ========` 和 `======== END ========`
这部分内容，会同步到 issue 系统中

======== README.md ========

# scroll-view组件代码中的 show-scrollbar 默认值和文档默认值不一致
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题


```vue
	<view>
	<view class="uni-padding-wrap uni-common-mt">
		<view class="uni-title uni-common-mt"> Vertical Scroll <text>\n纵向滚动</text>
		</view>
		<scroll-view :scroll-top="scrollTop" scroll-y="true" class="scroll-Y" @scrolltoupper="upper"
			@scrolltolower="lower" @scroll="scroll" :show-scrollbar="false">
			<view id="demo1" class="scroll-view-item uni-bg-red">A</view>
			<view id="demo2" class="scroll-view-item uni-bg-green">B</view>
			<view id="demo3" class="scroll-view-item uni-bg-blue">C</view>
		</scroll-view>
	</view>
</view>
```

经过测试，show-scrollbar 的默认值是 true

但是文档上写的是 false

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250310144139701.png)

======== END ========