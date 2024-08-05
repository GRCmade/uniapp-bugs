"use strict";
const common_vendor = require("../../common/vendor.js");
const common_assets = require("../../common/assets.js");
function test() {
  console.log("test");
}
const _sfc_main = {
  data() {
    return {
      title: "Hello",
      input: 0,
      inputNo: "",
      lastInputTime: "",
      showWidht: true
    };
  },
  onLoad() {
    test();
  },
  onShow() {
    console.log("onShow");
    common_vendor.index.setTabBarItem({
      index: 0,
      text: "xxx"
    });
  },
  onHide() {
    console.log("onHide");
    setTimeout(() => {
      common_vendor.index.setTabBarItem({
        index: 0,
        text: "首页"
      });
    }, 100);
  },
  methods: {
    yuheClick() {
      plus.runtime.launchApplication({
        action: "App-Prefs:root=Privacy&path=CAMERA"
      }, function(e) {
        console.log(JSON.stringify(e));
      });
    },
    inputchange() {
      let currentTime = Date.now();
      if (this.lastInputTime) {
        let interval = currentTime - this.lastInputTime;
        console.log(interval);
        if (interval > this.inputIntervalThreshold) {
          this.inputNo = " ";
          common_vendor.index.showToast({
            title: "请扫描会员码或刷卡录入",
            icon: "none"
          });
          return;
        }
      }
      this.lastInputTime = currentTime;
    },
    click() {
      common_vendor.index.chooseImage({
        count: 6,
        //默认9
        sourceType: ["album", "camera"],
        //从相册选择
        success: function(res) {
          console.log(JSON.stringify(res.tempFilePaths));
        },
        fail(e) {
          console.log(e);
        }
      });
    }
  }
};
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  return {
    a: common_assets._imports_0,
    b: common_vendor.t($data.title),
    c: common_vendor.o((...args) => $options.click && $options.click(...args)),
    d: common_vendor.o((...args) => $options.yuheClick && $options.yuheClick(...args))
  };
}
const MiniProgramPage = /* @__PURE__ */ common_vendor._export_sfc(_sfc_main, [["render", _sfc_render]]);
wx.createPage(MiniProgramPage);
