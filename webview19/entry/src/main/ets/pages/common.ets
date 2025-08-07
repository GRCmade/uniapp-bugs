// 创建NodeController
// common.ets
import webview from '@ohos.web.webview';

// @Builder中为动态组件的具体组件内容
// Data为入参封装类
class Data{
  url: ResourceStr = "";
  controller: webview.WebviewController = new webview.WebviewController();
}

@Builder
export function WebBuilder(data:Data) {
  Column() {
    Web({ src: data.url, controller: data.controller })
      .width("100%")
      .height("100%")
  }
}




