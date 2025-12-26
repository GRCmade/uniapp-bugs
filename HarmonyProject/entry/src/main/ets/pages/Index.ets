@Entry
@Component
struct Index {
  @State message: string = 'Hello World';

  build() {
    RelativeContainer() {
      Image($r('app.media.startIcon'))
        .objectFit(ImageFit.Fill)
        .overlay("Winter is a beautiful season, especially when it snows.", {
          align: Alignment.TopStart,  // 文本底部对齐
          offset: { x: 0, y: 100 }  // 垂直向上偏移15单位
        })
      // Text('yueh')
    }
    .height('100%')
    .width('100%')
    // .backgroundColor("#0075ff")
  }
}
