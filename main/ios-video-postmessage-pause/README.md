======== README.md ========

# IOS系统 在web-view中使用uni.postMessage ， 导致视频暂停播放

![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/20250829113908554.png)

```html
<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta charset="UTF-8" />
  <title>Child Page</title>
	<script src="./uni.webview.1.5.4.js"></script>
</head>
<body>
  <h2>视频</h2>
  <video id="myVideo" width="560" height="315" controls autoplay muted playsinline>
    <source src="https://www.w3schools.com/html/mov_bbb.mp4" type="video/mp4" />
    您的浏览器不支持 video 标签。
  </video>
	<button id="btn" style="width: 200px;height: 100px;font-size: 30px;">分享</button>

  <script>
    const video = document.getElementById("myVideo");
    video.addEventListener("pause", (event) => {
      console.log("pause");
    });
		document.getElementById("btn").addEventListener("click", () => {
			uni.postMessage({data: {status: 1}});
			console.log('btn click')
		})
  </script>
</body>
</html>



安卓,h5 没有问题,ios 有问题


## postMessage 之后,视频会暂停

暂时反馈用户通过 plus 的 API 替代

## 目前用uni-app开发遇到了APP端视频切换tab时无法暂停视频的bug，很影响体验，搜了一下挺多人遇到这个问题的，没找到如何解决

在项目的 vue3 下,没有复现

```

======== END ========
