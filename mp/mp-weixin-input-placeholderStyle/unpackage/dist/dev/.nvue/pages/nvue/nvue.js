import { resolveComponent, openBlock, createElementBlock, createElementVNode, Fragment, renderList, createVNode } from "vue";
const _export_sfc = (sfc, props) => {
  const target = sfc.__vccOpts || sfc;
  for (const [key, val] of props) {
    target[key] = val;
  }
  return target;
};
const _sfc_main = {
  data() {
    return {
      title: "Hello",
      msgContentNodes: [{
        "name": "p",
        "attrs": {
          "style": "font-size:15px;text-align: justify;line-heihgt:19;"
        },
        "children": [{
          "name": "p",
          "attrs": {
            "style": "color:#7a7a7a;"
          },
          "children": [{
            "type": "text",
            "text": "测试文案。"
          }]
        }]
      }]
    };
  },
  onLoad() {
  },
  methods: {}
};
function _sfc_render(_ctx, _cache, $props, $setup, $data, $options) {
  const _component_rich_text = resolveComponent("rich-text");
  return openBlock(), createElementBlock("scroll-view", {
    scrollY: true,
    showScrollbar: true,
    enableBackToTop: true,
    bubble: "true",
    style: { flexDirection: "column" }
  }, [
    createElementVNode("view", null, [
      createElementVNode("list", null, [
        (openBlock(), createElementBlock(
          Fragment,
          null,
          renderList(100, (item, index) => {
            return createElementVNode("cell", { style: { "background-color": "#ebee16" } }, [
              createVNode(_component_rich_text, { nodes: $data.msgContentNodes }, null, 8, ["nodes"])
            ]);
          }),
          64
          /* STABLE_FRAGMENT */
        ))
      ])
    ])
  ]);
}
const nvue = /* @__PURE__ */ _export_sfc(_sfc_main, [["render", _sfc_render], ["__file", "/Users/gaoruicheng/Documents/HBuilderProjects/macbookpro/pages/nvue/nvue.nvue"]]);
export {
  nvue as default
};
