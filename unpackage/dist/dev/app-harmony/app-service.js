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
  const CONSOLE_TYPES = ["log", "warn", "error", "info", "debug"];
  let sendConsole = null;
  const messageQueue = [];
  function sendConsoleMessages(messages) {
    if (sendConsole == null) {
      messageQueue.push(...messages);
      return;
    }
    sendConsole(JSON.stringify({
      type: "console",
      data: messages
    }));
  }
  function setSendConsole(value) {
    sendConsole = value;
    if (value != null && messageQueue.length > 0) {
      const messages = messageQueue.slice();
      messageQueue.length = 0;
      sendConsoleMessages(messages);
    }
  }
  const originalConsole = /* @__PURE__ */ CONSOLE_TYPES.reduce((methods, type) => {
    methods[type] = console[type].bind(console);
    return methods;
  }, {});
  function rewriteConsole() {
    function wrapConsole(type) {
      return function(...args) {
        [...args];
        sendConsoleMessages([formatMessage(type, args)]);
      };
    }
    if (isConsoleWritable()) {
      CONSOLE_TYPES.forEach((type) => {
        console[type] = wrapConsole(type);
      });
      return function restoreConsole() {
        CONSOLE_TYPES.forEach((type) => {
          console[type] = originalConsole[type];
        });
      };
    } else {
      const oldLog = uni.__f__;
      if (oldLog) {
        uni.__f__ = function(...args) {
          const [type, filename, ...rest] = args;
          oldLog(type, "", ...rest);
          sendConsoleMessages([formatMessage(type, [...rest, filename])]);
        };
        return function restoreConsole() {
          uni.__f__ = oldLog;
        };
      }
    }
    return function restoreConsole() {
    };
  }
  function isConsoleWritable() {
    const value = console.log;
    const sym = Symbol();
    try {
      console.log = sym;
    } catch (ex) {
      return false;
    }
    const isWritable = console.log === sym;
    console.log = value;
    return isWritable;
  }
  function formatMessage(type, args) {
    try {
      return {
        type,
        args: formatArgs(args)
      };
    } catch (e) {
      originalConsole.error(e);
    }
    return {
      type,
      args: []
    };
  }
  function formatArgs(args) {
    return args.map((arg) => formatArg(arg));
  }
  function formatArg(arg, depth = 0) {
    if (depth >= 7) {
      return {
        type: "object",
        value: "[Maximum depth reached]"
      };
    }
    return ARG_FORMATTERS[typeof arg](arg, depth);
  }
  function formatObject(value, depth) {
    if (value === null) {
      return {
        type: "null"
      };
    }
    if (isComponentPublicInstance(value)) {
      return formatComponentPublicInstance(value, depth);
    }
    if (isComponentInternalInstance(value)) {
      return formatComponentInternalInstance(value, depth);
    }
    if (isUniElement(value)) {
      return formatUniElement(value, depth);
    }
    if (isCSSStyleDeclaration(value)) {
      return formatCSSStyleDeclaration(value, depth);
    }
    if (Array.isArray(value)) {
      return {
        type: "object",
        subType: "array",
        value: {
          properties: value.map((v, i) => formatArrayElement(v, i, depth + 1))
        }
      };
    }
    if (value instanceof Set) {
      return {
        type: "object",
        subType: "set",
        className: "Set",
        description: `Set(${value.size})`,
        value: {
          entries: Array.from(value).map((v) => formatSetEntry(v, depth + 1))
        }
      };
    }
    if (value instanceof Map) {
      return {
        type: "object",
        subType: "map",
        className: "Map",
        description: `Map(${value.size})`,
        value: {
          entries: Array.from(value.entries()).map((v) => formatMapEntry(v, depth + 1))
        }
      };
    }
    if (value instanceof Promise) {
      return {
        type: "object",
        subType: "promise",
        value: {
          properties: []
        }
      };
    }
    if (value instanceof RegExp) {
      return {
        type: "object",
        subType: "regexp",
        value: String(value),
        className: "Regexp"
      };
    }
    if (value instanceof Date) {
      return {
        type: "object",
        subType: "date",
        value: String(value),
        className: "Date"
      };
    }
    if (value instanceof Error) {
      return {
        type: "object",
        subType: "error",
        value: value.message || String(value),
        className: value.name || "Error"
      };
    }
    return {
      type: "object",
      value: {
        properties: Object.entries(value).map(([name, value2]) => formatObjectProperty(name, value2, depth + 1))
      }
    };
  }
  function isComponentPublicInstance(value) {
    return value.$ && isComponentInternalInstance(value.$);
  }
  function isComponentInternalInstance(value) {
    return value.type && value.uid != null && value.appContext;
  }
  function formatComponentPublicInstance(value, depth) {
    return {
      type: "object",
      className: "ComponentPublicInstance",
      value: {
        properties: Object.entries(value.$.type).map(([name, value2]) => formatObjectProperty(name, value2, depth + 1))
      }
    };
  }
  function formatComponentInternalInstance(value, depth) {
    return {
      type: "object",
      className: "ComponentInternalInstance",
      value: {
        properties: Object.entries(value.type).map(([name, value2]) => formatObjectProperty(name, value2, depth + 1))
      }
    };
  }
  function isUniElement(value) {
    return value.style && value.tagName != null && value.nodeName != null;
  }
  function formatUniElement(value, depth) {
    return {
      type: "object",
      // 非 x 没有 UniElement 的概念
      // className: 'UniElement',
      value: {
        properties: Object.entries(value).filter(([name]) => [
          "id",
          "tagName",
          "nodeName",
          "dataset",
          "offsetTop",
          "offsetLeft",
          "style"
        ].includes(name)).map(([name, value2]) => formatObjectProperty(name, value2, depth + 1))
      }
    };
  }
  function isCSSStyleDeclaration(value) {
    return typeof value.getPropertyValue === "function" && typeof value.setProperty === "function" && value.$styles;
  }
  function formatCSSStyleDeclaration(style, depth) {
    return {
      type: "object",
      value: {
        properties: Object.entries(style.$styles).map(([name, value]) => formatObjectProperty(name, value, depth + 1))
      }
    };
  }
  function formatObjectProperty(name, value, depth) {
    return Object.assign(formatArg(value, depth), {
      name
    });
  }
  function formatArrayElement(value, index, depth) {
    return Object.assign(formatArg(value, depth), {
      name: `${index}`
    });
  }
  function formatSetEntry(value, depth) {
    return {
      value: formatArg(value, depth)
    };
  }
  function formatMapEntry(value, depth) {
    return {
      key: formatArg(value[0], depth),
      value: formatArg(value[1], depth)
    };
  }
  const ARG_FORMATTERS = {
    function(value) {
      return {
        type: "function",
        value: `function ${value.name}() {}`
      };
    },
    undefined() {
      return {
        type: "undefined"
      };
    },
    object(value, depth) {
      return formatObject(value, depth);
    },
    boolean(value) {
      return {
        type: "boolean",
        value: String(value)
      };
    },
    number(value) {
      return {
        type: "number",
        value: String(value)
      };
    },
    bigint(value) {
      return {
        type: "bigint",
        value: String(value)
      };
    },
    string(value) {
      return {
        type: "string",
        value
      };
    },
    symbol(value) {
      return {
        type: "symbol",
        value: value.description
      };
    }
  };
  function initRuntimeSocket(hosts, port, id) {
    if (!hosts || !port || !id)
      return Promise.resolve(null);
    return hosts.split(",").reduce((promise, host) => {
      return promise.then((socket) => {
        if (socket)
          return socket;
        return tryConnectSocket(host, port, id);
      });
    }, Promise.resolve(null));
  }
  const SOCKET_TIMEOUT = 500;
  function tryConnectSocket(host, port, id) {
    return new Promise((resolve, reject) => {
      const socket = uni.connectSocket({
        url: `ws://${host}:${port}/${id}`,
        // 支付宝小程序 是否开启多实例
        multiple: true,
        fail() {
          resolve(null);
        }
      });
      const timer = setTimeout(() => {
        socket.close({
          code: 1006,
          reason: "connect timeout"
        });
        resolve(null);
      }, SOCKET_TIMEOUT);
      socket.onOpen((e) => {
        clearTimeout(timer);
        resolve(socket);
      });
      socket.onClose((e) => {
        clearTimeout(timer);
        resolve(null);
      });
      socket.onError((e) => {
        clearTimeout(timer);
        resolve(null);
      });
    });
  }
  let sendError = null;
  const errorQueue = /* @__PURE__ */ new Set();
  function sendErrorMessages(errors) {
    if (sendError == null) {
      errors.forEach((error) => {
        errorQueue.add(error);
      });
      return;
    }
    sendError(JSON.stringify({
      type: "error",
      data: errors.map((err) => {
        const isPromiseRejection = err && "promise" in err && "reason" in err;
        const prefix = isPromiseRejection ? "UnhandledPromiseRejection: " : "";
        if (isPromiseRejection) {
          err = err.reason;
        }
        if (err instanceof Error && err.stack) {
          return prefix + err.stack;
        }
        if (typeof err === "object" && err !== null) {
          try {
            return prefix + JSON.stringify(err);
          } catch (err2) {
            return prefix + String(err2);
          }
        }
        return prefix + String(err);
      })
    }));
  }
  function setSendError(value) {
    sendError = value;
    if (value != null && errorQueue.size > 0) {
      const errors = Array.from(errorQueue);
      errorQueue.clear();
      sendErrorMessages(errors);
    }
  }
  function initOnError() {
    function onError(error) {
      try {
        if (typeof PromiseRejectionEvent !== "undefined" && error instanceof PromiseRejectionEvent && error.reason instanceof Error && error.reason.message && error.reason.message.includes(`Cannot create property 'errMsg' on string 'taskId`)) {
          return;
        }
        if (false)
          ;
        sendErrorMessages([error]);
      } catch (err) {
        originalConsole.error(err);
      }
    }
    if (typeof uni.onError === "function") {
      uni.onError(onError);
    }
    if (typeof uni.onUnhandledRejection === "function") {
      uni.onUnhandledRejection(onError);
    }
    return function offError() {
      if (typeof uni.offError === "function") {
        uni.offError(onError);
      }
      if (typeof uni.offUnhandledRejection === "function") {
        uni.offUnhandledRejection(onError);
      }
    };
  }
  function initRuntimeSocketService() {
    const hosts = "127.0.0.1,192.168.31.148";
    const port = "8090";
    const id = "app-harmony_rEiw6p";
    const lazy = typeof swan !== "undefined";
    let restoreError = lazy ? () => {
    } : initOnError();
    let restoreConsole = lazy ? () => {
    } : rewriteConsole();
    return Promise.resolve().then(() => {
      if (lazy) {
        restoreError = initOnError();
        restoreConsole = rewriteConsole();
      }
      return initRuntimeSocket(hosts, port, id).then((socket) => {
        if (!socket) {
          restoreError();
          restoreConsole();
          originalConsole.error(wrapError("开发模式下日志通道建立 socket 连接失败。"));
          originalConsole.error(wrapError("如果是小程序平台，请勾选不校验合法域名配置。"));
          originalConsole.error(wrapError("如果是运行到真机，请确认手机与电脑处于同一网络。"));
          return false;
        }
        initMiniProgramGlobalFlag();
        socket.onClose(() => {
          originalConsole.error(wrapError("开发模式下日志通道 socket 连接关闭，请在 HBuilderX 中重新运行。"));
          restoreError();
          restoreConsole();
        });
        setSendConsole((data) => {
          socket.send({
            data
          });
        });
        setSendError((data) => {
          socket.send({
            data
          });
        });
        return true;
      });
    });
  }
  const ERROR_CHAR = "‌";
  function wrapError(error) {
    return `${ERROR_CHAR}${error}${ERROR_CHAR}`;
  }
  function initMiniProgramGlobalFlag() {
    if (typeof wx !== "undefined") {
      wx.__uni_console__ = true;
    } else if (typeof my !== "undefined") {
      my.__uni_console__ = true;
    } else if (typeof tt !== "undefined") {
      tt.__uni_console__ = true;
    } else if (typeof swan !== "undefined") {
      swan.__uni_console__ = true;
    } else if (typeof qq !== "undefined") {
      qq.__uni_console__ = true;
    } else if (typeof ks !== "undefined") {
      ks.__uni_console__ = true;
    } else if (typeof jd !== "undefined") {
      jd.__uni_console__ = true;
    } else if (typeof xhs !== "undefined") {
      xhs.__uni_console__ = true;
    } else if (typeof has !== "undefined") {
      has.__uni_console__ = true;
    } else if (typeof qa !== "undefined") {
      qa.__uni_console__ = true;
    }
  }
  initRuntimeSocketService();
  const _imports_0 = "/static/logo.png";
  const _export_sfc = (sfc, props) => {
    const target = sfc.__vccOpts || sfc;
    for (const [key, val] of props) {
      target[key] = val;
    }
    return target;
  };
  const _sfc_main$5 = {
    data() {
      return {
        title: "Hello"
      };
    },
    onLoad() {
    },
    methods: {
      onCLick() {
        uni.switchTab({
          url: "/pages/index/index3"
        });
      }
    }
  };
  function _sfc_render$4(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock("view", { class: "content" }, [
      vue.createElementVNode("image", {
        class: "logo",
        src: _imports_0,
        onClick: _cache[0] || (_cache[0] = (...args) => $options.onCLick && $options.onCLick(...args))
      }),
      vue.createElementVNode("view", { class: "text-area" }, [
        vue.createElementVNode(
          "text",
          { class: "title" },
          vue.toDisplayString($data.title),
          1
          /* TEXT */
        )
      ]),
      vue.createElementVNode("canvas", { id: "at-canvas" })
    ]);
  }
  const PagesIndexIndex = /* @__PURE__ */ _export_sfc(_sfc_main$5, [["render", _sfc_render$4], ["__file", "/Users/gaoruicheng/Downloads/testCanvas/pages/index/index.vue"]]);
  function formatAppLog(type, filename, ...args) {
    if (uni.__log__) {
      uni.__log__(type, filename, ...args);
    } else {
      console[type].apply(console, [...args, filename]);
    }
  }
  const _sfc_main$4 = {
    data() {
      return {
        title: "Hello--第二页"
      };
    },
    onLoad() {
    },
    methods: {
      onCLick() {
        const ctx = uni.createCanvasContext("at-canvas");
        formatAppLog("log", "at pages/index/index2.vue:24", "createATImg------------11", ctx);
        ctx.font = "italic bold 20px cursive";
        const metrics = ctx.measureText("Hello World", (res) => {
          formatAppLog("log", "at pages/index/index2.vue:27", "createATImg------------22---ctx.measureText", res);
        });
        formatAppLog("log", "at pages/index/index2.vue:29", "createATImg------------22---ctx.measureText1", metrics);
      }
    }
  };
  function _sfc_render$3(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock("view", { class: "content" }, [
      vue.createElementVNode("image", {
        class: "logo",
        src: _imports_0,
        onClick: _cache[0] || (_cache[0] = (...args) => $options.onCLick && $options.onCLick(...args))
      }),
      vue.createElementVNode("view", { class: "text-area" }, [
        vue.createElementVNode(
          "text",
          { class: "title" },
          vue.toDisplayString($data.title),
          1
          /* TEXT */
        )
      ]),
      vue.createElementVNode("canvas", { "canvas-id": "at-canvas" })
    ]);
  }
  const PagesIndexIndex2 = /* @__PURE__ */ _export_sfc(_sfc_main$4, [["render", _sfc_render$3], ["__file", "/Users/gaoruicheng/Downloads/testCanvas/pages/index/index2.vue"]]);
  const _sfc_main$3 = {
    data() {
      return {
        title: "Hello--tab_1"
      };
    },
    onLoad() {
    },
    methods: {
      onCLick() {
        uni.navigateTo({
          url: "/pages/index/index2"
        });
      }
    }
  };
  function _sfc_render$2(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock("view", { class: "content" }, [
      vue.createElementVNode("image", {
        class: "logo",
        src: _imports_0,
        onClick: _cache[0] || (_cache[0] = (...args) => $options.onCLick && $options.onCLick(...args))
      }),
      vue.createElementVNode("view", { class: "text-area" }, [
        vue.createElementVNode(
          "text",
          { class: "title" },
          vue.toDisplayString($data.title),
          1
          /* TEXT */
        )
      ])
    ]);
  }
  const PagesIndexIndex3 = /* @__PURE__ */ _export_sfc(_sfc_main$3, [["render", _sfc_render$2], ["__file", "/Users/gaoruicheng/Downloads/testCanvas/pages/index/index3.vue"]]);
  const _sfc_main$2 = {
    data() {
      return {
        title: "Hello--tab_2"
      };
    },
    onLoad() {
    },
    methods: {
      onCLick() {
        const ctx = uni.createCanvasContext("at-canvas");
        formatAppLog("log", "at pages/index/index4.vue:23", "createATImg------------11", ctx);
        ctx.font = "italic bold 20px cursive";
        const metrics = ctx.measureText("Hello World", (res) => {
          formatAppLog("log", "at pages/index/index4.vue:26", "createATImg------------22---ctx.measureText", res);
        });
        formatAppLog("log", "at pages/index/index4.vue:28", "createATImg------------22---ctx.measureText1", metrics);
      }
    }
  };
  function _sfc_render$1(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock("view", { class: "content" }, [
      vue.createElementVNode("image", {
        class: "logo",
        src: _imports_0,
        onClick: _cache[0] || (_cache[0] = (...args) => $options.onCLick && $options.onCLick(...args))
      }),
      vue.createElementVNode("view", { class: "text-area" }, [
        vue.createElementVNode(
          "text",
          { class: "title" },
          vue.toDisplayString($data.title),
          1
          /* TEXT */
        )
      ])
    ]);
  }
  const PagesIndexIndex4 = /* @__PURE__ */ _export_sfc(_sfc_main$2, [["render", _sfc_render$1], ["__file", "/Users/gaoruicheng/Downloads/testCanvas/pages/index/index4.vue"]]);
  const _sfc_main$1 = {
    data() {
      return {
        title: "Hello--tab_3"
      };
    },
    onLoad() {
    },
    methods: {
      onCLick() {
        const ctx = uni.createCanvasContext("at-canvas");
        formatAppLog("log", "at pages/index/index5.vue:23", "createATImg------------11", ctx);
        ctx.font = "italic bold 20px cursive";
        const metrics = ctx.measureText("Hello World", (res) => {
          formatAppLog("log", "at pages/index/index5.vue:26", "createATImg------------22---ctx.measureText", res);
        });
        formatAppLog("log", "at pages/index/index5.vue:28", "createATImg------------22---ctx.measureText1", metrics);
      }
    }
  };
  function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
    return vue.openBlock(), vue.createElementBlock("view", { class: "content" }, [
      vue.createElementVNode("image", {
        class: "logo",
        src: _imports_0,
        onClick: _cache[0] || (_cache[0] = (...args) => $options.onCLick && $options.onCLick(...args))
      }),
      vue.createElementVNode("view", { class: "text-area" }, [
        vue.createElementVNode(
          "text",
          { class: "title" },
          vue.toDisplayString($data.title),
          1
          /* TEXT */
        )
      ])
    ]);
  }
  const PagesIndexIndex5 = /* @__PURE__ */ _export_sfc(_sfc_main$1, [["render", _sfc_render], ["__file", "/Users/gaoruicheng/Downloads/testCanvas/pages/index/index5.vue"]]);
  __definePage("pages/index/index", PagesIndexIndex);
  __definePage("pages/index/index2", PagesIndexIndex2);
  __definePage("pages/index/index3", PagesIndexIndex3);
  __definePage("pages/index/index4", PagesIndexIndex4);
  __definePage("pages/index/index5", PagesIndexIndex5);
  const _sfc_main = {
    onLaunch: function() {
      formatAppLog("log", "at App.vue:4", "App Launch");
    },
    onShow: function() {
      formatAppLog("log", "at App.vue:12", "App Show");
    },
    onHide: function() {
      formatAppLog("log", "at App.vue:15", "App Hide");
    }
  };
  const App = /* @__PURE__ */ _export_sfc(_sfc_main, [["__file", "/Users/gaoruicheng/Downloads/testCanvas/App.vue"]]);
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
