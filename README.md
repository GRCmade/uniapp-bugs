======== README.md ========

# h5 上 showToast与showloading 会修改 option
```
const click = () => {
  const loadingOpts = { title: 'loading...' }
  uni.showLoading(loadingOpts)
  setTimeout(() => {
    uni.hideLoading()
    console.log(loadingOpts) // loadingOpts 对象已经被修改
    uni.showToast({ title: 'success' })
    setTimeout(() => {
      console.log(loadingOpts) // loadingOpts 对象已经被 showToast 方法修改

      // 这里会出现问题，loading 的提示内容会变成 'success' 而非 'loading...'
      uni.showLoading(loadingOpts)
    }, 2000)
  }, 2000)
}
```

在上面这段代码中,第二次执行的时候

执行showToast会修改showLoading的option中的 title


经过实际测试,在ios上,不存在更改的情况

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250408194545.png)

======== END ========
