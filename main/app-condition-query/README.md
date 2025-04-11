======== README.md ========

# uniapp condition配置query参数在App基座中无法传递问题

## 问题描述

在uniapp开发中，manifest.json文件中可以配置condition模式，这个功能在开发期间可以快速进入指定页面并传递参数。问题是：这种方式配置的query参数在编译到小程序时可以正常通过onLoad的options获取到，但在运行Android和iOS基座时，onLoad的options无法获取到这些参数。

## 复现步骤

1. 在pages.json中配置了condition模式，指定了path和query参数：
```json
"condition": {
  "current": 0,
  "list": [
    {
      "name": "订单列表测试",
      "path": "pages/order/orderList/index",
      "query": "name=sd&zzz=xxx"
    }
  ]
}
```

2. 在首页提供了跳转按钮，可以通过代码方式跳转到订单列表页面，同时传递参数

3. 在订单列表页面，通过onLoad、defineProps和getCurrentPages()三种方式尝试获取参数

4. 测试不同平台：
   - 小程序：通过condition配置的参数可以正常获取到
   - Android/iOS基座：通过condition配置的参数无法获取到

## 预期行为

在所有平台（小程序、Android基座、iOS基座）都应该能够通过onLoad获取到在condition中配置的query参数。

## 实际行为

- 小程序：可以正常获取
- Android/iOS基座：无法获取到参数

## 解决方案

目前没有直接的解决方案，如需在App基座测试带参数的页面，建议使用如下方式：
1. 使用uni.navigateTo()方法进行页面跳转并传递参数
2. 在pages.json中不使用condition配置，改为直接修改启动页配置

======== END ========
