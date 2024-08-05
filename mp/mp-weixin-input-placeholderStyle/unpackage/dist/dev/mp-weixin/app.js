"use strict";
Object.defineProperty(exports, Symbol.toStringTag, { value: "Module" });
const common_vendor = require("./common/vendor.js");
if (!Math) {
  "./pages/index/index.js";
  "./pages/page/page.js";
  "./pages/page/page2.js";
  "./pages/nvue/nvue.js";
}
const _sfc_main = {
  onLaunch: function() {
    console.log("App Launch");
  },
  onShow: function() {
    console.log("App Show");
  },
  onHide: function() {
    console.log("App Hide");
  }
};
const componentVue = () => "./pages/components/component.js";
function createApp() {
  const app = common_vendor.createSSRApp(_sfc_main);
  app.component("component", componentVue);
  return {
    app
  };
}
createApp().app.mount("#app");
exports.createApp = createApp;
