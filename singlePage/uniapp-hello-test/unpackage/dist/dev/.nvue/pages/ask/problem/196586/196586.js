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
        iconPath: "/static/logo.png",
        width: 32,
        height: 32
      }]
    };
  },
  onReady() {
    this.context = uni.createMapContext("test_map", this);
  },
  onLoad() {
    let _this = this;
    _this.map.longitude = "116.3485888";
    _this.map.latitude = "39.9496252";
  },
  methods: {
    dingwei() {
      this.context.translateMarker({
        markerId: 1,
        destination: {
          latitude: 39.9499999,
          longitude: 116.3485888
        },
        success(res) {
          formatAppLog("log", "at pages/ask/problem/196586/196586.nvue:46", "移动完成:", res);
        },
        fail(res) {
          formatAppLog("log", "at pages/ask/problem/196586/196586.nvue:49", "移动完成fail:", res);
        }
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
          createTextVNode("移动")
        ]),
        _: 1
        /* STABLE */
      }, 8, ["onClick"])
    ])
  ]);
}
const _196586 = /* @__PURE__ */ _export_sfc(_sfc_main, [["render", _sfc_render], ["__file", "/Users/gaoruicheng/Documents/DcloudProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-hello-test/pages/ask/problem/196586/196586.nvue"]]);
export {
  _196586 as default
};
