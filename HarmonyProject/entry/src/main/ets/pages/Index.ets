import { openUniApp } from '@dcloudio/uni-app-x-runtime'

import emitter from '@ohos.events.emitter'

emitter.on('launch', (data) => {
  console.log('launch - harmony:', JSON.stringify(data))

  emitter.emit('message', {
    data: 'hello - harmony'
  })
})

@Entry
@Component
struct Index {
  build() {
    RelativeContainer() {
      Button('Open')
        .onClick(() => {
          openUniApp('__UNI__6035534', {
            animationType: 'fade-in',
          })
        })
    }
    .height('100%')
    .width('100%')
  }
}
