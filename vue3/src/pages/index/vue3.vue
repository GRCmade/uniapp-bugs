<template>
  <view class="abc">
    <view id="draw" style="width: 100%; height: 300rpx; background-color: greenyellow">
      我是要截图的内容
      <!-- 使用本地图片或者处理过的图片，设置crossorigin属性 -->
      <img :src="processedImageUrl" class="img"  v-if="processedImageUrl"></img>
      <image :src="processedImageUrl" class="img" v-if="processedImageUrl"></image>
    </view>
		<!-- #ifndef H5 -->
		<view
		  class="btn"
		  @click="canvasToImage.preservation"
		  style="
		    width: 100%;
		    height: 80rpx;
		    display: flex;
		    align-items: center;
		    justify-content: center;
		    border: 1rpx solid #000;
		    margin-top: 30rpx;
		  ">
		  点我截图
		</view>
		<!-- #endif -->

  </view>
</template>
<script>
export default {
  data() {
    return {
      processedImageUrl: ''
    }
  },
  mounted() {
    // 页面加载时处理图片
    this.processImage()
  },
  methods: {
    // 处理外部图片，转换为本地可用的格式
    async processImage() {
      const imageUrl = 'https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250909180349853.png'

      try {
        // 方法1: 直接使用原图片（适用于同域或配置了CORS的情况）
        this.processedImageUrl = imageUrl

        // 方法2: 如果需要下载到本地（可选）
        // uni.downloadFile({
        //   url: imageUrl,
        //   success(res){
        //     console.log("res",JSON.stringify(res))
        //     this.processedImageUrl = res.tempFilePath
        //   }
        // })
        // if (result[0].statusCode === 200) {
        //   this.processedImageUrl = result[0].tempFilePath
        // }

      } catch (error) {
        console.error('图片处理失败:', error)
        // 使用占位图片或隐藏
        this.processedImageUrl = ''
      }
    },

    showToast(type) {
      if (type == 'load') {
        uni.showLoading()
      } else {
        uni.hideLoading()
      }
    },

    // 检查并申请相册权限
    // app端的话可以用这个方法 将base64 图片保存到本地系统相册
    // 参考文档：https://blog.csdn.net/Zhuangvi/article/details/130581363
    saveBaseImgFile(base64) {
      const bitmap = new plus.nativeObj.Bitmap('base64')
      bitmap.loadBase64Data(
        base64,
        () => {
          const url = '_doc/' + new Date().getTime() + '.png'
          bitmap.save(
            url,
            {
              overwrite: true // 是否覆盖
              // quality: 'quality'  // 图片清晰度
            },
            i => {
              uni.saveImageToPhotosAlbum({
                filePath: url,
                success: () => {
                  console.log('图片保存成功')
                  bitmap.clear()
                }
              })
            },
            e => {
              console.log('图片保存失败')
              bitmap.clear()
            }
          )
        },
        e => {
          console.log('图片保存失败')
          bitmap.clear()
        }
      )
    }
  }
}
</script>
<!-- #ifdef APP -->
<script module="canvasToImage" lang="renderjs">
import html2canvas from "html2canvas"
export default {
	data() {
		return {}
	},
	methods: {
		async preservation(event, ownerInstance) {
			console.log("preservation")
			// ownerInstance.callMethod('showToast', 'load')
			var dom = document.getElementById('draw')
			try {
				console.log("dom",dom)

				// 预加载图片以避免跨域问题
				const images = dom.querySelectorAll('img, image')
				for (let img of images) {
					if (img.src && img.src.startsWith('http')) {
						try {
							// 创建一个新的图片元素来测试加载
							const testImg = new Image()
							testImg.crossOrigin = 'anonymous'
							await new Promise((resolve, reject) => {
								testImg.onload = resolve
								testImg.onerror = reject
								testImg.src = img.src
							})
						} catch (e) {
							console.warn('图片加载失败，将被跳过:', img.src)
						}
					}
				}

				const canvas = await html2canvas(dom, {
					background: '#fff',
					scale: 2,
					useCORS: true,
					allowTaint: false, // 改为false，避免污染canvas
					logging: true,
					foreignObjectRendering: false, // 禁用外部对象渲染
					removeContainer: true,
					imageTimeout: 0, // 设置图片加载超时时间
					onclone: (clonedDoc, element) => {
						// 在克隆的文档中处理图片
						const clonedImages = element.querySelectorAll('img, image')
						clonedImages.forEach(img => {
							if (img.src && img.src.startsWith('http')) {
								// 如果是外部图片且加载失败，替换为占位符或隐藏
								img.style.visibility = 'hidden'
								// 或者可以替换为本地占位图片
								// img.src = '/static/placeholder.png'
							}
						})
					}
				})
				console.log("canvas", canvas)
				let url = canvas.toDataURL('image/png')
				ownerInstance.callMethod('saveBaseImgFile', url)
			} catch (error) {
				console.log('html2canvas error:', JSON.stringify(error))
				// ownerInstance.callMethod('showToast', 'hide')

				// 如果html2canvas失败，可以尝试简化配置重试
				try {
					console.log('尝试简化配置重新截图...')
					const canvas = await html2canvas(dom, {
						background: '#fff',
						scale: 1,
						useCORS: false,
						allowTaint: true,
						logging: false,
						foreignObjectRendering: false,
						removeContainer: true,
						ignoreElements: (element) => {
							// 忽略加载失败的图片元素
							return element.tagName === 'IMG' && element.src && element.src.startsWith('http')
						}
					})
					let url = canvas.toDataURL('image/png')
					ownerInstance.callMethod('saveBaseImgFile', url)
				} catch (fallbackError) {
					console.log('简化配置也失败:', JSON.stringify(fallbackError))
					// TODO: 显示错误提示
				}
			}
		},
	}
}
</script>
<!-- #endif -->
<style>
.controls {
  display: flex;
  justify-content: space-around;
  margin-top: 20rpx;
}

.img{
  width: 100px;
  height: 100px;
}

/* 为html2canvas优化的样式 */
#draw {
  /* 确保容器有明确的尺寸 */
  box-sizing: border-box;
}

#draw img,
#draw image {
  /* 确保图片完全加载后再截图 */
  image-rendering: -webkit-optimize-contrast;
  image-rendering: crisp-edges;
}
</style>
