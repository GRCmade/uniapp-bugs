"use strict";
const common_vendor = require("../../../../common/vendor.js");
const componentVue = () => "./component.js";
const _sfc_main = {
  components: {
    "components": componentVue
  },
  data() {
    return {};
  },
  onLoad() {
    console.log("196568", getCurrentPages());
  },
  methods: {}
};
if (!Array) {
  const _component_components = common_vendor.resolveComponent("components");
  _component_components();
}
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: common_vendor.p({
      a: "66"
    })
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createPage(MiniProgramPage);
