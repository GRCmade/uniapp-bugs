======== README.md ========

# textarea 组件在APP端 iOS 模拟器中无法渲染，无法输入
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题
在编译时：textarea

这样就会卡住，不能输入

```
<textarea v-model="text">  
</textarea>
```

这样就可以

```
<textarea v-model="text"></textarea>
```

执行 add-next
======== END ========
