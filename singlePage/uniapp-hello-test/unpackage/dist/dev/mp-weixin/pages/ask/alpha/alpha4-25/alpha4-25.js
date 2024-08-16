"use strict";
const common_vendor = require("../../../../common/vendor.js");
const _sfc_main = {
  data() {
    return {
      input: null,
      id: 0,
      // 使用 marker点击事件 需要填写id
      title: "map",
      latitude: 39.909,
      longitude: 116.39742,
      covers: [{
        id: 101,
        latitude: 39.909,
        longitude: 116.39742,
        iconPath: "/static/logo.png",
        width: 100,
        height: 100,
        callout: {
          content: "yuhe"
        }
      }, {
        id: 102,
        latitude: 39.9,
        longitude: 116.39,
        width: 100,
        height: 100,
        iconPath: "/static/logo.png"
      }]
    };
  },
  methods: {
    onMarkerClick(e) {
      console.log("onMarkerClick", e);
    }
  }
};
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: $data.latitude,
    b: $data.longitude,
    c: $data.covers,
    d: common_vendor.o((...args) => $options.onMarkerClick && $options.onMarkerClick(...args)),
    e: $data.input,
    f: common_vendor.o(($event) => $data.input = $event.detail.value)
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createPage(MiniProgramPage);
