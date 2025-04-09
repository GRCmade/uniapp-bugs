======== README.md ========

# 鸿蒙x中的部分内容

# 鸿蒙x中的编译内容

## 1. v-for v-if 编译之后的内容

测试代码：

```vue
<template>
	<view>
		<button @click="click">yuhe</button>
		<view v-for="(item,index) in data" :key="index">
			<text v-if="index != 2">{{item}}</text>
		</view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				data:['0','1','2','3','4']
			}
		},
		methods: {
			click() {
				
			}
		}
	}
</script>
<style></style>
```



编译之后的代码

```js
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return vue.openBlock(), vue.createElementBlock("view", null, [
    vue.createElementVNode("yuhe", {
      onClick: _cache[0] || (_cache[0] = (...args) => $options.click && $options.click(...args))
    }, "yuhe"),
    (vue.openBlock(true), vue.createElementBlock(
      vue.Fragment,
      null,
      vue.renderList($data.data, (item, index) => {
        return vue.openBlock(), vue.createElementBlock("view", { key: index }, [
          index != 2 ? (vue.openBlock(), vue.createElementBlock(
            "text",
            { key: 0 },
            vue.toDisplayString(item),
            1
            /* TEXT */
          )) : vue.createCommentVNode("v-if", true)
        ]);
      }),
      128
      /* KEYED_FRAGMENT */
    ))
  ]);
}
```



修改的方法是，在底层，修改了 createElement 相关方法，在运行时，将相关的 元素，转换成了 CustomFrameNode



在鸿蒙next上的渲染效果：由运行时，把普通的view被渲染成为了 CustomFrameNode

![image-20250409134907346](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/image-20250409134907346.png)





## 2. 层叠样式示例

注：目前不支持ID选择器，类选择器生效

```css
/* 1. 选择器特异性演示 */
/* 元素选择器 - 低优先级 */
view {
	background-color: #ccc;
}

/* 类选择器 - 中优先级 */
.box-blue {
	background-color: #2196f3;
}

/* ID选择器 - 高优先级 */
#box1 {
	background-color: #3f51b5;
}
```



![image-20250409143910975](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/image-20250409143910975.png)

在样式的解析中，.class 的内容，都会解析到 style

runtime/src/main/ets/runtime/dom/UniElement.ets

![image-20250409150402644](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/image-20250409150402644.png)

## 3. 动画示例

```vue
<template>
	<!-- #ifdef APP -->
	<scroll-view style="flex:1">
	<!-- #endif -->
		<view class="container">
			<view class="box" :class="{ 'animated': isAnimating }" @click="toggleAnimation"></view>
			<button @click="toggleAnimation" class="toggle-btn">{{ isAnimating ? '停止' : '开始' }}动画</button>
		</view>
	<!-- #ifdef APP -->
	</scroll-view>
	<!-- #endif -->
</template>

<script>
	export default {
		data() {
			return {
				isAnimating: false
			}
		},
		methods: {
			toggleAnimation() {
				this.isAnimating = !this.isAnimating;
			}
		}
	}
</script>

<style>
.container {
	display: flex;
	flex-direction: column;
	align-items: center;
	justify-content: center;
	height: 100vh;
}

.box {
	width: 150px;
	height: 150px;
	background-color: #007AFF;
	margin-bottom: 30px;
	transition: transform 1.5s ease-in-out;
	transform: rotate(0deg) scale(1) translateX(0);
}

.box.animated {
	transform: rotate(360deg) scale(1.5) translateX(100px);
}

.toggle-btn {
	background-color: #007AFF;
	color: #FFFFFF;
	padding: 10px 20px;
	border-radius: 5px;
	border: none;
}
</style>

```



使用 transform 的动画时候，会修改 rotate 和 scale 等内容

/uni-app-x-harmony/runtime/src/main/ets/runtime/dom/UniElement.ets

```ts
  private setTransform(cb: (result: boolean) => void) {
    formatTransform(this.nativeStyleCache.transform, formatTransformOrigin(this.nativeStyleCache.transformOrigin),
      (val, transformOptions) => {
        cb(true)

        // TODO 为了和 transform scale 对齐使用不取整计算，后续考虑自定义取整逻辑
        if (this.nativeStyleCache.transform === DEFAULT_TRANSFORM) {
          this.updateNativeNodeStyle('pixelRound', {
            start: PixelRoundCalcPolicy.FORCE_CEIL,
            end: PixelRoundCalcPolicy.FORCE_CEIL,
            top: PixelRoundCalcPolicy.FORCE_CEIL,
            bottom: PixelRoundCalcPolicy.FORCE_CEIL,
          } as PixelRoundPolicy)
        } else {
          this.updateNativeNodeStyle('pixelRound', {
            start: PixelRoundCalcPolicy.NO_FORCE_ROUND,
            end: PixelRoundCalcPolicy.NO_FORCE_ROUND,
            top: PixelRoundCalcPolicy.NO_FORCE_ROUND,
            bottom: PixelRoundCalcPolicy.NO_FORCE_ROUND,
          } as PixelRoundPolicy)
        }

        if (val) {
          this.resetTransform.transform = 1
        } else if (this.resetTransform.transform) {
          this.updateNativeNodeStyleWithTransition('transform', matrix4.identity())
          this.resetTransform.transform = 0
        }
        if (transformOptions?.translate) {
          this.resetTransform.translate = 1
        } else if (this.resetTransform.translate) {
          this.updateNativeNodeStyleWithTransition('translate', {} as TranslateOptions)
          this.resetTransform.translate = 0
        }
        if (transformOptions?.scale) {
          this.resetTransform.scale = 1
        } else if (this.resetTransform.scale) {
          this.updateNativeNodeStyleWithTransition('scale', {} as ScaleOptions)
          this.resetTransform.scale = 0
        }
        if (transformOptions?.rotate) {
          this.resetTransform.rotate = 1
        } else if (this.resetTransform.rotate) {
          this.updateNativeNodeStyleWithTransition('rotate', {} as RotateOptions)
          this.resetTransform.rotate = 0
        }

        transformOptions?.translate && this.updateNativeNodeStyleWithTransition('translate', transformOptions.translate)
        transformOptions?.scale && this.updateNativeNodeStyleWithTransition('scale', transformOptions.scale)
        transformOptions?.rotate && this.updateNativeNodeStyleWithTransition('rotate', transformOptions.rotate)

        val && this.updateNativeNodeStyleWithTransition('transform', val)
      })
  }
```

![image-20250409150045322](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/image-20250409150045322.png)







## 4. Position-fix 实例

```vue
<template>
	<!-- #ifdef APP -->
	<scroll-view style="flex:1" :scroll-y="true">
	<!-- #endif -->
		<view class="container">
			<view class="content">
				<view class="item" v-for="(item, index) in 20" :key="index">列表项 {{index + 1}}</view>
			</view>
			<view class="fixed-top">顶部固定区域</view>
			<view class="fixed-bottom">底部固定区域</view>
		</view>
	<!-- #ifdef APP -->
	</scroll-view>
	<!-- #endif -->
</template>

<script>
	export default {
		data() {
			return {
				
			}
		},
		methods: {
			
		}
	}
</script>

<style>
.container {
	position: relative;
	min-height: 100vh;
}
.content {
	padding: 80px 0 80px 0;
}
.item {
	height: 100px;
	line-height: 100px;
	text-align: center;
	background-color: #f2f2f2;
	margin: 10px;
	border-radius: 5px;
}
.fixed-top {
	position: fixed;
	top: 0;
	left: 0;
	right: 0;
	height: 60px;
	line-height: 60px;
	text-align: center;
	background-color: #007AFF;
	color: #fff;
	z-index: 999;
}
.fixed-bottom {
	position: fixed;
	bottom: 0;
	left: 0;
	right: 0;
	height: 60px;
	line-height: 60px;
	text-align: center;
	background-color: #007AFF;
	color: #fff;
	z-index: 999;
}
</style>

```



![image-20250409151138452](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/image-20250409151138452.png)



position-fix的效果，可以在组件树中查看

正常的元素，一般在最内层的

![image-20250409151336473](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/image-20250409151336473.png)

posotion-fix的元素，经过审查，可以看到脱离了原本的结构中

![image-20250409151440915](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/image-20250409151440915.png)





## 5. Margin 示例

![image-20250409153607142](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/image-20250409153607142.png)

margin 这个属性比较特殊，在arkui的 属性检查中，不会展示有 margin 的效果，可以看到在元素的右侧中 margin 都是 0 

![image-20250409155020265](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/image-20250409155020265.png)

这个 margin 在源码中，主要是作用于 元素的位置等信息

```ts
  updateNativeNodeStyle(key: string, value: Object | undefined, commonAttribute?: CommonAttribute): void {
    this.onFrameNode(frameNode => {
      // UniFrameNode 除位置外使用 attribute 修改内层节点属性
      commonAttribute =
        commonAttribute ?? (isUniFrameNode(frameNode) && !['x', 'y'].includes(key) ?
        (frameNode as FrameNode as UniFrameNode).attribute :
        frameNode.commonAttribute)
      this._commonAttribute = commonAttribute
      switch (key) {
        case 'width':
          commonAttribute.width(value as Length)
          break
        case 'height':
          commonAttribute.height(value as Length)
          break
        case 'x': {
          const position = this.nativeStyleCache.position
          if (value !== position.x) {
            position.x = value as Length
            if (!this.isFullscreen) {
              if (!this.isDuringBatchSetStyle) {
                commonAttribute.position(position)
              } else {
                this.batchSetStyleKeys.add('position')
              }
            }
          }
          break
        }
        case 'y': {
          const position = this.nativeStyleCache.position
          if (value !== position.y) {
            position.y = value as Length
            if (!this.isFullscreen) {
              if (!this.isDuringBatchSetStyle) {
                commonAttribute.position(position)
              } else {
                this.batchSetStyleKeys.add('position')
              }
            }
          }
          break
```



比方说，可以看到这个margin 10 20 30 40 的例子

其position排版的信息如下所示

![image-20250409155407424](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/image-20250409155407424.png)

x是51 ，y是 49.77



对比 全是margin 10 的例子

![image-20250409155524875](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/picgo/image-20250409155524875.png)

x 是 21 ， y 是 49.77





可以看见，y是相同的

在左侧有 margin较大，因此就会把x 增大，同时长度也会发生变化






======== END ========
