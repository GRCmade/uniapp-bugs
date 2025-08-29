import ohos_events_emitter from '@ohos.events.emitter';(function(vue, emitter) {
  "use strict";
  const harmonyEmiitter_utsProxy = uni.requireUTSPlugin("uni_modules/harmony-emiitter");
  const _sfc_main$1 = vue.defineComponent({
    data() {
      return {
        title: "Hello"
      };
    },
    onLoad() {
    },
    methods: {
      click2() {
        harmonyEmiitter_utsProxy.utsEmitter();
      },
      click() {
        uni.__f__("log", "at pages/index/index.uvue:24", "click");
        emitter.emit("launch", new UTSJSONObject({
          data: "launch - uniappx - button"
        }));
      }
    }
  });
  const _export_sfc = (sfc, props) => {
    const target = sfc.__vccOpts || sfc;
    for (const [key, val] of props) {
      target[key] = val;
    }
    return target;
  };
  function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock("view", null, [
      vue.createElementVNode("button", {
        onClick: _cache[0] || (_cache[0] = (...args) => $options.click && $options.click(...args))
      }, "click"),
      vue.createElementVNode("button", {
        onClick: _cache[1] || (_cache[1] = (...args) => $options.click2 && $options.click2(...args))
      }, "utsEmitter")
    ]);
  }
  const PagesIndexIndex = /* @__PURE__ */ _export_sfc(_sfc_main$1, [["render", _sfc_render]]);
  __definePage("pages/index/index", PagesIndexIndex);
  emitter.on("message", (data = null) => {
    uni.__f__("log", "at App.uvue:5", "message - uniappx:", data.data);
  });
  const _sfc_main = vue.defineComponent(new UTSJSONObject({
    onLaunch: function() {
      uni.__f__("log", "at App.uvue:11", "App Launch");
      emitter.emit("launch", new UTSJSONObject({
        data: "launch - uniappx"
      }));
    },
    onShow: function() {
      uni.__f__("log", "at App.uvue:17", "App Show");
    },
    onHide: function() {
      uni.__f__("log", "at App.uvue:20", "App Hide");
    },
    onExit: function() {
      uni.__f__("log", "at App.uvue:41", "App Exit");
    }
  }));
  const _style_0 = { "uni-row": { "": { "flexDirection": "row" } }, "uni-column": { "": { "flexDirection": "column" } } };
  const App = /* @__PURE__ */ _export_sfc(_sfc_main, [["styles", [_style_0]]]);
  const __global__ = typeof globalThis === "undefined" ? Function("return this")() : globalThis;
  __global__.__uniX = true;
  function createApp() {
    const app = vue.createSSRApp(App);
    return {
      app
    };
  }
  __global__.__mount__ = () => {
    createApp().app.mount("#app");
  };
})(Vue, ohos_events_emitter);
