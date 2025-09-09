import hilog from '@ohos.hilog';
import { NodeController, typeNode } from '@kit.ArkUI';

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
          // .backgroundColor('#000')
        }
        Row(){
          Scroll(this.scroller){
            Button('B').onClick(()=>{
              hilog.info(0x100,'1','B')
            })
          }
          .visibility(this.visible == 'B' ? Visibility.Visible : Visibility.Hidden)
          .width('50vp')
          .height('80vp')
          .position({
            left:0,
            top:0
          })
        }
      }
      .height('100vp')
      .width('100%')
      .backgroundColor('#1ff')
    }
  }
}

// @Entry
// @Component
// struct Index {
//   @State views: Array<Array<number>> = [];
//
//   build() {
//     RelativeContainer() {
//       NodeContainer(new CustomNodeController())
//     }
//     .height('100%')
//     .width('100%')
//   }
// }
//
// class CustomNodeController extends NodeController {
//   private scroller: Scroller = new Scroller();
//   private visible: string = 'A';
//
//   // 创建滚动行的通用函数
//   private createScrollRow(uiContext: UIContext, buttonText: string, width: string, height: string, isVisible: boolean) {
//     const scrollRow = typeNode.createNode(uiContext, 'Row');
//     const scroll = typeNode.createNode(uiContext, 'Scroll');
//     let _scroll = new Scroller();
//     scroll.initialize(_scroll);
//
//     const button = typeNode.createNode(uiContext, 'Button');
//     button.initialize(buttonText)
//       .onClick(() => {
//         hilog.info(0x100, '1', buttonText);
//       });
//     button.attribute
//       .width(width)
//       .height(height)
//
//     scroll.appendChild(button);
//     scroll.attribute
//       .width('auto') // 自适应宽度，根据内容调整
//       .height('100%');
//
//     scrollRow.appendChild(scroll);
//     scrollRow.attribute
//       .position({ left: 0 })
//       .visibility(isVisible ? Visibility.Visible : Visibility.Hidden)
//       .backgroundColor('#0075ff');
//     return scrollRow;
//   }
//
//   makeNode(uiContext: UIContext): FrameNode | null {
//     const column = typeNode.createNode(uiContext, 'Column');
//
//     // 创建相对容器
//     const relativeContainer = typeNode.createNode(uiContext, 'RelativeContainer');
//     relativeContainer.attribute
//       .height('100vp')
//       .backgroundColor('#1ff');
//
//     // 使用通用函数创建滚动行
//     const scrollRowA = this.createScrollRow(uiContext, 'A', '250px', '150px', this.visible == 'A');
//     const scrollRowB = this.createScrollRow(uiContext, 'B', '250px', '150px', this.visible == 'B');
//
//     relativeContainer.appendChild(scrollRowA);
//     relativeContainer.appendChild(scrollRowB);
//
//     // 创建切换按钮
//     const toggleButton = typeNode.createNode(uiContext, 'Button');
//     toggleButton.initialize('click to visible ' + (this.visible == 'A' ? 'B' : 'A'))
//       .onClick(() => {
//         this.visible = this.visible == 'A' ? 'B' : 'A';
//         // 更新按钮文本
//         toggleButton.initialize('click to visible ' + (this.visible == 'A' ? 'B' : 'A'));
//         // 更新可见性
//         scrollRowA.attribute.visibility(this.visible == 'A' ? Visibility.Visible : Visibility.Hidden);
//         scrollRowB.attribute.visibility(this.visible == 'B' ? Visibility.Visible : Visibility.Hidden);
//       });
//     column.appendChild(toggleButton);
//
//     column.appendChild(relativeContainer);
//
//     return column;
//   }
// }
