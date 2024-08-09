"use strict";
const common_vendor = require("../../../../common/vendor.js");
const _sfc_main = {
  __name: "196246",
  setup(__props) {
    common_vendor.onBeforeMount(() => {
      const dom = common_vendor.index.requireNativePlugin("dom");
      dom.addRule("fontFace", {
        "fontFamily": "testfamily",
        "src": "url('https://byte-drama-series.s3.amazonaws.com/font/gordita-regular.otf')"
      });
    });
    return (_ctx, _cache) => {
      return {};
    };
  }
};
tt.createPage(_sfc_main);
