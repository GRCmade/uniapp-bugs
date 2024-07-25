"use strict";
const common_vendor = require("../../common/vendor.js");
if (!Math) {
  test1();
}
const test1 = () => "./test1.js";
const _sfc_main = /* @__PURE__ */ common_vendor.defineComponent({
  __name: "index",
  setup(__props) {
    return (_ctx, _cache) => {
      return {
        a: common_vendor.w(({
          listData
        }, s0, i0) => {
          return {
            a: i0,
            b: s0
          };
        }, {
          name: "d",
          path: "a",
          vueId: "01f7d7a4-0"
        })
      };
    };
  }
});
my.createPage(_sfc_main);
