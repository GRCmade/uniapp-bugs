import webview from '@ohos.web.webview';
import harmonyWebview from '@ohos.web.webview';
// import { UIContext, Size, FrameNode } from '@kit.ArkUI';
import { NodeController, BuilderNode, NodeRenderType } from "@ohos.arkui.node";


var OSRuntime;

function getOSRuntime() {
  return OSRuntime;
}

function setOSRuntime(options) {
  OSRuntime = options;
}

export const init = () => {
  harmonyWebview.WebviewController.setWebDebuggingAccess(true)
}

// 用于控制和反馈对应的NodeContainer上的节点的行为，需要与NodeContainer一起使用
export class myNodeController extends NodeController {
  rootnode = null;

  // 必须要重写的方法，用于构建节点数、返回节点挂载在对应NodeContainer中
  // 在对应NodeContainer创建的时候调用、或者通过rebuild方法调用刷新
  makeNode(uiContext) {
    console.log(" uicontext is undefined : " + (uiContext === undefined));
    if (this.rootnode != null) {
      // 返回FrameNode节点
      return this.rootnode.getFrameNode();
    }
    // 返回null控制动态组件脱离绑定节点
    return null;
  }

  // 当布局大小发生变化时进行回调
  aboutToResize(size) {
    console.log("aboutToResize width : " + size.width + " height : " + size.height);
  }

  // 当controller对应的NodeContainer在Appear的时候进行回调
  aboutToAppear() {
    console.log("aboutToAppear");
  }

  // 当controller对应的NodeContainer在Disappear的时候进行回调
  aboutToDisappear() {
    console.log("aboutToDisappear");
  }

  // 此函数为自定义函数，可作为初始化函数使用
  // 通过UIContext初始化BuilderNode，再通过BuilderNode中的build接口初始化@Builder中的内容
  initWeb(url, uiContext, controller, javaScriptProxy) {
    if (this.rootnode != null) {
      return;
    }
    // 创建节点，需要uiContext
    this.rootnode = new BuilderNode(uiContext);
    // 创建动态Web组件
    let wrap = wrapBuilder(getOSRuntime().WebBuilder);

    this.rootnode.build(wrap, {
      src: url,
      controller: controller,
      javaScriptProxy: javaScriptProxy,
      onControllerAttached: () => {
        console.log("yuhe - onControllerAttached")
      }
    });
  }
}

// 创建Map保存所需要的NodeController
let NodeMap = new Map();
// 创建Map保存所需要的WebViewController
let controllerMap = new Map();

// 初始化需要UIContext，需在Ability获取
export const createNWeb = (url, uiContext) => {
  // 创建NodeController
  let baseNode = new myNodeController();
  const controller = new webview.WebviewController();
  const javaScriptProxy = {
    object: {},
    name: "",
    name: "JS_REGISTER_NAME",
    methodList: ["invokeSync"],
    controller
  }
  console.log("onControllerAttached", controller.getWebDebuggingAccess())
  // 初始化自定义Web组件
  baseNode.initWeb(url, uiContext, controller, javaScriptProxy);
  controllerMap.set(url, controller)
  NodeMap.set(url, baseNode);
}

// 自定义获取NodeController接口
export const getNWeb = (url) => {
  return NodeMap.get(url);
}

export { setOSRuntime, getOSRuntime }
