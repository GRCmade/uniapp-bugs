import hilog from '@ohos.hilog';

@Entry
@Component
struct Index {
  scrollerA: Scroller = new Scroller();
  scrollerB: Scroller = new Scroller();
  @State message: string = 'Hello World';
  @State visible: string = 'A';

  build() {
    Column(){
      Button('click to visible '+ (this.visible == 'A'?'B':'A'))
        .onClick(()=>{
          this.visible = this.visible == 'A' ? 'B' : 'A'
        })
      RelativeContainer(){
        Scroll(this.scrollerA){
          Button('A').onClick(()=>{
            hilog.info(0x100,'1','A')
          })
            .position({
              left:0,
              top:0
            })
        }
        .visibility(this.visible == 'A' ? Visibility.Visible : Visibility.Hidden)
        .height('100vp')
        .width('100%')
        Scroll(this.scrollerB){
          Button('B').onClick(()=>{
            hilog.info(0x100,'1','B')
          })
            .position({
              left:0,
              top:0
            })
        }
        .visibility(this.visible == 'B' ? Visibility.Visible : Visibility.Hidden)
        .height('100vp')
      }
      .height('100vp')
      .backgroundColor('#1ff')
    }
  }
}
