"use weex:vue";

if (typeof Promise !== 'undefined' && !Promise.prototype.finally) {
  Promise.prototype.finally = function(callback) {
    const promise = this.constructor
    return this.then(
      value => promise.resolve(callback()).then(() => value),
      reason => promise.resolve(callback()).then(() => {
        throw reason
      })
    )
  }
};

if (typeof uni !== 'undefined' && uni && uni.requireGlobal) {
  const global = uni.requireGlobal()
  ArrayBuffer = global.ArrayBuffer
  Int8Array = global.Int8Array
  Uint8Array = global.Uint8Array
  Uint8ClampedArray = global.Uint8ClampedArray
  Int16Array = global.Int16Array
  Uint16Array = global.Uint16Array
  Int32Array = global.Int32Array
  Uint32Array = global.Uint32Array
  Float32Array = global.Float32Array
  Float64Array = global.Float64Array
  BigInt64Array = global.BigInt64Array
  BigUint64Array = global.BigUint64Array
};


(() => {
  var __create = Object.create;
  var __defProp = Object.defineProperty;
  var __getOwnPropDesc = Object.getOwnPropertyDescriptor;
  var __getOwnPropNames = Object.getOwnPropertyNames;
  var __getProtoOf = Object.getPrototypeOf;
  var __hasOwnProp = Object.prototype.hasOwnProperty;
  var __commonJS = (cb, mod) => function __require() {
    return mod || (0, cb[__getOwnPropNames(cb)[0]])((mod = { exports: {} }).exports, mod), mod.exports;
  };
  var __copyProps = (to, from, except, desc) => {
    if (from && typeof from === "object" || typeof from === "function") {
      for (let key of __getOwnPropNames(from))
        if (!__hasOwnProp.call(to, key) && key !== except)
          __defProp(to, key, { get: () => from[key], enumerable: !(desc = __getOwnPropDesc(from, key)) || desc.enumerable });
    }
    return to;
  };
  var __toESM = (mod, isNodeMode, target) => (target = mod != null ? __create(__getProtoOf(mod)) : {}, __copyProps(
    // If the importer is in node compatibility mode or this is not an ESM
    // file that has been converted to a CommonJS file using a Babel-
    // compatible transform (i.e. "__esModule" has not been set), then set
    // "default" to the CommonJS "module.exports" for node compatibility.
    isNodeMode || !mod || !mod.__esModule ? __defProp(target, "default", { value: mod, enumerable: true }) : target,
    mod
  ));

  // vue-ns:vue
  var require_vue = __commonJS({
    "vue-ns:vue"(exports, module) {
      module.exports = Vue;
    }
  });

  // ../../../../../../Users/gaoruicheng/Documents/DcloudProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-hello-test/unpackage/dist/dev/.nvue/pages/ask/problem/196514/196514.js
  var import_vue = __toESM(require_vue());

  // ../../../../../../Users/gaoruicheng/Documents/DcloudProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-hello-test/unpackage/dist/dev/.nvue/_plugin-vue_export-helper.js
  var _export_sfc = (sfc, props) => {
    const target = sfc.__vccOpts || sfc;
    for (const [key, val] of props) {
      target[key] = val;
    }
    return target;
  };

  // ../../../../../../Users/gaoruicheng/Documents/DcloudProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-hello-test/unpackage/dist/dev/.nvue/pages/ask/problem/196514/196514.js
  var _sfc_main = {
    data() {
      return {
        polyline: [{
          points: [
            {
              longitude: 116.397128,
              latitude: 39.916527
            },
            {
              longitude: 116.197128,
              latitude: 39.916527
            }
          ],
          width: 100,
          dottedLine: false,
          arrowLine: true
          // 显示箭头
        }]
      };
    }
  };
  function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
    return (0, import_vue.openBlock)(), (0, import_vue.createElementBlock)("scroll-view", {
      scrollY: true,
      showScrollbar: true,
      enableBackToTop: true,
      bubble: "true",
      style: { flexDirection: "column" }
    }, [
      (0, import_vue.createElementVNode)("view", null, [
        (0, import_vue.createElementVNode)("map", {
          style: { "width": "100%", "height": "94vh" },
          longitude: "116.397128",
          latitude: "39.916527",
          scale: "14",
          polyline: $data.polyline,
          showLocation: ""
        }, null, 8, ["polyline"])
      ])
    ]);
  }
  var _196514 = /* @__PURE__ */ _export_sfc(_sfc_main, [["render", _sfc_render], ["__file", "/Users/gaoruicheng/Documents/DcloudProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-hello-test/pages/ask/problem/196514/196514.nvue"]]);

  // <stdin>
  var webview = plus.webview.currentWebview();
  if (webview) {
    const __pageId = parseInt(webview.id);
    const __pagePath = "pages/ask/problem/196514/196514";
    let __pageQuery = {};
    try {
      __pageQuery = JSON.parse(webview.__query__);
    } catch (e) {
    }
    _196514.mpType = "page";
    const app = Vue.createPageApp(_196514, { $store: getApp({ allowDefault: true }).$store, __pageId, __pagePath, __pageQuery });
    app.provide("__globalStyles", Vue.useCssStyles([...__uniConfig.styles, ..._196514.styles || []]));
    app.mount("#root");
  }
})();
