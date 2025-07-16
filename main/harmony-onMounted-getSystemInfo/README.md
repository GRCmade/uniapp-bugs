======== README.md ========

# 鸿蒙上 onMounted 中 调用 getSystemInfo 获取不准

主要的问题是: getSystemInfo 是在 sdk.js 中存在的问题

会获取 framenoe ,在这时,
页面上的 navbar 和 tababr 是 ets 创建的
但是这个地方还没有加载完全

因此 页面加载的时机有问题



======== END ========
