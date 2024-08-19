import { openBlock, createElementBlock, createElementVNode } from "vue";
import { _ as _export_sfc } from "../../../../_plugin-vue_export-helper.js";
const _style_0 = { "webview": { "": { "width": 200, "height": 1e3 } } };
const _sfc_main = {
  data() {
    return {};
  },
  methods: {}
};
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return openBlock(), createElementBlock("scroll-view", {
    scrollY: true,
    showScrollbar: true,
    enableBackToTop: true,
    bubble: "true",
    style: { flexDirection: "column" }
  }, [
    createElementVNode("view", null, [
      createElementVNode("u-web-view", {
        class: "webview",
        src: "http://dcloud.yuhe.space/#/"
      })
    ])
  ]);
}
const _196704 = /* @__PURE__ */ _export_sfc(_sfc_main, [["render", _sfc_render], ["styles", [_style_0]], ["__file", "/Users/gaoruicheng/Documents/DcloudProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-hello-test/pages/ask/problem/196704/196704.nvue"]]);
export {
  _196704 as default
};
