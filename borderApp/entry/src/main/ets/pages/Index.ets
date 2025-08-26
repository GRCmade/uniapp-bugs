@Entry
@Component
struct Index {
  build() {
    Column() {

      Stack() {
        Stack().width(30)
          .height(30)
          .backgroundColor(Color.Red)
          .borderWidth(2)
          .borderColor(Color.Green)
          .position({
            left: 80,
            top: 80
          })
      }
      .width(100)
      .height(100)
      .borderStyle(BorderStyle.Solid)
      .backgroundColor(Color.Blue)
      .borderWidth(2)
      .borderColor('#000')
    }
  }
}
