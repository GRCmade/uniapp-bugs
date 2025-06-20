import { openUniApp } from '@dcloudio/uni-app-x-runtime'

interface MPres {
  msg: string;
}

@Preview
@Entry
@Component
struct Index {
  @State mpList: string[] = ['__UNI__F0B54C3']

  build() { 
    Column() {
      Text('鸿蒙 uni小程序sdk')
        .fontSize(30)
      Text('下方三个按钮是打开同一个小程序的三个页面')
        .margin({ top: 20 })
    }.margin(20)
  }
}
