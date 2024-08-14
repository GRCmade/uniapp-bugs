if (typeof Promise !== "undefined" && !Promise.prototype.finally) {
  Promise.prototype.finally = function(callback) {
    const promise = this.constructor;
    return this.then(
      (value) => promise.resolve(callback()).then(() => value),
      (reason) => promise.resolve(callback()).then(() => {
        throw reason;
      })
    );
  };
}
;
if (typeof uni !== "undefined" && uni && uni.requireGlobal) {
  const global = uni.requireGlobal();
  ArrayBuffer = global.ArrayBuffer;
  Int8Array = global.Int8Array;
  Uint8Array = global.Uint8Array;
  Uint8ClampedArray = global.Uint8ClampedArray;
  Int16Array = global.Int16Array;
  Uint16Array = global.Uint16Array;
  Int32Array = global.Int32Array;
  Uint32Array = global.Uint32Array;
  Float32Array = global.Float32Array;
  Float64Array = global.Float64Array;
  BigInt64Array = global.BigInt64Array;
  BigUint64Array = global.BigUint64Array;
}
;
if (uni.restoreGlobal) {
  uni.restoreGlobal(Vue, weex, plus, setTimeout, clearTimeout, setInterval, clearInterval);
}
(function(vue) {
  "use strict";
  function formatAppLog(type, filename, ...args) {
    if (uni.__log__) {
      uni.__log__(type, filename, ...args);
    } else {
      console[type].apply(console, [...args, filename]);
    }
  }
  const list = [{
    "day": "8月",
    "list": [196451, 196597]
  }];
  const _export_sfc = (sfc, props) => {
    const target = sfc.__vccOpts || sfc;
    for (const [key, val] of props) {
      target[key] = val;
    }
    return target;
  };
  const _sfc_main$4 = {
    data() {
      return {
        title: "Hello",
        ls: list
      };
    },
    onLoad() {
    },
    methods: {
      click(id) {
        const prefixPattern = /^docisue/;
        if (prefixPattern.test(id)) {
          const str = `/pages/ask/doc/${id}/${id}`;
          formatAppLog("log", "at pages/index/index.vue:33", str);
          uni.navigateTo({
            url: str
          });
        } else {
          const str = `/pages/ask/${id}/${id}`;
          formatAppLog("log", "at pages/index/index.vue:39", str);
          uni.navigateTo({
            url: str
          });
        }
      }
    }
  };
  function _sfc_render$3(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock("view", null, [
      (vue.openBlock(true), vue.createElementBlock(
        vue.Fragment,
        null,
        vue.renderList($data.ls, (it, i) => {
          return vue.openBlock(), vue.createElementBlock("view", { key: i }, [
            vue.createElementVNode(
              "view",
              { class: "title" },
              vue.toDisplayString(it.day),
              1
              /* TEXT */
            ),
            vue.createElementVNode("view", { class: "box" }, [
              (vue.openBlock(true), vue.createElementBlock(
                vue.Fragment,
                null,
                vue.renderList(it.list, (item, index) => {
                  return vue.openBlock(), vue.createElementBlock("view", { key: index }, [
                    vue.createElementVNode("button", {
                      onClick: ($event) => $options.click(item),
                      size: "mini",
                      type: "primary"
                    }, vue.toDisplayString(item), 9, ["onClick"])
                  ]);
                }),
                128
                /* KEYED_FRAGMENT */
              ))
            ])
          ]);
        }),
        128
        /* KEYED_FRAGMENT */
      ))
    ]);
  }
  const PagesIndexIndex = /* @__PURE__ */ _export_sfc(_sfc_main$4, [["render", _sfc_render$3], ["__file", "/Users/gaoruicheng/Documents/DcloudProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-harmony/pages/index/index.vue"]]);
  const _sfc_main$3 = {
    data() {
      return {};
    },
    methods: {}
  };
  function _sfc_render$2(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock("view", null, [
      vue.createElementVNode("view", { class: "" }, "webview"),
      vue.createElementVNode("web-view", { src: "http://192.168.31.67:5173/mac/" })
    ]);
  }
  const PagesAsk196265196265 = /* @__PURE__ */ _export_sfc(_sfc_main$3, [["render", _sfc_render$2], ["__file", "/Users/gaoruicheng/Documents/DcloudProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-harmony/pages/ask/196265/196265.vue"]]);
  const _sfc_main$2 = {
    data() {
      return {};
    },
    onShow() {
      formatAppLog("error", "at pages/ask/196451/196451.vue:15", "-------onShow-----");
    },
    methods: {}
  };
  function _sfc_render$1(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock("view");
  }
  const PagesAsk196451196451 = /* @__PURE__ */ _export_sfc(_sfc_main$2, [["render", _sfc_render$1], ["__file", "/Users/gaoruicheng/Documents/DcloudProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-harmony/pages/ask/196451/196451.vue"]]);
  const _sfc_main$1 = {
    data() {
      return {};
    },
    onLoad() {
    },
    methods: {
      showtoast() {
        uni.showToast({
          icon: "none",
          position: "bottom",
          title: "123"
        });
      },
      setClipboardData() {
        uni.setClipboardData({
          data: "2222",
          showToast: true,
          success(e) {
            formatAppLog("log", "at pages/ask/196597/196597.vue:32", "success");
          },
          fail(e) {
            formatAppLog("log", "at pages/ask/196597/196597.vue:35", e);
          }
        });
      }
    }
  };
  function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock("view", null, [
      vue.createElementVNode("button", {
        onClick: _cache[0] || (_cache[0] = (...args) => $options.showtoast && $options.showtoast(...args))
      }, "showtoast"),
      vue.createElementVNode("button", {
        onClick: _cache[1] || (_cache[1] = (...args) => $options.setClipboardData && $options.setClipboardData(...args))
      }, "setClipboardData")
    ]);
  }
  const PagesAsk196597196597 = /* @__PURE__ */ _export_sfc(_sfc_main$1, [["render", _sfc_render], ["__file", "/Users/gaoruicheng/Documents/DcloudProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-harmony/pages/ask/196597/196597.vue"]]);
  __definePage("pages/index/index", PagesIndexIndex);
  __definePage("pages/ask/196265/196265", PagesAsk196265196265);
  __definePage("pages/ask/196451/196451", PagesAsk196451196451);
  __definePage("pages/ask/196597/196597", PagesAsk196597196597);
  const _sfc_main = {
    onLaunch: function() {
      formatAppLog("log", "at App.vue:4", "App Launch");
    },
    onShow: function() {
      formatAppLog("log", "at App.vue:7", "App Show");
    },
    onHide: function() {
      formatAppLog("log", "at App.vue:10", "App Hide");
    }
  };
  const App = /* @__PURE__ */ _export_sfc(_sfc_main, [["__file", "/Users/gaoruicheng/Documents/DcloudProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-harmony/App.vue"]]);
  function createApp() {
    const app = vue.createVueApp(App);
    return {
      app
    };
  }
  const { app: __app__, Vuex: __Vuex__, Pinia: __Pinia__ } = createApp();
  uni.Vuex = __Vuex__;
  uni.Pinia = __Pinia__;
  __app__.provide("__globalStyles", __uniConfig.styles);
  __app__._component.mpType = "app";
  __app__._component.render = () => {
  };
  __app__.mount("#app");
})(Vue);
