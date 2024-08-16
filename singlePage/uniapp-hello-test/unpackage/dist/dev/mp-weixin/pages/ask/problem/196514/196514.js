"use strict";
const common_vendor = require("../../../../common/vendor.js");
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
  return {
    a: $data.polyline
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createPage(MiniProgramPage);
