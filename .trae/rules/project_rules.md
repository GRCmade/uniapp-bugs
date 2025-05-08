# uni-app Bug 复现工作流程

本项目设计用于复现 uni-app 框架中的 bug。以下是使用此项目进行 bug 复现的标准工作流。

## Bug 复现步骤

1. 根据 bug 的具体情况，选择在 Vue2 或 Vue3 子项目中进行复现
2. 通过 `npm run git-new-branch` 创建一个新的分支来跟踪此 bug（分支名在项目根目录的 `youtrack.json` 文件中配置，对应 `branch` 字段）
3. 在选定的项目中实现最小复现示例,最小复现示例要求:vue3 在 [index.vue](mdc:vue3/src/pages/index/index.vue) , vue2 在 [index.vue](mdc:vue2/src/pages/index/index.vue) , 如果一个页面无法复现,再新建文件
4. 测试复现结果
5. 提交代码并推送到远程分支

## Vue2 项目结构说明

Vue2 项目使用 Vue CLI 构建，关键目录和文件:

- 页面文件夹: [vue2/src/pages](mdc:vue2/src/pages)
- 组件文件夹: [vue2/src/components](mdc:vue2/src/components)
- 样式设置: [vue2/src/uni.scss](mdc:vue2/src/uni.scss)
- 构建配置: [vue2/vue.config.js](mdc:vue2/vue.config.js)

## Vue3 项目结构说明

Vue3 项目使用 Vite 构建，关键目录和文件:

- 页面文件夹: [vue3/src/pages](mdc:vue3/src/pages)
- 组件文件夹: [vue3/src/components](mdc:vue3/src/components)
- 类型定义: [vue3/src/types](mdc:vue3/src/types)
- 工具函数: [vue3/src/utils](mdc:vue3/src/utils)
- 构建配置: [vue3/vite.config.ts](mdc:vue3/vite.config.ts)

## 跨平台测试

根据 bug 涉及的平台，可以使用各项目中的脚本进行不同平台的构建测试:

### Vue2 平台测试命令

- H5: `cd vue2 && npm run dev:h5`
- 微信小程序: `cd vue2 && npm run dev:mp-weixin`
- App: `cd vue2 && npm run dev:app-plus`

### Vue3 平台测试命令

- H5: `cd vue3 && npm run dev:h5`
- 微信小程序: `cd vue3 && npm run dev:mp-weixin`
- 鸿蒙应用: `cd vue3 && npm run build:harmony`

## Bug 报告规范

在复现成功后，建议包含以下信息:

- uni-app 版本信息
- 运行环境
- 复现步骤
- 预期结果与实际结果
- 可能的解决方案建议


# ESLint 和 Prettier 代码规范指南

本项目使用 ESLint 和 Prettier 来保证代码质量和统一的格式化风格。以下是主要的代码规范说明。

## 配置文件

- Vue2 项目：
  - ESLint 配置：[vue2/.eslintrc.js](mdc:vue2/.eslintrc.js)
  - Prettier 配置：[vue2/.prettierrc.js](mdc:vue2/.prettierrc.js)

- Vue3 项目：
  - ESLint 配置：[vue3/.eslintrc.js](mdc:vue3/.eslintrc.js)
  - Prettier 配置：[vue3/.prettierrc.js](mdc:vue3/.prettierrc.js)

## 主要规则说明

### 基础规则

1. **分号使用**
   - 不使用分号结尾
   - 配置：`semi: false`

2. **引号使用**
   - 使用单引号
   - 配置：`singleQuote: true`

3. **缩进风格**
   - 使用 2 个空格
   - 配置：`tabWidth: 2`
   - 不使用 Tab：`useTabs: false`

4. **行宽限制**
   - 最大行宽 100 字符
   - 配置：`printWidth: 100`

### Vue 相关规则

1. **组件命名**
   - 关闭多词组件名要求：`vue/multi-word-component-names: off`

2. **Script Setup 相关**
   - Vue3 启用 setup 变量检查：`vue/script-setup-uses-vars: error`
   - Script 标签缩进配置：`vueIndentScriptAndStyle: false`

3. **Props 相关**
   - Vue3 关闭 props 默认值要求：`vue/require-default-prop: off`

### TypeScript 相关规则

1. **类型检查**
   - 关闭显式返回类型要求：`@typescript-eslint/explicit-module-boundary-types: off`
   - 允许使用 any：`@typescript-eslint/no-explicit-any: off`

2. **空函数**
   - 允许空函数：`@typescript-eslint/no-empty-function: off`
