"use strict";
const common_vendor = require("../../../../common/vendor.js");
const _sfc_main = {
  __name: "196766",
  setup(__props) {
    const activeIndex = common_vendor.ref(0);
    const list = common_vendor.ref([
      { name: "红色", color: "red", id: 11 },
      { name: "绿色", color: "green", id: 22 },
      { name: "蓝色", color: "blue", id: 33 },
      { name: "粉色", color: "pink", id: 44 },
      { name: "黄色", color: "yellow", id: 55 }
    ]);
    const swiperChange = (e) => {
      activeIndex.value = e.detail.current;
    };
    const del = () => {
      list.value.splice(activeIndex.value, 1);
      if (activeIndex.value == list.value.length) {
        activeIndex.value = 0;
      }
    };
    return (_ctx, _cache) => {
      return {
        a: common_vendor.f(list.value, (item, k0, i0) => {
          return {
            a: common_vendor.t(item.name),
            b: item.id,
            c: item.color
          };
        }),
        b: activeIndex.value,
        c: common_vendor.o(swiperChange),
        d: common_vendor.o(del)
      };
    };
  }
};
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["__scopeId", "data-v-94fc2444"]]);
wx.createPage(MiniProgramPage);
