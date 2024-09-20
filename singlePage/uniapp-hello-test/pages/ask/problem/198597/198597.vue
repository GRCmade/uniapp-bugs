<script setup>
	import { ref } from 'vue';
	const image = ref([]);
	// 点击上传图片事件
	const addImageToList = (sourceType) => {
		console.log("被点击了");
		uni.chooseImage({
			count: 99,
			sizeType: ['compressed'],
			sourceType: [sourceType],
			success: function(res) {
				console.log(res);
				image.value = [...image.value, ...res.tempFilePaths];
				console.log(image.value);
			}
		});
	};
</script>
<template>
	<view class="layoutBox">
		<uni-section title="不良品" type="line" titleFontSize="24px"></uni-section>
		<view class="example">
			<uni-forms>
				<uni-forms-item label="不良品数量：" required label-width="200">
					<uni-easyinput placeholder="0" :inputBorder="false" />
				</uni-forms-item>
				<uni-forms-item>
					<view class="top">
						<text>不良品描述</text>
					</view>
					<view class="bottom">
						<uni-easyinput type="textarea" placeholder="无" />
					</view>
				</uni-forms-item>
				<uni-forms-item>
					<view class="top">
						<text>不良品图片</text>
					</view>
					<view class="bottom">
						<view class="photo" @click="addImageToList('album')">
							<uni-icons type="plusempty" size="48"></uni-icons>
							<view class="text">上传图片</view>
						</view>
						<view class="camera" @click="addImageToList('camera')">
							<uni-icons type="camera" size="48"></uni-icons>
							<view class="text">使用摄像头</view>
						</view>
					</view>
				</uni-forms-item>
				<uni-forms-item>
					<scroll-view class="scroll" scroll-x v-if="image.length > 0">
						<!-- 子元素 -->
						<view class="group" v-for="(item, index) in image" :key="index">
							<image style="width: 152rpx; height: 152rpx; margin-right: 16rpx;" :src="item" />
						</view>
					</scroll-view>
				</uni-forms-item>
			</uni-forms>
		</view>
	</view>
</template>