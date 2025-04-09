======== README.md ========

# 微信小程序上,自定义组件加入事件修饰符@click.stop不生效

在微信小程序上,点击自定义组件之后,冒泡事件不会阻止
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250409113509.png)

在其它h5,app上,都可以阻止
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250409113623.png)

经过测试,vue2和vu3上的区别
这个问题是,在vue2上的小程序中,自定义组件的点击事件,[需要加入@click.native才可以生效](https://uniapp.dcloud.net.cn/tutorial/vue-components.html#%E5%B0%86%E5%8E%9F%E7%94%9F%E4%BA%8B%E4%BB%B6%E7%BB%91%E5%AE%9A%E5%88%B0%E7%BB%84%E4%BB%B6)
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250409115208.png)
也就是在vue2上,使用 @click.native.stop 能够阻止默认事件
这个是vue2项目,可以阻止默认事件
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250409115320.png)

----

但是在 vue3 上,这样不会生效,也就是@click.native不生效


======== END ========
