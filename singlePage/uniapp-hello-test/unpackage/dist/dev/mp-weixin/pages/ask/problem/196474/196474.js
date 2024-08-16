"use strict";
const common_vendor = require("../../../../common/vendor.js");
const _sfc_main = {
  data() {
    return {
      id: 0,
      // 使用 marker点击事件 需要填写id
      title: "map",
      latitude: 39.909,
      longitude: 116.39742,
      covers: [{
        latitude: 39.909,
        longitude: 116.39742,
        iconPath: "/static/api.png",
        callout: {
          content: "故宫博物馆",
          display: "ALWAYS",
          fontSize: 22,
          bgColor: "#0180CC",
          color: "#000",
          markerId: 1
        }
      }, {
        latitude: 39.9,
        longitude: 116.39,
        iconPath: "../../../static/location.png"
      }]
    };
  },
  methods: {
    markerTap(e) {
      console.log(e);
    }
  }
};
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: $data.latitude,
    b: $data.longitude,
    c: $data.covers,
    d: common_vendor.o((...args) => $options.markerTap && $options.markerTap(...args))
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createPage(MiniProgramPage);
