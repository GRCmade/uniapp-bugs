import { openUniMP, isExistsUniMP, releaseWgtToRunPath } from '@dcloudio/uni-app-runtime';

interface MPres {
  msg: string;
}

@Preview
@Entry
@Component
struct Index {
  @State mpList: string[] = ['__UNI__F0B54C3']

  async func(mpId:string) {
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
      Text('鸿蒙 uni小程序sdk')
        .fontSize(30)
      Text('下方三个按钮是打开同一个小程序的三个页面')
        .margin({ top: 20 })
      ForEach(this.mpList, (item: string, index: number) => {
        Button(item)
          .fontSize(30)
          .margin({ top: 20 })
          .onClick(async () => {
            await this.func(item)
            // 启动小程序
            const mp = openUniMP(item, {
              redirectPath: item
            })
            mp.on('show', () => {
              console.log('UniMP-show:', item)
            })
          })
      })
    }.margin(20)
  }
}
