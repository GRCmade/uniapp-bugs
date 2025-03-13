======== README.md ========

# uniapp 的 jsx 不生效
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

- npx @dcloudio/uvm@latest
- pnpm add @dcloudio/uni-mp-weixin@/Users/gaoruicheng/Documents/DcloudProject/uni-app-next/packages/uni-mp-weixin

# 问题
一个 jsx 的示例

```
import com from '../../components/com/com.vue'
import uniBadge from '@dcloudio/uni-ui/lib/uni-badge/uni-badge.vue'

function render() {
  return (<view>jsx <com></com> <uniBadge text="1"></uniBadge></view>)
}

export default render

```

======== END ========
