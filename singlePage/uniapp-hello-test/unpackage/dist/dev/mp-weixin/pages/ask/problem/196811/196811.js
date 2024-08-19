"use strict";
const common_vendor = require("../../../../common/vendor.js");
const _sfc_main = {
  data() {
    return {};
  },
  methods: {
    click() {
      common_vendor.index.request({
        url: "https://fc-mp-701e6f43-b3d1-467b-be68-d24d7eaaa29a.next.bspapp.com/ask/harmonyAxios",
        success(res) {
          console.log(res);
          common_vendor.index.reLaunch({
            url: "/pages/ask/problem/188927/188927"
          });
        }
      });
    }
  }
};
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: common_vendor.o((...args) => $options.click && $options.click(...args))
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createPage(MiniProgramPage);
