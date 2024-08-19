"use strict";
const common_vendor = require("../../../../common/vendor.js");
const _sfc_main = {
  data() {
    return {
      input: ""
    };
  },
  methods: {
    inputInput(e) {
      console.log(e);
    },
    inputConfirm(e) {
      console.log("confirm", e);
    }
  }
};
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: common_vendor.o([($event) => $data.input = $event.detail.value, (...args) => $options.inputInput && $options.inputInput(...args)]),
    b: common_vendor.o((...args) => $options.inputConfirm && $options.inputConfirm(...args)),
    c: $data.input
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createPage(MiniProgramPage);
