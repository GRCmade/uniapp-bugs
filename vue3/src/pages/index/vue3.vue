<template>
	<view class="rc-input-container">
		<view class="rc-input-text">
			<textarea class="rc-input-text-input" auto-height confirm-hold v-model="text" :maxlength="-1"
				:adjust-position="false" @confirm="sendMessage" @input="inputHandler" :cursor-spacing="20" always-embed
				:show-confirm-bar="false" :cursor="inputCursor" :focus="inputFocus" @blur="onBlurHandler"
				@focus="onFocusHandler" :disable-default-padding="true" @keyboardheightchange="onKeyboardHeightChangeHandler"
				confirm-type="send">
      </textarea>
		</view>
	</view>
</template>
<script>
	export default {
		data() {
			return {
				text: '11',
				inputCursor: 0,
				inputFocus: false,
			}
		},
		onLoad() {
			// uniapp 生命周期
		},
		methods: {
			sendMessage() {
				console.info('----sendMessage----===------')
			},
			inputHandler(e) {
				console.info('----inputHandler----===------')
				this.text = e.detail.value
			},
			onBlurHandler() {
				console.info('----onBlurHandler----===------')
			},
			onFocusHandler() {
				console.info('----onFocusHandler----===------')
			},
			onKeyboardHeightChangeHandler(e) {
				console.info('----onKeyboardHeightChangeHandler----===------', e)
			}
		}
	}
</script>
<style lang="scss">
	.rc-input-container {
		z-index: 100;
		position: fixed;
		left: 0;
		right: 0;
		bottom: 0;
		box-sizing: border-box;
		padding: 9px 11px 9px;
		padding-bottom: calc(env(safe-area-inset-bottom));
		padding-bottom: calc(constant(safe-area-inset-bottom));
	}

	.rc-input-text-input {
		background: #CCCCCC;
		border-radius: 6px;
		border: 1px solid #000000;
		color: #FFFFFF;
		padding: 7px 10px;
		line-height: 22px;
		min-height: 22px;
		overflow-y: auto;
		width: calc(100% - 20px);
	}
</style>