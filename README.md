======== README.md ========

# 苹果safari浏览器openLocation打开腾讯地图底部导航栏被浏览器导航栏遮挡
> uniapp-bugs https://github.com/GRCmade/uniapp-bugs

# 问题

```javascript
				uni.getLocation({
	type: 'gcj02', //返回可以用于uni.openLocation的经纬度
	success: function (res) {
		const latitude = res.latitude;
		const longitude = res.longitude;
		uni.openLocation({
			latitude: latitude,
			longitude: longitude,
			name:"name",
			address:"address",
			success: function () {
				console.log('success');
			}
		});
	}
});
```

用户说，会挡住，但是实际没有发现
![](https://yuhepicgo.oss-cn-beijing.aliyuncs.com/undefined20250208164318246.png)


======== END ========