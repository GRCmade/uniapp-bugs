"use strict";
const common_vendor = require("../../../../common/vendor.js");
const _sfc_main = {
  __name: "194699",
  setup(__props) {
    common_vendor.onMounted(() => {
      common_vendor.index.onKeyboardHeightChange((e) => {
        console.log("键盘高度变化", e.keyboardHeight);
      });
    });
    return (_ctx, _cache) => {
      return {};
    };
  }
};
wx.createPage(_sfc_main);
