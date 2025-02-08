======== README.md ========

# 快手 ref 问题 hbuilderx 测试项目
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题
# 
```vue
<script setup lang="ts">
import { ref } from 'vue'
import SomeTest from './some-test.vue'
import HighTest from './high-test.vue'

const someText = ref('我是父组件内的内容！')

const someRef = ref(null)
const testRef = ref(null)

const onButton = () => {
  console.log('---czm someRef =', someRef.value)    // 这里打印一直是 null
  someRef.value?.open()
  console.log('----czm testRef = ', testRef.value)  // 可以正常获取到组件
  testRef.value?.open()
}

</script>
```

```vue
<script>
import SomeTest from './some-test.vue'
import HighTest from './high-test.vue'

export default {
  components: {
    SomeTest,
    HighTest
  },
  data() {
    return {
      someText: '我是父组件内的内容！',
    }
  },
  mounted() {
    console.log('组件已挂载')
  },
  methods: {
    onButton() {
      console.log('---czm someRef =', this.$refs.someRef)    // 这里打印一直是 null
      this.$refs.someRef.open() // 由于 TypeScript 可能会报错，使用 `as any` 断言
      console.log('----czm testRef = ', this.$refs.testRef)  // 可以正常获取到组件
      this.$refs.testRef.open()
    }
  }
}
</script>
```
======== END ========