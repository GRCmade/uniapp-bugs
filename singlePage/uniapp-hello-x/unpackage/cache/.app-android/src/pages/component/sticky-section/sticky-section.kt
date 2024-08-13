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
import io.dcloud.uniapp.extapi.getElementById as uni_getElementById;
open class GenPagesComponentStickySectionStickySection : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_page_head, utsMapOf("title" to "sticky-section")),
            createElementVNode("list-view", utsMapOf("id" to "list-view", "ref" to "list-view", "show-scrollbar" to "false", "class" to "page", "scroll-into-view" to _ctx.scrollIntoView, "onScroll" to _ctx.onScroll, "onScrollend" to _ctx.onScrollEnd, "rebound" to "false"), utsArrayOf(
                createElementVNode("list-item", utsMapOf("style" to normalizeStyle(utsMapOf("padding" to "10px", "margin" to "5px 0", "align-items" to "center")), "type" to 20), utsArrayOf(
                    createElementVNode("button", utsMapOf("onClick" to fun(){
                        _ctx.gotoStickyHeader("C");
                    }
                    , "size" to "mini"), "跳转到id为C的sticky-header位置上", 8, utsArrayOf(
                        "onClick"
                    ))
                ), 4),
                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.data, fun(sectionText, __key, __index, _cached): Any {
                    return createElementVNode("sticky-section", utsMapOf("padding" to _ctx.sectionPadding, "push-pinned-header" to true), utsArrayOf(
                        createElementVNode("sticky-header", utsMapOf("header-id" to sectionText, "id" to sectionText), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to "sticky-header-text"), toDisplayString(sectionText), 1)
                        ), 8, utsArrayOf(
                            "header-id",
                            "id"
                        )),
                        createElementVNode(Fragment, null, RenderHelpers.renderList(10, fun(i, __key, __index, _cached): Any {
                            return createElementVNode("list-item", utsMapOf("class" to "content-item", "type" to 10), utsArrayOf(
                                createElementVNode("text", utsMapOf("class" to "text"), toDisplayString(sectionText) + "--item--content----" + toDisplayString(i), 1)
                            ));
                        }
                        ), 64)
                    ), 8, utsArrayOf(
                        "padding"
                    ));
                }
                ), 256),
                createElementVNode("list-item", utsMapOf("style" to normalizeStyle(utsMapOf("padding" to "10px", "margin" to "5px 0", "align-items" to "center")), "type" to 30), utsArrayOf(
                    createElementVNode("button", utsMapOf("onClick" to _ctx.toTop, "size" to "mini"), "回到顶部", 8, utsArrayOf(
                        "onClick"
                    ))
                ), 4)
            ), 40, utsArrayOf(
                "scroll-into-view",
                "onScroll",
                "onScrollend"
            ))
        ), 64);
    }
    open var data: UTSArray<String> by `$data`;
    open var sectionPadding: UTSArray<Number> by `$data`;
    open var scrollIntoView: String by `$data`;
    open var scrolling: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("data" to utsArrayOf(
            "A",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G",
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "N"
        ), "sectionPadding" to utsArrayOf<Number>(0, 10, 0, 10), "scrollIntoView" to "", "scrolling" to false);
    }
    override fun `$initMethods`() {
        this.toTop = fun() {
            this.scrollIntoView = "";
            uni_getElementById("list-view")!!.scrollTop = 0;
        }
        ;
        this.listViewScrollByY = fun(y: Number) {
            val listview = this.`$refs`["list-view"] as UniElement;
            listview.scrollTop = y;
        }
        ;
        this.gotoStickyHeader = fun(id: String) {
            this.scrollIntoView = id;
        }
        ;
        this.onScroll = fun() {
            this.scrolling = true;
        }
        ;
        this.onScrollEnd = fun() {
            this.scrolling = false;
            if (this.scrollIntoView != "") {
                this.scrollIntoView = "";
            }
        }
        ;
    }
    open lateinit var toTop: () -> Unit;
    open lateinit var listViewScrollByY: (y: Number) -> Unit;
    open lateinit var gotoStickyHeader: (id: String) -> Unit;
    open lateinit var onScroll: () -> Unit;
    open lateinit var onScrollEnd: () -> Unit;
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
                return utsMapOf("page" to padStyleMapOf(utsMapOf("flex" to 1, "backgroundColor" to "#f5f5f5")), "sticky-header-text" to padStyleMapOf(utsMapOf("fontSize" to 16, "paddingTop" to 8, "paddingRight" to 8, "paddingBottom" to 8, "paddingLeft" to 8, "color" to "#959595", "backgroundColor" to "#f5f5f5")), "content-item" to padStyleMapOf(utsMapOf("paddingTop" to 15, "paddingRight" to 15, "paddingBottom" to 15, "paddingLeft" to 15, "marginBottom" to 10, "backgroundColor" to "#ffffff")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
