@file:Suppress("UNCHECKED_CAST", "USELESS_CAST", "INAPPLICABLE_JVM_NAME", "UNUSED_ANONYMOUS_PARAMETER")
package uni.UNI174BAC2;
import io.dcloud.uniapp.*;
import io.dcloud.uniapp.extapi.*;
import io.dcloud.uniapp.framework.*;
import io.dcloud.uniapp.runtime.*;
import io.dcloud.uniapp.vue.*;
import io.dcloud.uniapp.vue.shared.*;
import io.dcloud.unicloud.*;
import io.dcloud.uts.*;
import io.dcloud.uts.Map;
import io.dcloud.uts.Set;
import io.dcloud.uts.UTSAndroid;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.async;
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery;
open class GenPagesAPINodesInfoNodesInfo : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onResize(fun(_: OnResizeOptions) {}, __ins);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass);
        val _component_node_child = resolveComponent("node-child");
        return createElementVNode("view", utsMapOf("class" to "page", "id" to "page"), utsArrayOf(
            createVNode(_component_page_head, utsMapOf("title" to _ctx.title), null, 8, utsArrayOf(
                "title"
            )),
            createElementVNode("button", utsMapOf("class" to "btn btn-get-node-info", "onClick" to _ctx.getNodeInfo), "getNodeInfo", 8, utsArrayOf(
                "onClick"
            )),
            createElementVNode("button", utsMapOf("class" to "btn btn-get-all-node-info", "onClick" to _ctx.getAllNodeInfo), "getAllNodeInfo", 8, utsArrayOf(
                "onClick"
            )),
            createElementVNode("view", utsMapOf("id" to "rect-1-2", "class" to "rect-1-2"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "rect rect1")),
                createElementVNode("view", utsMapOf("class" to "rect rect2"))
            )),
            createElementVNode("view", utsMapOf("class" to "rect-info-1-2"), utsArrayOf(
                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.nodeInfoList, fun(nodeInfo, index, __index, _cached): Any {
                    return createElementVNode("view", utsMapOf("class" to "rect-info", "key" to index), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "node-info-item"), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "node-info-item-k"), "left: "),
                            createElementVNode("text", utsMapOf("class" to "node-info-item-v"), toDisplayString(nodeInfo.left), 1)
                        )),
                        createElementVNode("view", utsMapOf("class" to "node-info-item"), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "node-info-item-k"), "top: "),
                            createElementVNode("text", utsMapOf("class" to "node-info-item-v"), toDisplayString(nodeInfo.top), 1)
                        )),
                        createElementVNode("view", utsMapOf("class" to "node-info-item"), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "node-info-item-k"), "right: "),
                            createElementVNode("text", utsMapOf("class" to "node-info-item-v"), toDisplayString(nodeInfo.right), 1)
                        )),
                        createElementVNode("view", utsMapOf("class" to "node-info-item"), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "node-info-item-k"), "bottom: "),
                            createElementVNode("text", utsMapOf("class" to "node-info-item-v"), toDisplayString(nodeInfo.bottom), 1)
                        )),
                        createElementVNode("view", utsMapOf("class" to "node-info-item"), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "node-info-item-k"), "width: "),
                            createElementVNode("text", utsMapOf("class" to "node-info-item-v"), toDisplayString(nodeInfo.width), 1)
                        )),
                        createElementVNode("view", utsMapOf("class" to "node-info-item"), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "node-info-item-k"), "height: "),
                            createElementVNode("text", utsMapOf("class" to "node-info-item-v"), toDisplayString(nodeInfo.height), 1)
                        ))
                    ));
                }
                ), 128)
            )),
            createVNode(_component_node_child, utsMapOf("class" to "node-child"))
        ));
    }
    open var title: String by `$data`;
    open var nodeInfoList: UTSArray<NodeInfoType> by `$data`;
    open var rootNodeInfo: NodeInfoType? by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("title" to "createSelectorQuery", "nodeInfoList" to utsArrayOf<NodeInfoType>(), "rootNodeInfo" to null as NodeInfoType?);
    }
    override fun `$initMethods`() {
        this.getRootNodeInfo = fun(selector: String) {
            uni_createSelectorQuery().select(selector).boundingClientRect().exec(fun(ret){
                if (ret.length == 1) {
                    val nodeInfo = ret[0] as NodeInfo;
                    val nodeType = NodeInfoType(left = nodeInfo.left, top = nodeInfo.top, right = nodeInfo.right, bottom = nodeInfo.bottom, width = nodeInfo.width, height = nodeInfo.height);
                    this.rootNodeInfo = nodeType;
                }
            }
            );
        }
        ;
        this.getNodeInfo = fun() {
            uni_createSelectorQuery().select(".rect1").boundingClientRect().exec(fun(ret){
                this.nodeInfoList.length = 0;
                val i = ret[0] as NodeInfo;
                this.nodeInfoList.push(NodeInfoType(left = i.left, top = i.top, right = i.right, bottom = i.bottom, width = i.width, height = i.height));
            }
            );
        }
        ;
        this.getAllNodeInfo = fun() {
            uni_createSelectorQuery().selectAll(".rect").boundingClientRect().exec(fun(ret){
                this.nodeInfoList.length = 0;
                val array = ret[0] as UTSArray<NodeInfo>;
                array.forEach(fun(i){
                    this.nodeInfoList.push(NodeInfoType(left = i.left, top = i.top, right = i.right, bottom = i.bottom, width = i.width, height = i.height));
                }
                );
            }
            );
        }
        ;
    }
    open lateinit var getRootNodeInfo: (selector: String) -> Unit;
    open lateinit var getNodeInfo: () -> Unit;
    open lateinit var getAllNodeInfo: () -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(
                    styles0
                ), utsArrayOf(
                    GenApp.styles
                ));
            }
        val styles0: Map<String, Map<String, Map<String, Any>>>
            get() {
                return utsMapOf("page" to padStyleMapOf(utsMapOf("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "flex" to 1)), "btn" to padStyleMapOf(utsMapOf("marginTop" to 15)), "rect-1-2" to padStyleMapOf(utsMapOf("flexDirection" to "row", "marginTop" to 15)), "rect" to padStyleMapOf(utsMapOf("width" to 150, "height" to 100)), "rect1" to padStyleMapOf(utsMapOf("backgroundColor" to "#1E90FF")), "rect2" to padStyleMapOf(utsMapOf("marginLeft" to "auto", "backgroundColor" to "#2E8B57")), "rect-info-1-2" to padStyleMapOf(utsMapOf("flexDirection" to "row", "marginTop" to 15)), "rect-info" to padStyleMapOf(utsMapOf("flex" to 1, "flexDirection" to "column")), "node-info-item" to padStyleMapOf(utsMapOf("flexDirection" to "row")), "node-info-item-k" to padStyleMapOf(utsMapOf("width" to 72, "lineHeight" to 2)), "node-info-item-v" to padStyleMapOf(utsMapOf("fontWeight" to "bold", "lineHeight" to 2)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf("nodeChild" to GenPagesAPINodesInfoNodesInfoChildClass);
    }
}
