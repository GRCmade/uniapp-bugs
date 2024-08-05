"use strict";
const common_vendor = require("../../common/vendor.js");
const _sfc_main = {
  data() {
    return {
      title: "Hello",
      msgContentNodes: [{
        "name": "p",
        "attrs": {
          "style": "font-size:15px;text-align: justify;line-heihgt:19;"
        },
        "children": [{
          "name": "p",
          "attrs": {
            "style": "color:#7a7a7a;"
          },
          "children": [{
            "type": "text",
            "text": "测试文案。"
          }]
        }]
      }]
    };
  },
  onLoad() {
  },
  methods: {}
};
if (!Array) {
  const _component_cell = common_vendor.resolveComponent("cell");
  const _component_list = common_vendor.resolveComponent("list");
  (_component_cell + _component_list)();
}
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: common_vendor.f(100, (item, index, i0) => {
      return {
        a: "2dcee698-1-" + i0 + ",2dcee698-0"
      };
    }),
    b: $data.msgContentNodes
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createPage(MiniProgramPage);
