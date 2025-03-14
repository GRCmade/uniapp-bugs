<template>
  <view>
		<view class="a">第二种情况：canvas</view>
		<canvas style="width: 300px; height: 200px;" canvas-id="firstCanvas" id="firstCanvas">
    </canvas>

    <view class="a">第一种情况：textarea</view>
    <textarea v-model="text">

		</textarea>
  </view>
</template>
<script>
export default {
  data() {
    return {
      numberValue: 100,
      digitValue: 100,
      text: 'textarea',
      inputStatus: {
        isShowInputBox: true
      }
    }
  },
  onReady: function (e) {
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
    click() { }
  }
}
</script>
<style>
.a{
  margin: 10px;
}
.input-container {
  display: flex;
  flex-direction: column;
  gap: 10px;
  padding: 20px;
  background-color: #f9f9f9;
  border-radius: 8px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
}

.input-field {
  padding: 10px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-size: 16px;
  transition: border-color 0.3s;
}

.input-field:focus {
  border-color: #007BFF;
  outline: none;
}
</style>