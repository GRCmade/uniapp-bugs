<template>
	<view>
		<canvas style="width: 300px; height: 200px;" canvas-id="firstCanvas" id="firstCanvas"></canvas>
		<button @click="click">click</button>
	</view>
</template>


<script>
	export default {
		data() {
			return {

			}
		},
		onReady: function(e) {
			var context = uni.createCanvasContext('firstCanvas')
			context.setStrokeStyle("#00ff00")
			context.setLineWidth(5)
			context.rect(0, 0, 200, 200)
			context.stroke()
			context.setStrokeStyle("#ff0000")
			context.setLineWidth(2)
			context.moveTo(160, 100)
			context.arc(100, 100, 60, 0, 2 * Math.PI, true)
			context.moveTo(140, 100)
			context.arc(100, 100, 40, 0, Math.PI, false)
			context.moveTo(85, 80)
			context.arc(80, 80, 5, 0, 2 * Math.PI, true)
			context.moveTo(125, 80)
			context.arc(120, 80, 5, 0, 2 * Math.PI, true)
			context.stroke()
			context.draw()
		},
		methods: {
			canvasIdErrorCallback: function(e) {
				console.error(e.detail.errMsg)
			},
			click() {
				// let str = 'http://yuhepicgo.oss-cn-beijing.aliyuncs.com/2024-09/1726736565086.png'
				// let ctx = uni.createCanvasContext('firstCanvas');
				// ctx.drawImage(str, 0, 0, 150, 100)
				// ctx.draw(true);
				
				let ctx = uni.createCanvasContext('firstCanvas');
				uni.chooseImage({
					count: 1,
					success: (res => {
						console.log(JSON.stringify(res))
						
						// file://media/Photo/1/IMG_1726733991_000/Screenshot_2024-09-19T161044.png
						// Access to image at 'file://media/Photo/1/IMG_1726733991_000/Screenshot_2024-09-19T161044.png' from origin 'null' has been blocked by CORS policy:
						ctx.drawImage(res.tempFilePaths[0], 0, 0, 150, 100)
						ctx.draw(true);
					})
				})
			}
		}
	}
</script>

<style>
</style>