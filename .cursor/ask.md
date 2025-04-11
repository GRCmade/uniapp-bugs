我现在有一个问题,需要你来尝试给出一个可以复现的示例,该问题采用 uniapp 技术 vue3 版本,具体的问题描述如下:
---
运行app基座condition->list->query配置参数无法传递问题 #4375
Open
@sdynggg
Description
sdynggg
opened on Jun 9, 2023
"condition": { //模式配置，仅开发期间生效
"current": 0, //当前激活的模式(list 的索引项)
"list": [
{
"name": "", //模式名称
"path": "pages/order/orderList/index",
"query": "name=sd&zzz=xxx"
}
]
}
以上配置编译小程序在onLoad 参数options是可以拿到，运行安卓基座和ios基座onLoad options无法获取到参数。
麻烦问下不支持还是bug，或者哪里需要配置点啥才能运行？
---

在分析完成问题之后,需要按照如下工作流程进行操作:
1. 尝试在 /src/pages/index/index.vue 中给出示例复现该问题
2. 在 /README.md 中,对问题进行描述
3. 如果在问题描述中,涉及到了url或者运行平台等信息,把这部分添加到 /youtrack.json 中的 url 和 platforms
