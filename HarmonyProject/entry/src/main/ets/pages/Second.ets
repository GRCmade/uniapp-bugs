@Entry({ routeName: 'Second' })
@Component
struct Second {
  @State message: string = 'Hello World';

  build() {
    RelativeContainer() {
      Image($r('app.media.startIcon'))
      // Text('yueh')
    }
    .height('100%')
    .width('100%')
  }
}

export const SECOND = 'Second'
