======== README.md ========

# const styles = ref<Style[]>([]); 在 uniapp上编译错误

这段代码,在 uniapp 上存在编译问题

```
<script lang="ts" setup>
import { ref } from 'vue'
type Style = {
	name:string
}
const styles = ref<Style[]>([]);
const click = () => {
  console.log(styles.value)
}
</script>
```

会多一个 scoped

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/20250417200857.png)


======== END ========
