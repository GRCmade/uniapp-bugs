"use strict";
const common_vendor = require("../../common/vendor.js");
const common_assets = require("../../common/assets.js");
const _sfc_main = {
  data() {
    return {
      title: "chooseLocation",
      info: ""
    };
  },
  onLoad() {
  },
  methods: {
    map() {
      common_vendor.index.navigateTo({
        url: "/pages/page/page"
      });
    },
    openLocation() {
      common_vendor.index.getLocation({
        type: "gcj02",
        //返回可以用于uni.openLocation的经纬度
        success: function(res) {
          const latitude = res.latitude;
          const longitude = res.longitude;
          common_vendor.index.openLocation({
            latitude,
            longitude,
            success: function() {
              console.log("success");
            }
          });
        }
      });
    },
    /**
     * @param {Object} url 通过url获取
     */
    getLocation(url) {
      common_vendor.index.getLocation({
        type: "gcj02",
        // 坐标类型，默认为wgs84，可选的值为gcj02和bd09ll
        geocode: true,
        success: (res) => {
          console.log("res", res);
          console.log("longitude1111111111:", res.longitude);
          console.log("latitude11111111111:", res.latitude);
          common_vendor.index.showToast({
            title: "成功" + res.longitude
          });
        },
        fail: (err) => {
          console.log("获取位置失败:", err);
          this.info = err;
        }
      });
    },
    chooseLocation() {
      common_vendor.index.chooseLocation({
        success(e) {
          console.log("success", e);
        },
        fail(e) {
          console.log("fail", e);
          this.info = e;
        }
      });
    }
  }
};
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: common_assets._imports_0,
    b: common_vendor.t("getLocation"),
    c: common_vendor.o((...args) => $options.getLocation && $options.getLocation(...args)),
    d: common_vendor.t("chooseLocation"),
    e: common_vendor.o((...args) => $options.chooseLocation && $options.chooseLocation(...args)),
    f: common_vendor.t("openLocation"),
    g: common_vendor.o((...args) => $options.openLocation && $options.openLocation(...args)),
    h: common_vendor.t($data.info),
    i: common_vendor.o((...args) => $options.map && $options.map(...args))
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createPage(MiniProgramPage);
