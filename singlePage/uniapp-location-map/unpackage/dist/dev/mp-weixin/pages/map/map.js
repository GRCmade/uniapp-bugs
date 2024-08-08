"use strict";
const common_vendor = require("../../common/vendor.js");
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
        iconPath: "/static/logo.png"
      }, {
        latitude: 39.9,
        longitude: 116.39,
        iconPath: "/static/logo.png"
      }]
    };
  },
  onReady() {
    this.mapContext = common_vendor.index.createMapContext("map", this);
    this.covers.push({
      latitude: 31.850769,
      longitude: 117.152592,
      iconPath: "/static/logo.png"
    });
  },
  methods: {
    click() {
      this.mapContext.moveToLocation({
        latitude: 31.850769,
        longitude: 117.152592
      });
    }
  }
};
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: $data.latitude,
    b: $data.longitude,
    c: $data.covers,
    d: common_vendor.o((...args) => $options.click && $options.click(...args))
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createPage(MiniProgramPage);
