<template>
	<view>
		<view style="margin-top:88px;">
			<view>Test article</view>
			<view>
				<editor id="test" @ready="editorReady"></editor>
			</view>
		</view>
		<button @click="click">click</button>

	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
		},
		onLoad() {
			
		},
		methods: {
			editorReady() {
				uni.createSelectorQuery().select('#test').context((nodeContext) => {
					console.log('>>>>>', nodeContext)
					nodeContext.context.setContents({
						html: '<p>abcdefg</p>'
					})
				}).exec()
			}
		}
	}
</script>

<style>

</style>