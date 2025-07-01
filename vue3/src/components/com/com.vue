<template>
	<view>
		<movable-area :style="{ width: '100%', height: allQuestionHeight + 'px' }">
			<movable-view class="base-drag-wrapper" v-for="item in questions" :key="item.id" :y="item.y" style="width: 100%"
				direction="vertical" @change="handleMove">
				<view class="question-item">
					<text>{{ item.text }}</text>
				</view>
			</movable-view>
		</movable-area>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				questions: [{
					text: 'com组件',
					id: 1,
					y: 0
				}, {
					text: ' 123',
					id: 2,
					y: 50
				}],
				allQuestionHeight: 100
			}
		},
		mounted() {
			// 注释修改高度的代码就正常显示
			setTimeout(() => {
				this.allQuestionHeight = 101
				console.log('change allQuestionHeight')
			}, 500)
		},
		methods: {
			handleMove(event) {
				// 处理移动事件
				console.log('move event:', event)
			}
		}
	}
</script>
<style>
	.question-item {
		width: 100%;
		height: min-content;
	}
</style>