@Entry
@Component
struct RichTextExample {
  @State data: string = '<h1 style="text-align: center;">image1</h1>' +
    '<image src=\\"https://wcw-prd.oss-cn-beijing.aliyuncs.com/202512/bca004547490433782366bfc5a6f9dfd.jpg?Expires=2713224548&OSSAccessKeyId=LTAI5tGK7bKsZYTZBVpVsPxf&Signature=dqU6Ekrem3r%2Br8HqsbFVOW6BbbA%3D\\"/> '
    + '<h1 style="text-align: center;">image2</h1>' +
  '<image src=\\"https://web-ext-storage.dcloud.net.cn/ask/ad/adv_right_1/uni_agent_260429.png"/> ';
  build() {
    Flex({ direction: FlexDirection.Column, alignItems: ItemAlign.Center,
      justifyContent: FlexAlign.Center }) {
      Image("https://wcw-prd.oss-cn-beijing.aliyuncs.com/202512/d0268ff459c24e5fbf27da49251eed33.png?Expires=2713224466&OSSAccessKeyId=LTAI5tGK7bKsZYTZBVpVsPxf&Signature=Rul8fXdzoYL3KOhW3dqTmkm47Rk%3D")
      RichText(this.data)
        .onStart(() => {
          console.info('RichText onStart');
        })
        .onComplete(() => {
          console.info('RichText onComplete');
        })
        .width(500)
        // .height(500)
        .backgroundColor(0XBDDB69)
    }
  }
}
