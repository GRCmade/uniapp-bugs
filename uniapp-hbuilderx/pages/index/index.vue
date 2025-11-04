<template>
	<view>
		<button @click="send">send - json</button>
	</view>
</template>

<script lang="ts" setup>
	const click = () => { }
	let count = 0;
	let requestTask = null;
	const send = async () => {
		console.log('start: ' + ++count)
		try {
			requestTask = uni.request({
				// https://mp-740c4f25-0fdf-4df3-8af2-156cb0aab142.cdn.bspapp.com/test.json
				// url: 'https://mp-740c4f25-0fdf-4df3-8af2-156cb0aab142.cdn.bspapp.com/large-data-20mb.json',
				// https://mp-740c4f25-0fdf-4df3-8af2-156cb0aab142.cdn.bspapp.com/large-data-26mb.json
				// url: 'https://mp-740c4f25-0fdf-4df3-8af2-156cb0aab142.cdn.bspapp.com/large-data-35mb.json',
				// url: 'https://mp-740c4f25-0fdf-4df3-8af2-156cb0aab142.cdn.bspapp.com/large-data-21-41mb.json',
				url: 'https://mp-740c4f25-0fdf-4df3-8af2-156cb0aab142.cdn.bspapp.com/large-data-63mb.json',
				success: (res) => {
					console.log('------end:');
					requestTask.abort();
					setTimeout(() => {
						send();
					}, 5000)
				},
				fail: (err) => {
					console.log(err)
				}
			})
		} catch (error) {
			//TODO handle the exception
			console.log("request",error)
		}

	}
</script>

<style></style>