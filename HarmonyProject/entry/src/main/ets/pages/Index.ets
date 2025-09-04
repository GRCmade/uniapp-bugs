import hilog from '@ohos.hilog';

@Entry
@Component
struct Index {
  scroller: Scroller = new Scroller();
  @State message: string = 'Hello World';
  @State visible: string = 'A';

  build() {
    Column(){
      Button('click to visible '+ (this.visible == 'A'?'B':'A'))
        .onClick(()=>{
          this.visible = this.visible == 'A' ? 'B' : 'A'
        })
      RelativeContainer(){
        Row(){
          Scroll(this.scroller){
            Button('A').onClick(()=>{
              hilog.info(0x100,'1','A')
            })
          }
          .position({
            left:0,
            top:0
          })
          .visibility(this.visible == 'A' ? Visibility.Visible : Visibility.Hidden)
          .width('50vp')
          .height('80vp')
          .backgroundColor('#000')
        }
        Row(){
          Scroll(this.scroller){
            Button('B').onClick(()=>{
              hilog.info(0x100,'1','B')
            })
          }
          .visibility(this.visible == 'B' ? Visibility.Visible : Visibility.Hidden)
          .width('80vp')
          .height('50vp')
          .position({
            left:0,
            top:0
          })
        }
      }
      .height('100vp')
      .backgroundColor('#1ff')
    }
  }
}
