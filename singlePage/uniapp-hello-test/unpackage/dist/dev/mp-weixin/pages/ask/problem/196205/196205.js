"use strict";
const common_vendor = require("../../../../common/vendor.js");
const _sfc_main = {
  __name: "196205",
  setup(__props) {
    const instance = common_vendor.ref();
    const observer = common_vendor.ref();
    common_vendor.onMounted(() => {
      instance.value = common_vendor.getCurrentInstance();
      observer.value = common_vendor.index.createIntersectionObserver(instance.value);
      observer.value.relativeTo(".box").observe(".wrap", (res) => {
        console.log("createIntersectionObserver res", res);
      });
    });
    return (_ctx, _cache) => {
      return {};
    };
  }
};
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-d727a616"]]);
wx.createPage(MiniProgramPage);
