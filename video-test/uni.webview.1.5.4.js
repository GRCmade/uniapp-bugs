(function (global, factory) {
  typeof exports === 'object' && typeof module !== 'undefined' ? module.exports = factory() :
  typeof define === 'function' && define.amd ? define(factory) :
  (global = global || self, global.uni = factory());
}(this, (function () { 'use strict';

  var supportsPassive = false;
  try {
    var opts = {};
    Object.defineProperty(opts, 'passive', {
      get: function get() {
        /* istanbul ignore next */
        supportsPassive = true;
      }
    }); // https://github.com/facebook/flow/issues/285
    window.addEventListener('test-passive', null, opts);
  } catch (e) {}

  var hasOwnProperty = Object.prototype.hasOwnProperty;
  function hasOwn(obj, key) {
    return hasOwnProperty.call(obj, key);
  }

  var webviewIds = [];
  var UNIAPP_SERVICE_NVUE_ID = '__uniapp__service';
  var WEB_INVOKE_APPSERVICE = 'WEB_INVOKE_APPSERVICE';
  function isNvue() {
    return window.__dcloud_weex_postMessage || window.__dcloud_weex_;
  }
  function isUvue() {
    return window.__uniapp_x_postMessage || window.__uniapp_x_;
  }
  var publish = function publish(method, params) {
    var paramsObj = {
      options: {
        timestamp: +new Date()
      },
      name: method,
      arg: params
    };
    if (isUvue()) {
      // uvue web-view
      if (method === 'postMessage') {
        var message = {
          data: params
        };
        if (window.__uniapp_x_postMessage) {
          return window.__uniapp_x_postMessage(message);
        } else {
          return window.__uniapp_x_.postMessage(JSON.stringify(message));
        }
      }
      var serviceMessage = {
        type: WEB_INVOKE_APPSERVICE,
        args: {
          data: paramsObj,
          webviewIds: webviewIds
        }
      };
      if (window.__uniapp_x_postMessage) {
        window.__uniapp_x_postMessageToService(serviceMessage);
      } else {
        window.__uniapp_x_.postMessageToService(JSON.stringify(serviceMessage));
      }
      return;
    }
    if (isNvue()) {
      // nvue web-view
      if (method === 'postMessage') {
        var _message = {
          data: [params]
        };
        if (window.__dcloud_weex_postMessage) {
          return window.__dcloud_weex_postMessage(_message);
        } else {
          return window.__dcloud_weex_.postMessage(JSON.stringify(_message));
        }
      }
      var _serviceMessage = {
        type: WEB_INVOKE_APPSERVICE,
        args: {
          data: paramsObj,
          webviewIds: webviewIds
        }
      };
      if (window.__dcloud_weex_postMessage) {
        window.__dcloud_weex_postMessageToService(_serviceMessage);
      } else {
        window.__dcloud_weex_.postMessageToService(JSON.stringify(_serviceMessage));
      }
      return;
    }
    if (!window.plus) {
      // h5 web-view
      return window.parent.postMessage({
        type: WEB_INVOKE_APPSERVICE,
        data: paramsObj,
        pageId: ''
      }, '*');
    }

    // app-plus
    if (webviewIds.length === 0) {
      var currentWebview = plus.webview.currentWebview();
      if (!currentWebview) {
        throw new Error('plus.webview.currentWebview() is undefined');
      }
      var parentWebview = currentWebview.parent();
      var webviewId = '';
      if (!parentWebview) {
        webviewId = currentWebview.id;
        // throw new Error('plus.webview.currentWebview().parent() is undefined')
      } else {
        webviewId = parentWebview.id;
      }
      webviewIds.push(webviewId);
    }
    if (plus.webview.getWebviewById(UNIAPP_SERVICE_NVUE_ID)) {
      plus.webview.postMessageToUniNView({
        type: WEB_INVOKE_APPSERVICE,
        args: {
          data: paramsObj,
          webviewIds: webviewIds
        }
      }, UNIAPP_SERVICE_NVUE_ID);
    } else {
      var paramsString = JSON.stringify(paramsObj);
      plus.webview.getLaunchWebview().evalJS("UniPlusBridge.subscribeHandler(\"".concat(WEB_INVOKE_APPSERVICE, "\",").concat(paramsString, ",").concat(JSON.stringify(webviewIds), ");"));
    }
  };
  var api = {
    navigateTo: function navigateTo() {
      var _ref = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {},
        url = _ref.url;
      publish('navigateTo', {
        url: encodeURI(url)
      });
    },
    navigateBack: function navigateBack() {
      var _ref2 = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {},
        delta = _ref2.delta;
      publish('navigateBack', {
        delta: parseInt(delta) || 1
      });
    },
    switchTab: function switchTab() {
      var _ref3 = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {},
        url = _ref3.url;
      publish('switchTab', {
        url: encodeURI(url)
      });
    },
    reLaunch: function reLaunch() {
      var _ref4 = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {},
        url = _ref4.url;
      publish('reLaunch', {
        url: encodeURI(url)
      });
    },
    redirectTo: function redirectTo() {
      var _ref5 = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {},
        url = _ref5.url;
      publish('redirectTo', {
        url: encodeURI(url)
      });
    },
    getEnv: function getEnv(callback) {
      /* eslint-disable standard/no-callback-literal */
      if (isUvue()) {
        callback({
          uvue: true
        });
      } else if (isNvue()) {
        callback({
          nvue: true
        });
      } else if (window.plus) {
        callback({
          plus: true
        });
      } else {
        callback({
          h5: true
        });
      }
    },
    postMessage: function postMessage() {
      var params = arguments.length > 0 && arguments[0] !== undefined ? arguments[0] : {};
      publish('postMessage', params.data || {});
    }
  };

  var isAppPlus = /uni-app/i.test(navigator.userAgent);
  var isHtml5Plus = /Html5Plus/i.test(navigator.userAgent);
  var readyRE = /complete|loaded|interactive/;
  function initWebviewApi(readyCallback) {
    if (!isAppPlus && !isHtml5Plus) {
      return;
    }
    if (window.__uniapp_x_postMessage || window.__uniapp_x_) {
      // uvue web-view
      document.addEventListener('DOMContentLoaded', readyCallback);
    } else if (window.__dcloud_weex_postMessage || window.__dcloud_weex_) {
      // nvue web-view
      document.addEventListener('DOMContentLoaded', readyCallback);
    } else if (window.plus && readyRE.test(document.readyState)) {
      setTimeout(readyCallback, 0);
    } else {
      document.addEventListener('plusready', readyCallback);
    }
    return api;
  }

  function initWebviewApi$1(readyCallback) {
    document.addEventListener('DOMContentLoaded', readyCallback);
    return api;
  }

  var AC = ['t', 'n', 'e', 'i', 'l', 'C', 'y', 'a', 'p', 'i', 'l', 'A'];
  var isAlipay = window.my && navigator.userAgent.indexOf(AC.reverse().join('')) > -1;
  function initWebviewApi$2(readyCallback) {
    if (!isAlipay) {
      return;
    }
    document.addEventListener('DOMContentLoaded', readyCallback);
    var _window$my = window.my,
      navigateTo = _window$my.navigateTo,
      navigateBack = _window$my.navigateBack,
      switchTab = _window$my.switchTab,
      reLaunch = _window$my.reLaunch,
      redirectTo = _window$my.redirectTo,
      postMessage = _window$my.postMessage,
      getEnv = _window$my.getEnv;
    return {
      navigateTo: navigateTo,
      navigateBack: navigateBack,
      switchTab: switchTab,
      reLaunch: reLaunch,
      redirectTo: redirectTo,
      postMessage: postMessage,
      getEnv: getEnv
    };
  }

  var isBaidu = window.swan && window.swan.webView && /swan/i.test(navigator.userAgent);
  function initWebviewApi$3(readyCallback) {
    if (!isBaidu) {
      return;
    }
    document.addEventListener('DOMContentLoaded', readyCallback);
    return window.swan.webView;
  }

  var isQQ = window.qq && window.qq.miniProgram && /QQ/i.test(navigator.userAgent) && /miniProgram/i.test(navigator.userAgent);
  function initWebviewApi$4(readyCallback) {
    if (!isQQ) {
      return;
    }
    if (window.QQJSBridge && window.QQJSBridge.invoke) {
      setTimeout(readyCallback, 0);
    } else {
      document.addEventListener('QQJSBridgeReady', readyCallback);
    }
    return window.qq.miniProgram;
  }

  var isToutiao = window.tt && window.tt.miniProgram && /toutiaomicroapp/i.test(navigator.userAgent);
  function initWebviewApi$5(readyCallback) {
    if (!isToutiao) {
      return;
    }
    document.addEventListener('DOMContentLoaded', readyCallback);
    return window.tt.miniProgram;
  }

  var isWeixin = window.wx && window.wx.miniProgram && /micromessenger/i.test(navigator.userAgent) && /miniProgram/i.test(navigator.userAgent);
  function initWebviewApi$6(readyCallback) {
    if (!isWeixin) {
      return;
    }
    if (window.WeixinJSBridge && window.WeixinJSBridge.invoke) {
      setTimeout(readyCallback, 0);
    } else {
      document.addEventListener('WeixinJSBridgeReady', readyCallback);
    }
    return window.wx.miniProgram;
  }

  var isQuickapp = window.qa && /quickapp/i.test(navigator.userAgent);
  function initWebviewApi$7(readyCallback) {
    if (!isQuickapp) {
      return;
    }
    if (window.QaJSBridge && window.QaJSBridge.invoke) {
      setTimeout(readyCallback, 0);
    } else {
      document.addEventListener('QaJSBridgeReady', readyCallback);
    }
    var _window$qa = window.qa,
      navigateTo = _window$qa.navigateTo,
      navigateBack = _window$qa.navigateBack,
      switchTab = _window$qa.switchTab,
      reLaunch = _window$qa.reLaunch,
      redirectTo = _window$qa.redirectTo,
      postMessage = _window$qa.postMessage,
      getEnv = _window$qa.getEnv;
    return {
      navigateTo: navigateTo,
      navigateBack: navigateBack,
      switchTab: switchTab,
      reLaunch: reLaunch,
      redirectTo: redirectTo,
      postMessage: postMessage,
      getEnv: getEnv
    };
  }

  var isQuickapp$1 = window.qa && /quickapp/i.test(navigator.userAgent);
  function initWebviewApi$8(readyCallback) {
    if (!isQuickapp$1) {
      return;
    }
    if (window.QaJSBridge && window.QaJSBridge.invoke) {
      setTimeout(readyCallback, 0);
    } else {
      document.addEventListener('QaJSBridgeReady', readyCallback);
    }
    var _window$qa = window.qa,
      navigateTo = _window$qa.navigateTo,
      navigateBack = _window$qa.navigateBack,
      switchTab = _window$qa.switchTab,
      reLaunch = _window$qa.reLaunch,
      redirectTo = _window$qa.redirectTo,
      postMessage = _window$qa.postMessage,
      getEnv = _window$qa.getEnv;
    return {
      navigateTo: navigateTo,
      navigateBack: navigateBack,
      switchTab: switchTab,
      reLaunch: reLaunch,
      redirectTo: redirectTo,
      postMessage: postMessage,
      getEnv: getEnv
    };
  }

  var isKuaishou = window.ks && window.ks.miniProgram && /micromessenger/i.test(navigator.userAgent) && /miniProgram/i.test(navigator.userAgent);
  function initWebviewApi$9(readyCallback) {
    if (!isKuaishou) {
      return;
    }
    if (window.WeixinJSBridge && window.WeixinJSBridge.invoke) {
      setTimeout(readyCallback, 0);
    } else {
      document.addEventListener('WeixinJSBridgeReady', readyCallback);
    }
    return window.ks.miniProgram;
  }

  var isLark = window.tt && window.tt.miniProgram && /Lark|Feishu/i.test(navigator.userAgent);
  function initWebviewApi$a(readyCallback) {
    if (!isLark) {
      return;
    }
    document.addEventListener('DOMContentLoaded', readyCallback);
    return window.tt.miniProgram;
  }

  var isJD = window.jd && window.jd.miniProgram && /jdmp/i.test(navigator.userAgent);
  function initWebviewApi$b(readyCallback) {
    if (!isJD) {
      return;
    }
    if (window.JDJSBridgeReady && window.JDJSBridgeReady.invoke) {
      setTimeout(readyCallback, 0);
    } else {
      document.addEventListener('JDJSBridgeReady', readyCallback);
    }
    return window.jd.miniProgram;
  }

  var isXhs = window.xhs && window.xhs.miniProgram && /xhsminiapp/i.test(navigator.userAgent);
  function initWebviewApi$c(readyCallback) {
    if (!isXhs) {
      return;
    }
    // todo 没有 XhsJSBridgeReady
    // if (window.XhsJSBridgeReady && window.XhsJSBridgeReady.invoke) {
    //   setTimeout(readyCallback, 0)
    // } else {
    //   document.addEventListener('XhsJSBridgeReady', readyCallback)
    // }

    return window.xhs.miniProgram;
  }

  var UniAppJSBridgeReady = function UniAppJSBridgeReady() {
    window.UniAppJSBridge = true;
    document.dispatchEvent(new CustomEvent('UniAppJSBridgeReady', {
      bubbles: true,
      cancelable: true
    }));
  };
  var initWebviewApis = [initWebviewApi, initWebviewApi$6, initWebviewApi$4, initWebviewApi$2, initWebviewApi$3, initWebviewApi$5, initWebviewApi$7, initWebviewApi$8, initWebviewApi$9, initWebviewApi$a, initWebviewApi$b, initWebviewApi$c, initWebviewApi$1];
  var webViewApi;
  for (var i = 0; i < initWebviewApis.length; i++) {
    webViewApi = initWebviewApis[i](UniAppJSBridgeReady);
    if (webViewApi) {
      break;
    }
  }
  if (!webViewApi) {
    webViewApi = {};
  }
  var api$1 = typeof uni !== 'undefined' ? uni : {};
  if (!api$1.navigateTo) {
    for (var key in webViewApi) {
      if (hasOwn(webViewApi, key)) {
        api$1[key] = webViewApi[key];
      }
    }
  }
  api$1.webView = webViewApi;

  return api$1;

})));
