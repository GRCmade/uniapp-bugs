(function(vue) {
  "use strict";
  const _sfc_main$1 = vue.defineComponent({
    data() {
      return {
        title: "Hello"
      };
    },
    onLoad() {
    },
    methods: {}
  });
  const _imports_0 = "/static/logo.png";
  const _style_0$1 = { "logo": { "": { "height": 100, "width": 100, "marginTop": 100, "marginRight": "auto", "marginBottom": 25, "marginLeft": "auto" } }, "title": { "": { "fontSize": 18, "color": "#8f8f94", "textAlign": "center" } } };
  const _export_sfc = (sfc, props) => {
    const target = sfc.__vccOpts || sfc;
    for (const [key, val] of props) {
      target[key] = val;
    }
    return target;
  };
  function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock("view", null, [
      vue.createElementVNode("image", {
        class: "logo",
        src: _imports_0
      }),
      vue.createElementVNode("text", { class: "title" }, vue.toDisplayString($data.title), 1)
    ]);
  }
  const PagesIndexIndex = /* @__PURE__ */ _export_sfc(_sfc_main$1, [["render", _sfc_render], ["styles", [_style_0$1]]]);
  __definePage("pages/index/index", PagesIndexIndex);
  const _sfc_main = vue.defineComponent(new UTSJSONObject({
    onLaunch: function() {
      uni.__f__("log", "at App.uvue:5", "App Launch");
    },
    onShow: function() {
      uni.__f__("log", "at App.uvue:8", "App Show");
    },
    onHide: function() {
      uni.__f__("log", "at App.uvue:11", "App Hide");
    },
    onExit: function() {
      uni.__f__("log", "at App.uvue:32", "App Exit");
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
})(Vue);
