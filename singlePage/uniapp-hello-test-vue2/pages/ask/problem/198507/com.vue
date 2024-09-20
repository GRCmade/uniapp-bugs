<template>
	<view>
		<view style="margin-top:88px;">
			<view>Test article yuhe</view>
			<view>
				<editor id="test" @ready="editorReady"></editor>
			</view>
		</view>
	</view>
</template>

<script>
	export default {
		data() {
			return {

			}
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