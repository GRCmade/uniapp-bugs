import { openBlock, createElementBlock, createElementVNode } from "vue";
import { _ as _export_sfc } from "../../../../_plugin-vue_export-helper.js";
const _sfc_main = {
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
  return openBlock(), createElementBlock("scroll-view", {
    scrollY: true,
    showScrollbar: true,
    enableBackToTop: true,
    bubble: "true",
    style: { flexDirection: "column" }
  }, [
    createElementVNode("view", null, [
      createElementVNode("map", {
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
const _196514 = /* @__PURE__ */ _export_sfc(_sfc_main, [["render", _sfc_render], ["__file", "/Users/gaoruicheng/Documents/DcloudProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-hello-test/pages/ask/problem/196514/196514.nvue"]]);
export {
  _196514 as default
};
