import { f as formatAppLog } from "../../../../uni-app.es.js";
import { resolveComponent, openBlock, createElementBlock, createElementVNode, createVNode, withCtx, createTextVNode } from "vue";
import { _ as _export_sfc } from "../../../../_plugin-vue_export-helper.js";
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
    uni.getLocation({
      type: "gcj02",
      success: function(res) {
        formatAppLog("log", "at pages/ask/problem/196598/196598.nvue:34", res);
        _this.map.longitude = res.longitude;
        _this.map.latitude = res.latitude;
      }
    });
  },
  methods: {
    dingwei() {
      const context = uni.createMapContext("test_map", this);
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
  const _component_button = resolveComponent("button");
  return openBlock(), createElementBlock("scroll-view", {
    scrollY: true,
    showScrollbar: true,
    enableBackToTop: true,
    bubble: "true",
    style: { flexDirection: "column" }
  }, [
    createElementVNode("view", null, [
      createElementVNode("map", {
        id: "test_map",
        style: { "width": "750rpx", "height": "300px" },
        showLocation: true,
        markers: $data.markers,
        longitude: $data.map.longitude,
        latitude: $data.map.latitude
      }, null, 8, ["markers", "longitude", "latitude"]),
      createVNode(_component_button, { onClick: $options.dingwei }, {
        default: withCtx(() => [
          createTextVNode("添加marker")
        ]),
        _: 1
        /* STABLE */
      }, 8, ["onClick"])
    ])
  ]);
}
const _196598 = /* @__PURE__ */ _export_sfc(_sfc_main, [["render", _sfc_render], ["__file", "/Users/gaoruicheng/Documents/DcloudProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-hello-test/pages/ask/problem/196598/196598.nvue"]]);
export {
  _196598 as default
};
