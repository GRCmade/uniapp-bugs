======== README.md ========

# 支付宝小程序上 setup 语法的getCurrentPages的 $vm.$refs 获取不到
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题

```javascript
	import { ref } from 'vue';
const ModalRef = ref(null)
const click = () => {
	console.log("ModalRef", ModalRef.value)
	ModalRef.value.comaconsole()
	var pages = getCurrentPages();
	var page = pages[pages.length - 1];
	console.log('当前页面', page.$vm.$refs);
}
```

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250225180509984.png)

======== END ========