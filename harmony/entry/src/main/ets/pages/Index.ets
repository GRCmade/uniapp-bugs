import { openUniMP, isExistsUniMP, releaseWgtToRunPath } from '@dcloudio/uni-app-runtime';

interface MPres {
  msg: string;
}

@Preview
@Entry
@Component
struct Index {
  @State mpId: string = '__UNI__F0B54C3';
  @State pageList: string[] = ['pages/index/index', 'pages/second/second', 'pages/third/third']

  async aboutToAppear() {
    const mpId = this.mpId
    await new Promise<void>((resolve, reject) => {
      try {
        // 判断应用是否已释放到运行目录
        let isExists = isExistsUniMP(mpId)
        console.log("isExists:" + isExists)
        // 拼接wgt包路径
        let path = getContext().resourceDir + "/" + mpId + ".wgt"
        // 释放 wgt 包到运行目录
        releaseWgtToRunPath(mpId, path, (code: number, data: object) => {
          console.log(JSON.stringify({ code, data }))
          resolve()
        })
      } catch (err) {
        reject(err)
      }
    })
  }

  build() {
    Column() {
      Text('鸿蒙 uni小程序sdk小功能 - 打开小程序指定页面')
        .fontSize(30)
      Text('下方三个按钮是打开同一个小程序的三个页面')
        .margin({ top: 20 })
      ForEach(this.pageList, (item: string, index: number) => {
        Button(item)
          .fontSize(30)
          .margin({ top: 20 })
          .onClick(async () => {
            // 启动小程序
            const mp = openUniMP(this.mpId, {
              redirectPath: item
            })
            mp.on('show', () => {
              console.log('UniMP-show:', item)
            })
          })
      })
      Text('下方按钮打开小程序并且传入参数')
        .margin({ top: 20 })
      Button('传入参数')
        .fontSize(30)
        .margin({ top: 20 })
        .onClick(async () => {
          // 启动小程序
          const mp = openUniMP(this.mpId, {
            redirectPath: 'pages/index/index',
            extraData:{
              data : 'data from harmonyos'
            }
          })
          mp.on('show', () => {
            console.log('UniMP-show:', 'pages/index/index')
          })
        })
    }.margin(20)
  }
}
