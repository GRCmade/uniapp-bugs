if (typeof Promise !== "undefined" && !Promise.prototype.finally) {
  Promise.prototype.finally = function(callback) {
    const promise = this.constructor;
    return this.then(
      (value) => promise.resolve(callback()).then(() => value),
      (reason) => promise.resolve(callback()).then(() => {
        throw reason;
      })
    );
  };
}
;
if (typeof uni !== "undefined" && uni && uni.requireGlobal) {
  const global = uni.requireGlobal();
  ArrayBuffer = global.ArrayBuffer;
  Int8Array = global.Int8Array;
  Uint8Array = global.Uint8Array;
  Uint8ClampedArray = global.Uint8ClampedArray;
  Int16Array = global.Int16Array;
  Uint16Array = global.Uint16Array;
  Int32Array = global.Int32Array;
  Uint32Array = global.Uint32Array;
  Float32Array = global.Float32Array;
  Float64Array = global.Float64Array;
  BigInt64Array = global.BigInt64Array;
  BigUint64Array = global.BigUint64Array;
}
;
if (uni.restoreGlobal) {
  uni.restoreGlobal(Vue, weex, plus, setTimeout, clearTimeout, setInterval, clearInterval);
}
(function(vue) {
  "use strict";
  const _export_sfc = (sfc, props) => {
    const target = sfc.__vccOpts || sfc;
    for (const [key, val] of props) {
      target[key] = val;
    }
    return target;
  };
  const _sfc_main$3 = {
    data() {
      return {
        id: 0,
        // 使用 marker点击事件 需要填写id
        title: "map",
        latitude: 39.909,
        longitude: 116.39742,
        covers: [{
          latitude: 39.909,
          longitude: 116.39742,
          iconPath: "/static/logo.png"
        }, {
          latitude: 39.9,
          longitude: 116.39,
          iconPath: "/static/logo.png"
        }]
      };
    },
    onReady() {
      this.mapContext = uni.createMapContext("map", this);
      this.covers.push({
        latitude: 31.850769,
        longitude: 117.152592,
        iconPath: "/static/logo.png"
      });
    },
    methods: {
      click() {
        this.mapContext.moveToLocation({
          latitude: 31.850769,
          longitude: 117.152592
        });
      }
    }
  };
  function _sfc_render$2(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock("view", null, [
      vue.createElementVNode("view", { class: "page-body" }, [
        vue.createElementVNode("view", { class: "page-section page-section-gap" }, [
          vue.createElementVNode("map", {
            id: "map",
            style: { "width": "100%", "height": "300px" },
            latitude: $data.latitude,
            longitude: $data.longitude,
            markers: $data.covers
          }, null, 8, ["latitude", "longitude", "markers"])
        ])
      ]),
      vue.createElementVNode("button", {
        onClick: _cache[0] || (_cache[0] = (...args) => $options.click && $options.click(...args))
      }, "click")
    ]);
  }
  const PagesMapMap = /* @__PURE__ */ _export_sfc(_sfc_main$3, [["render", _sfc_render$2], ["__file", "/Users/gaoruicheng/Documents/MyProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-location-map/pages/map/map.vue"]]);
  const _sfc_main$2 = {
    data() {
      return {
        latitude: 39.91092,
        longitude: 116.41338,
        scale: 6
      };
    },
    onLoad() {
    },
    methods: {
      changeScale8() {
        this.scale == 8 ? this.scale = 5 : this.scale = 8;
        this.latitude = 30.651696;
        this.longitude = 104.076452;
      },
      changeScale85() {
        this.scale == 8.5 ? this.scale = 5 : this.scale = 8.5;
        this.latitude = 30.651696;
        this.longitude = 104.076452;
      }
    }
  };
  function _sfc_render$1(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock(
      vue.Fragment,
      null,
      [
        vue.createElementVNode("map", {
          style: { "width": "750rpx", "height": "90vh" },
          latitude: $data.latitude,
          longitude: $data.longitude,
          scale: $data.scale
        }, null, 8, ["latitude", "longitude", "scale"]),
        vue.createElementVNode("button", {
          onClick: _cache[0] || (_cache[0] = (...args) => $options.changeScale8 && $options.changeScale8(...args))
        }, "changeScale8"),
        vue.createElementVNode("button", {
          onClick: _cache[1] || (_cache[1] = (...args) => $options.changeScale85 && $options.changeScale85(...args))
        }, "changeScale85")
      ],
      64
      /* STABLE_FRAGMENT */
    );
  }
  const PagesMapMapSetupMapSetup = /* @__PURE__ */ _export_sfc(_sfc_main$2, [["render", _sfc_render$1], ["__file", "/Users/gaoruicheng/Documents/MyProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-location-map/pages/map/map-setup/map-setup.vue"]]);
  function formatAppLog(type, filename, ...args) {
    if (uni.__log__) {
      uni.__log__(type, filename, ...args);
    } else {
      console[type].apply(console, [...args, filename]);
    }
  }
  const _imports_0 = "/static/logo.png";
  const _sfc_main$1 = {
    data() {
      return {
        title: "page",
        info: ""
      };
    },
    onLoad() {
    },
    methods: {
      map() {
        uni.navigateTo({
          url: "/pages/map/map-setup/map-setup"
        });
      },
      openLocation() {
        uni.getLocation({
          type: "gcj02",
          //返回可以用于uni.openLocation的经纬度
          success: function(res) {
            const latitude = res.latitude;
            const longitude = res.longitude;
            uni.openLocation({
              latitude,
              longitude,
              success: function() {
                formatAppLog("log", "at pages/page/page.vue:41", "success");
              }
            });
          }
        });
      },
      /**
       * @param {Object} url 通过url获取
       */
      getLocation(url) {
        uni.getLocation({
          type: "gcj02",
          // 坐标类型，默认为wgs84，可选的值为gcj02和bd09ll
          geocode: true,
          success: (res) => {
            formatAppLog("log", "at pages/page/page.vue:57", "res", res);
            formatAppLog("log", "at pages/page/page.vue:58", "longitude1111111111:", res.longitude);
            formatAppLog("log", "at pages/page/page.vue:59", "latitude11111111111:", res.latitude);
            uni.showToast({
              title: "成功" + res.longitude
            });
          },
          fail: (err) => {
            formatAppLog("log", "at pages/page/page.vue:66", "获取位置失败:", err);
            this.info = err;
          }
        });
      },
      chooseLocation() {
        uni.chooseLocation({
          success(e) {
            formatAppLog("log", "at pages/page/page.vue:74", "success", e);
          },
          fail(e) {
            formatAppLog("log", "at pages/page/page.vue:77", "fail", e);
            this.info = e;
          }
        });
      }
    }
  };
  function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock("view", { class: "content" }, [
      vue.createElementVNode("image", {
        class: "logo",
        src: _imports_0
      }),
      vue.createElementVNode("view", { class: "text-area" }, [
        vue.createElementVNode("view", {
          class: "title",
          onClick: _cache[0] || (_cache[0] = (...args) => $options.getLocation && $options.getLocation(...args))
        }, vue.toDisplayString("getLocation")),
        vue.createElementVNode("view", {
          class: "title",
          onClick: _cache[1] || (_cache[1] = (...args) => $options.chooseLocation && $options.chooseLocation(...args))
        }, vue.toDisplayString("chooseLocation")),
        vue.createElementVNode("view", {
          class: "title",
          onClick: _cache[2] || (_cache[2] = (...args) => $options.openLocation && $options.openLocation(...args))
        }, vue.toDisplayString("openLocation")),
        vue.createElementVNode(
          "view",
          null,
          vue.toDisplayString($data.info),
          1
          /* TEXT */
        )
      ]),
      vue.createElementVNode("button", {
        onClick: _cache[3] || (_cache[3] = (...args) => $options.map && $options.map(...args))
      }, "map")
    ]);
  }
  const PagesPagePage = /* @__PURE__ */ _export_sfc(_sfc_main$1, [["render", _sfc_render], ["__file", "/Users/gaoruicheng/Documents/MyProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-location-map/pages/page/page.vue"]]);
  __definePage("pages/map/map", PagesMapMap);
  __definePage("pages/map/map-setup/map-setup", PagesMapMapSetupMapSetup);
  __definePage("pages/page/page", PagesPagePage);
  const _sfc_main = {
    onLaunch: function() {
      formatAppLog("log", "at App.vue:4", "App Launch");
    },
    onShow: function() {
      formatAppLog("log", "at App.vue:7", "App Show");
    },
    onHide: function() {
      formatAppLog("log", "at App.vue:10", "App Hide");
    }
  };
  const App = /* @__PURE__ */ _export_sfc(_sfc_main, [["__file", "/Users/gaoruicheng/Documents/MyProject/uniapp-bugs/uniapp-bugs-main/singlePage/uniapp-location-map/App.vue"]]);
  function createApp() {
    const app = vue.createVueApp(App);
    return {
      app
    };
  }
  const { app: __app__, Vuex: __Vuex__, Pinia: __Pinia__ } = createApp();
  uni.Vuex = __Vuex__;
  uni.Pinia = __Pinia__;
  __app__.provide("__globalStyles", __uniConfig.styles);
  __app__._component.mpType = "app";
  __app__._component.render = () => {
  };
  __app__.mount("#app");
})(Vue);
