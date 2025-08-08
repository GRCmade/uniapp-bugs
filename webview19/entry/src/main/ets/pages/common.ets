// 创建NodeController
// common.ets
import webview from '@ohos.web.webview';

// @Builder中为动态组件的具体组件内容
// Data为入参封装类
// class Data{
//   src: ResourceStr = "";
//   controller: webview.WebviewController = new webview.WebviewController();
// }
//
// @Builder
// export function WebBuilder(data:Data) {
//   Column() {
//     Web({ src: data.src, controller: data.controller })
//       .width("100%")
//       .height("100%")
//   }
// }

interface JavaScriptProxy {
  object: object;
  name: string;
  methodList: Array<string>;
  controller: WebviewController;
}

interface  WebBuilderOptions extends WebOptions{
  controller: webview.WebviewController;
  javaScriptProxy?: JavaScriptProxy;
  onControllerAttached: () => void;
}

@Builder
export function WebBuilder(options:WebBuilderOptions) {
  Column() {
    Web(options)
      .width("100%")
      .height("100%")
      .javaScriptProxy(options.javaScriptProxy)
      .onDisAppear(() => {
        webview.WebCookieManager.saveCookieAsync()
      })
      .onControllerAttached(options.onControllerAttached)
  }
}




