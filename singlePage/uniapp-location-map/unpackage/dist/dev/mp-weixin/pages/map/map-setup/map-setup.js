"use strict";
const common_vendor = require("../../../common/vendor.js");
const _sfc_main = {
  __name: "map-setup",
  setup(__props) {
    let latitude = common_vendor.ref(39.909);
    let longitude = common_vendor.ref(116.39742);
    common_vendor.ref();
    let covers = common_vendor.ref([{
      latitude: 39.909,
      longitude: 116.39742,
      iconPath: "/static/logo.png"
    }, {
      latitude: 39.9,
      longitude: 116.39,
      iconPath: "/static/logo.png"
    }]);
    covers.value.push({
      latitude: 31.850769,
      longitude: 117.152592,
      iconPath: "/static/logo.png"
    });
    const click = () => {
      const mapContext = common_vendor.index.createMapContext("map");
      mapContext.moveToLocation();
    };
    return (_ctx, _cache) => {
      return {
        a: common_vendor.o(() => {
        }),
        b: common_vendor.unref(latitude),
        c: common_vendor.unref(longitude),
        d: common_vendor.unref(covers),
        e: common_vendor.o(click)
      };
    };
  }
};
wx.createPage(_sfc_main);
