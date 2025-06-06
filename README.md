======== README.md ========

# 华为卢冰问题 0606

1、页面跳转需要获取上个页面传递过来的参数，有个方法getCurrentPages()，获取最后一个page然后发现options是undefined，需要确认下这个在鸿蒙平台是不是要加上去

使用如下代码:
```
let pages = getCurrentPages()
console.log(pages[pages.length - 1].options)
```
harmony上:
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250606152153434.png)
web 上:
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250606152202354.png)

确认harmony上为undefined,但是安卓上也是undefined
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250606154303786.png)

2、uni-swipe-action编译成h5，在鸿蒙手机的浏览器上滑动不了，直接转应用是可以滑动的

在手机浏览器上打开这个,能滑动: https://uniapp.dcloud.net.cn/component/uniui/uni-swipe-action.html

3、web-view在onLoad生命周期设置this.src=xxxx，如果前面加了一个await xx()，会导致scr设置不上去

已确认问题

4、uniapp官网嵌入鸿蒙原生组件的例子有些问题，@click回调拿不到原生组件传过来的参数

这个是文档的示例有问题,功能是正常的,示例运行需要修改两个地方:
- embed 上的 @click 改为 @buttonclick
- ets 组件中的 ButtonBuilder 中的 get('click') 改为 get('buttonclick')

======== END ========
