"use strict";
const common_vendor = require("../../common/vendor.js");
const pages_ask_hellolist = require("./hellolist.js");
const _sfc_main = {
  data() {
    return {
      title: "Hello",
      ls: pages_ask_hellolist.list
    };
  },
  onLoad() {
  },
  methods: {
    click(id) {
      const str = `/pages/ask/problem/${id}/${id}`;
      console.log(str);
      common_vendor.index.navigateTo({
        url: str
      });
    }
  }
};
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: common_vendor.f($data.ls, (it, i, i0) => {
      return {
        a: common_vendor.t(it.day),
        b: common_vendor.f(it.list, (item, index, i1) => {
          return {
            a: common_vendor.t(item),
            b: common_vendor.o(($event) => $options.click(item)),
            c: index
          };
        }),
        c: i
      };
    })
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
tt.createPage(MiniProgramPage);
