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
  function formatAppLog(type, filename, ...args) {
    if (uni.__log__) {
      uni.__log__(type, filename, ...args);
    } else {
      console[type].apply(console, [...args, filename]);
    }
  }
  const _export_sfc = (sfc, props) => {
    const target = sfc.__vccOpts || sfc;
    for (const [key, val] of props) {
      target[key] = val;
    }
    return target;
  };
  const _sfc_main$1 = {
    data() {
      return {
        id: 0,
        // 使用 marker点击事件 需要填写id
        title: "map",
        latitude: 39.909,
        longitude: 116.39742,
        covers: [{
          id: 101,
          latitude: 39.909,
          longitude: 116.39742,
          iconPath: "/static/logo.png",
          width: 100,
          height: 100,
          callout: {
            content: "yuhe"
          }
        }, {
          id: 102,
          latitude: 39.9,
          longitude: 116.39,
          width: 100,
          height: 100,
          iconPath: "/static/logo.png"
        }]
      };
    },
    methods: {
      onMarkerClick(e) {
        formatAppLog("log", "at pages/index/index.vue:43", "onMarkerClick", e);
      }
    }
  };
  function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock("view", null, [
      vue.createElementVNode("view", { class: "page-body" }, [
        vue.createElementVNode("view", { class: "page-section page-section-gap" }, [
          vue.createElementVNode("map", {
            style: { "width": "100%", "height": "300px" },
            latitude: $data.latitude,
            longitude: $data.longitude,
            markers: $data.covers,
            onCallouttap: _cache[0] || (_cache[0] = (...args) => $options.onMarkerClick && $options.onMarkerClick(...args))
          }, null, 40, ["latitude", "longitude", "markers"])
        ])
      ])
    ]);
  }
  const PagesIndexIndex = /* @__PURE__ */ _export_sfc(_sfc_main$1, [["render", _sfc_render], ["__file", "/Users/gaoruicheng/Documents/HBuilderProjects/map-vue3/pages/index/index.vue"]]);
  __definePage("pages/index/index", PagesIndexIndex);
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
  const App = /* @__PURE__ */ _export_sfc(_sfc_main, [["__file", "/Users/gaoruicheng/Documents/HBuilderProjects/map-vue3/App.vue"]]);
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
