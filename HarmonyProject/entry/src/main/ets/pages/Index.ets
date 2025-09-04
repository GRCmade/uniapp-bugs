import hilog from '@ohos.hilog';
import { NodeController, typeNode } from '@kit.ArkUI';

// @Entry
// @Component
// struct Index {
//   scroller: Scroller = new Scroller();
//   @State message: string = 'Hello World';
//   @State visible: string = 'A';
//
//   build() {
//     Column(){
//       Button('click to visible '+ (this.visible == 'A'?'B':'A'))
//         .onClick(()=>{
//           this.visible = this.visible == 'A' ? 'B' : 'A'
//         })
//       RelativeContainer(){
//         Row(){
//           Scroll(this.scroller){
//             Button('A').onClick(()=>{
//               hilog.info(0x100,'1','A')
//             })
//           }
//           .position({
//             left:0,
//             top:0
//           })
//           .visibility(this.visible == 'A' ? Visibility.Visible : Visibility.Hidden)
//           .width('50vp')
//           .height('80vp')
//           .backgroundColor('#000')
//         }
//         Row(){
//           Scroll(this.scroller){
//             Button('B').onClick(()=>{
//               hilog.info(0x100,'1','B')
//             })
//           }
//           .visibility(this.visible == 'B' ? Visibility.Visible : Visibility.Hidden)
//           .width('80vp')
//           .height('50vp')
//           .position({
//             left:0,
//             top:0
//           })
//         }
//       }
//       .height('100vp')
//       .backgroundColor('#1ff')
//     }
//   }
// }

@Entry
@Component
struct Index {
  @State views: Array<Array<number>> = [];

  build() {
    RelativeContainer() {
      NodeContainer(new CustomNodeController())
    }
    .height('100%')
    .width('100%')
  }
}

class CustomNodeController extends NodeController {
  makeNode(uiContext: UIContext): FrameNode | null {
    const column = typeNode.createNode(uiContext, 'Column');
    column.attribute.alignItems(HorizontalAlign.Start)
    const button1 = typeNode.createNode(uiContext, 'Button');
    button1.initialize('Add')
      .width('100%')
      .onClick(() => {
        for (let i = 0; i < 50; i++) {
          const row = typeNode.createNode(uiContext, 'Flex');
          row.initialize({
            direction: FlexDirection.Row,
          })
          for (let j = 0; j < 40; j++) {
            const column = typeNode.createNode(uiContext, 'Flex')
            column.initialize({
              direction: FlexDirection.Column,
            })
            column.attribute
              .backgroundColor('#85d8b4')
              .margin('0.5vp')
              .height('auto')
            const text = typeNode.createNode(uiContext, 'Text');
            text.initialize(j.toString())
              .fontSize('5vp')
              .lineHeight('5vp')
            column.appendChild(text);
            row.appendChild(column);
          }
          column.appendChild(row);
        }
      })
    column.appendChild(button1);
    const button2 = typeNode.createNode(uiContext, 'Button');
    button2.initialize('Clean')
      .width('100%')
      .onClick(() => {
        const l = column.getChildrenCount()
        for (let i = l - 1; i >= 2; i--) {
          const child = column.getChild(i);
          if (child) {
            column.removeChild(child);
          }
        }
      })
    column.appendChild(button2);
    return column;
  }
}
