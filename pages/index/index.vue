<template>
	<view class="">
		<view class='input'>
			<input type="text" placeholder="好的标题能吸引更多游戏发烧友哦~(必填)" />
		</view>
		<view id="scroll_box_editor">
			<editor id="editor" class="editor"
				placeholder="请输入不少于5字的内容，发布内容不可涉嫌色情、政治、辱骂等，一旦发现平台有权依据国家相关法律法规和社区用户行为规范进行追责~(必填)" @ready="onEditorReady">
			</editor>
		</view>
		<view class="cu-bar">使用position: fixed;定位的盒子</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {
				editorCtx: null,
			}
		},
		methods: {
			onEditorReady() {
				uni.createSelectorQuery()
					.select('#editor')
					.context((res) => {
						this.editorCtx = res.context;
						console.log(JSON.stringify(this.editorCtx), 'xxxx')
					})
					.exec();
			},
		}
	}
</script>

<style lass='scss' scoped>
	.input {
		width: 100%;
		height: 100rpx;
		border: 1px solid red;
	}

	#scroll_box_editor {
		width: 100%;
		border: 1px solid red;
		height: 70vh;

		.editor {
			width: 100%;
		}
	}

	.cu-bar {
		display: flex;
		flex-direction: column;
		align-items: center;
		box-sizing: border-box;
		line-height: normal;
		min-height: 100rpx;
		position: fixed;
		width: 100%;
		bottom: 0;
		z-index: 2;
		box-shadow: 0 0rpx 1rpx rgba(0, 0, 0, 0.1);
		padding-right: 20rpx;
		background-color: #ffffff;
	}
</style>