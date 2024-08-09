"use strict";
const common_vendor = require("../../../../common/vendor.js");
const _sfc_main = {
  data() {
    return {
      value: 0,
      range: [{ "value": 0, "text": "篮球" }, { "value": 1, "text": "足球" }, { "value": 2, "text": "游泳" }]
    };
  },
  methods: {
    change(e) {
      console.log("e:", e);
    }
  }
};
if (!Array) {
  const _easycom_uni_data_checkbox2 = common_vendor.resolveComponent("uni-data-checkbox");
  _easycom_uni_data_checkbox2();
}
const _easycom_uni_data_checkbox = () => "../../../../uni_modules/uni-data-checkbox/components/uni-data-checkbox/uni-data-checkbox.js";
if (!Math) {
  _easycom_uni_data_checkbox();
}
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: common_vendor.o($options.change),
    b: common_vendor.o(($event) => $data.value = $event),
    c: common_vendor.p({
      localdata: $data.range,
      modelValue: $data.value
    }),
    d: common_vendor.o($options.change),
    e: common_vendor.o(($event) => $data.value = $event),
    f: common_vendor.p({
      mode: "list",
      icon: "left",
      localdata: $data.range,
      modelValue: $data.value
    }),
    g: common_vendor.o($options.change),
    h: common_vendor.o(($event) => $data.value = $event),
    i: common_vendor.p({
      mode: "list",
      icon: "right",
      localdata: $data.range,
      modelValue: $data.value
    }),
    j: common_vendor.o($options.change),
    k: common_vendor.o(($event) => $data.value = $event),
    l: common_vendor.p({
      mode: "button",
      localdata: $data.range,
      modelValue: $data.value
    }),
    m: common_vendor.o($options.change),
    n: common_vendor.o(($event) => $data.value = $event),
    o: common_vendor.p({
      mode: "tag",
      localdata: $data.range,
      modelValue: $data.value
    })
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createPage(MiniProgramPage);
