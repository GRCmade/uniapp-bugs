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
        iconPath: "/static/app-plus/location@3x.png",
        width: 32,
        height: 32
      }]
    };
  },
  onLoad() {
    let _this = this;
    common_vendor.index.getLocation({
      type: "gcj02",
      success: function(res) {
        console.log(res);
        _this.map.longitude = res.longitude;
        _this.map.latitude = res.latitude;
      }
    });
  },
  methods: {
    dingwei() {
      const context = common_vendor.index.createMapContext("test_map", this);
      let obj = {
        id: this.markers.length + 2,
        latitude: "39.9496252",
        longitude: "116.3485888",
        iconPath: `/static/app-plus/location@3x.png`,
        width: 50,
        height: 50
      };
      this.markers.push(obj);
      context.addMarkers({
        markers: this.markers
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
