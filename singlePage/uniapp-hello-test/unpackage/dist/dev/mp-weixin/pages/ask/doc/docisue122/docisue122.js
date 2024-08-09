"use strict";
const common_vendor = require("../../../../common/vendor.js");
const _sfc_main = {
  __name: "docisue122",
  setup(__props) {
    const ins = common_vendor.getCurrentInstance();
    var webView = ins.ctx;
    console.log(webView);
    return (_ctx, _cache) => {
      return {};
    };
  }
};
wx.createPage(_sfc_main);
