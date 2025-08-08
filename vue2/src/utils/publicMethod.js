// 判断是否是登录
export function isLogin() {
    const promise = new Promise(function(resolve, reject) {
        uni.getStorage({
            key: 'user',
            success: ({ data }) => {
                if(!data.vuex_token) {
                    uni.showModal({
                        content: '您还未登录，请先登录',
                        showCancel: true,
                        confirmText: '前往登录',
                        confirmColor: '#0052D9',
                        cancelText: '暂不登录',
                        cancelColor: '#000000',
                        success: ({ confirm, cancel }) => {
                            if(confirm) {
                                uni.navigateTo({ url: '/pages/login/login' })   
                            }
                        }
                    })
                    resolve(false)
                } else if(!data.vuex_status) {
                    uni.showModal({
                        content: '您还未认证，请先认证',
                        showCancel: true,
                        confirmText: '前往认证',
                        confirmColor: '#0052D9',
                        cancelText: '暂不认证',
                        cancelColor: '#000000',
                        success: ({ confirm, cancel }) => {
                            if(confirm) {
                                uni.navigateTo({ url: '/pages_my/authentication/authentication' })   
                            }
                        }
                    })
                    resolve(false)
                } else {
                    resolve(true)
                }
            },
            fail: (error) => {
                uni.showModal({
                    content: '您还未登录，请先登录',
                    showCancel: true,
                    confirmText: '前往登录',
                    confirmColor: '#0052D9',
                    cancelText: '暂不登录',
                    cancelColor: '#000000',
                    success: ({ confirm, cancel }) => {
                        if(confirm) {
                            uni.navigateTo({ url: '/pages/login/login' })
                            
                        }
                    }
                })
                resolve(false)
            }
        })
    })
    return promise
}

// 多边形中心点获取
export function getCenter(PolygonArr) {
    let total = PolygonArr.length;
    let X = 0; let Y = 0; let Z = 0;
    PolygonArr.forEach((lnglat) => {
        let lng = lnglat[0] * Math.PI / 180;
        let lat = lnglat[1] * Math.PI / 180;
        let x, y, z;
        x = Math.cos(lat) * Math.cos(lng);
        y = Math.cos(lat) * Math.sin(lng);
        z = Math.sin(lat);
        X += x;
        Y += y;
        Z += z;
    });
    X = X / total;
    Y = Y / total;
    Z = Z / total;

    let Lng = Math.atan2(Y, X);
    let Hyp = Math.sqrt(X * X + Y * Y);
    let Lat = Math.atan2(Z, Hyp);
    return [Lng * 180 / Math.PI, Lat * 180 / Math.PI];
}

export function getWeekDate(time) {
    var date = new Date(time);
    var day = date.getDay();
    var names = ["周日","周一","周二","周三","周四","周五","周六"];
    return names[day];
}