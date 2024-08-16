"use strict";
const common_vendor = require("../../../../common/vendor.js");
const _sfc_main = {
  data() {
    return {
      map: {
        longitude: "",
        //经度  
        latitude: ""
        //纬度  
      },
      markers: [{
        id: 1,
        latitude: "39.9496252",
        longitude: "116.3485888",
        iconPath: "/static/logo.png",
        width: 32,
        height: 32
      }]
    };
  },
  onReady() {
    this.context = common_vendor.index.createMapContext("test_map", this);
  },
  onLoad() {
    let _this = this;
    _this.map.longitude = "116.3485888";
    _this.map.latitude = "39.9496252";
  },
  methods: {
    dingwei() {
      console.log("test----- dingwei start");
      this.context.translateMarker({
        markerId: 1,
        duration: 2e3,
        destination: {
          latitude: 39.9599999,
          longitude: 116.3585888
        },
        // rotate: 20,
        autoRotate: true,
        animationEnd() {
          console.log("test----- dingwei end");
        },
        success(res) {
          console.log("移动完成:", res);
        },
        fail(res) {
          console.log("移动完成fail:", res);
        }
      });
    }
  }
};
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: $data.markers,
    b: $data.map.longitude,
    c: $data.map.latitude,
    d: common_vendor.o((...args) => $options.dingwei && $options.dingwei(...args))
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createPage(MiniProgramPage);
