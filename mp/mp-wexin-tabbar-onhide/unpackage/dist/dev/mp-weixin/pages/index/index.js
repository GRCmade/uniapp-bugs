"use strict";
const common_vendor = require("../../common/vendor.js");
const common_assets = require("../../common/assets.js");
const _sfc_main = {
  data() {
    return {
      title: "Hello"
    };
  },
  onLoad() {
  },
  onShow() {
    console.log("onShow");
    common_vendor.index.setTabBarItem({
      index: 0,
      text: "xxx"
    });
  },
  onHide() {
    console.log("onHide");
    common_vendor.index.setTabBarItem({
      index: 0,
      text: "首页"
    });
  },
  methods: {
    click() {
      common_vendor.index.navigateTo({
        url: "/pages/page/page2"
      });
    }
  }
};
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: common_assets._imports_0,
    b: common_vendor.t($data.title),
    c: common_vendor.o((...args) => $options.click && $options.click(...args))
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createPage(MiniProgramPage);
