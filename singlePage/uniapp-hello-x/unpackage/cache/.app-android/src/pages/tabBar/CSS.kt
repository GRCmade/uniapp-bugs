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
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesTabBarCSS : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_u_link = resolveEasyComponent("u-link", GenComponentsULinkULinkClass);
        val _component_uni_collapse_item = resolveEasyComponent("uni-collapse-item", GenComponentsUniCollapseItemUniCollapseItemClass);
        val _component_uni_collapse = resolveEasyComponent("uni-collapse", GenComponentsUniCollapseUniCollapseClass);
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1", "background-color" to "#f8f8f8")), "enable-back-to-top" to "true"), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "uni-container"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "uni-header-logo"), utsArrayOf(
                    createElementVNode("image", utsMapOf("class" to "uni-header-image", "src" to "/static/cssIndex.png"))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-text-box"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "hello-text"), "uni-app x目前已支持的CSS属性，展示样式仅供参考，文档详见："),
                    createVNode(_component_u_link, utsMapOf("href" to "https://uniapp.dcloud.io/uni-app-x/css/", "text" to "https://uniapp.dcloud.io/uni-app-x/css/", "inWhiteList" to true), null, 8, utsArrayOf(
                        "href",
                        "text"
                    ))
                )),
                createVNode(_component_uni_collapse, null, utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                    return utsArrayOf(
                        createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.list, fun(item, __key, __index, _cached): Any {
                            return createVNode(_component_uni_collapse_item, utsMapOf("key" to item.id, "title" to item.name, "class" to "item"), utsMapOf("default" to withSlotCtx(fun(): UTSArray<Any> {
                                return utsArrayOf(
                                    createElementVNode(Fragment, null, RenderHelpers.renderList(item.pages, fun(page, key, __index, _cached): Any {
                                        return createElementVNode("view", utsMapOf("class" to "uni-navigate-item", "hover-class" to if (page.enable == false) {
                                            "";
                                        } else {
                                            "is--active";
                                        }
                                        , "key" to key, "onClick" to fun(){
                                            _ctx.goDetailPage(page);
                                        }
                                        ), utsArrayOf(
                                            createElementVNode("text", utsMapOf("class" to normalizeClass(utsArrayOf(
                                                "uni-navigate-text",
                                                if (page.enable == false) {
                                                    "text-disabled";
                                                } else {
                                                    "";
                                                }
                                            ))), toDisplayString(page.name), 3),
                                            createElementVNode("image", utsMapOf("src" to _ctx.arrowRightIcon, "class" to "uni-icon-size"), null, 8, utsArrayOf(
                                                "src"
                                            ))
                                        ), 8, utsArrayOf(
                                            "hover-class",
                                            "onClick"
                                        ));
                                    }
                                    ), 128)
                                );
                            }
                            ), "_" to 2), 1032, utsArrayOf(
                                "title"
                            ));
                        }
                        ), 128)
                    );
                }
                ), "_" to 1))
            ))
        ), 4);
    }
    open var list: UTSArray<ListItem2> by `$data`;
    open var arrowUpIcon: String by `$data`;
    open var arrowDownIcon: String by `$data`;
    open var arrowRightIcon: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("list" to utsArrayOf<ListItem2>(ListItem2(id = "background", name = "background", pages = utsArrayOf<Page4>(Page4(name = "background-color", url = "/pages/CSS/background/background-color"), Page4(name = "background-image", url = "/pages/CSS/background/background-image"))), ListItem2(id = "border", name = "border", pages = utsArrayOf<Page4>(Page4(name = "border", url = "/pages/CSS/border/border"), Page4(name = "border-width", url = "/pages/CSS/border/border-width"), Page4(name = "border-style", url = "/pages/CSS/border/border-style"), Page4(name = "border-color", url = "/pages/CSS/border/border-color"), Page4(name = "border-radius", url = "/pages/CSS/border/border-radius"), Page4(name = "border-top", url = "/pages/CSS/border/border-top"), Page4(name = "border-bottom", url = "/pages/CSS/border/border-bottom"), Page4(name = "border-left", url = "/pages/CSS/border/border-left"), Page4(name = "border-right", url = "/pages/CSS/border/border-right"), Page4(name = "border属性复合示例", url = "/pages/CSS/border/complex-border/complex-border"), Page4(name = "border动态修改样式", url = "/pages/CSS/border/dynamic-border"))), ListItem2(id = "box-shadow", name = "box-shadow", pages = utsArrayOf<Page4>(Page4(name = "box-shadow", url = "/pages/CSS/box-shadow/box-shadow"))), ListItem2(id = "display", name = "display", pages = utsArrayOf<Page4>(Page4(name = "flex", url = "/pages/CSS/display/flex"), Page4(name = "none", url = "/pages/CSS/display/none"))), ListItem2(id = "flex", name = "flex", pages = utsArrayOf<Page4>(Page4(name = "align-content", url = "/pages/CSS/flex/align-content"), Page4(name = "align-items", url = "/pages/CSS/flex/align-items"), Page4(name = "flex-basis", url = "/pages/CSS/flex/flex-basis"), Page4(name = "flex-direction", url = "/pages/CSS/flex/flex-direction"), Page4(name = "flex-flow", url = "/pages/CSS/flex/flex-flow"), Page4(name = "flex-grow", url = "/pages/CSS/flex/flex-grow"), Page4(name = "flex-shrink", url = "/pages/CSS/flex/flex-shrink"), Page4(name = "flex", url = "/pages/CSS/flex/flex"), Page4(name = "justify-content", url = "/pages/CSS/flex/justify-content"))), ListItem2(id = "layout", name = "layout", pages = utsArrayOf<Page4>(Page4(name = "height", url = "/pages/CSS/layout/height"), Page4(name = "max-height", url = "/pages/CSS/layout/max-height"), Page4(name = "max-width", url = "/pages/CSS/layout/max-width"), Page4(name = "min-height", url = "/pages/CSS/layout/min-height"), Page4(name = "min-width", url = "/pages/CSS/layout/min-width"), Page4(name = "position", url = "/pages/CSS/layout/position"), Page4(name = "width", url = "/pages/CSS/layout/width"), Page4(name = "z-index", url = "/pages/CSS/layout/z-index"), Page4(name = "visibility", url = "/pages/CSS/layout/visibility"))), ListItem2(id = "margin", name = "margin", pages = utsArrayOf<Page4>(Page4(name = "margin-bottom", url = "/pages/CSS/margin/margin-bottom"), Page4(name = "margin-left", url = "/pages/CSS/margin/margin-left"), Page4(name = "margin-right", url = "/pages/CSS/margin/margin-right"), Page4(name = "margin-top", url = "/pages/CSS/margin/margin-top"), Page4(name = "margin", url = "/pages/CSS/margin/margin"))), ListItem2(id = "padding", name = "padding", pages = utsArrayOf<Page4>(Page4(name = "padding-bottom", url = "/pages/CSS/padding/padding-bottom"), Page4(name = "padding-left", url = "/pages/CSS/padding/padding-left"), Page4(name = "padding-right", url = "/pages/CSS/padding/padding-right"), Page4(name = "padding-top", url = "/pages/CSS/padding/padding-top"), Page4(name = "padding", url = "/pages/CSS/padding/padding"))), ListItem2(id = "overflow", name = "overflow", pages = utsArrayOf<Page4>(Page4(name = "overflow", url = "/pages/CSS/overflow/overflow"), Page4(name = "overflow-visible-event", url = "/pages/CSS/overflow/overflow-visible-event"))), ListItem2(id = "text", name = "text", pages = utsArrayOf<Page4>(Page4(name = "color", url = "/pages/CSS/text/color"), Page4(name = "font-family", url = "/pages/CSS/text/font-family"), Page4(name = "font-size", url = "/pages/CSS/text/font-size"), Page4(name = "font-style", url = "/pages/CSS/text/font-style"), Page4(name = "font-weight", url = "/pages/CSS/text/font-weight"), Page4(name = "letter-spacing", url = "/pages/CSS/text/letter-spacing"), Page4(name = "line-height", url = "/pages/CSS/text/line-height"), Page4(name = "text-align", url = "/pages/CSS/text/text-align"), Page4(name = "text-overflow", url = "/pages/CSS/text/text-overflow"), Page4(name = "text-decoration-line", url = "/pages/CSS/text/text-decoration-line"))), ListItem2(id = "transform", name = "transform", pages = utsArrayOf<Page4>(Page4(name = "translate", url = "/pages/CSS/transform/translate"), Page4(name = "scale", url = "/pages/CSS/transform/scale"), Page4(name = "rotate", url = "/pages/CSS/transform/rotate"))), ListItem2(id = "transition", name = "transition", pages = utsArrayOf<Page4>(Page4(name = "transition", url = "/pages/CSS/transition/transition"))), ListItem2(id = "pointer-events", name = "pointer-events", pages = utsArrayOf<Page4>(Page4(name = "pointer-events", url = "/pages/CSS/pointer-events/pointer-events"))), ListItem2(id = "variable", name = "variable", pages = utsArrayOf<Page4>(Page4(name = "variable", url = "/pages/CSS/variable/variable")))), "arrowUpIcon" to "/static/icons/arrow-up.png", "arrowDownIcon" to "/static/icons/arrow-down.png", "arrowRightIcon" to "/static/icons/arrow-right.png");
    }
    override fun `$initMethods`() {
        this.goDetailPage = fun(e: Page4) {
            if (e.enable == false) {
                uni_showToast(ShowToastOptions(icon = "none", title = "暂不支持"));
                return;
            }
            val url = if (e.url != null) {
                e.url!!;
            } else {
                "/pages/CSS/" + e.name + "/" + e.name;
            }
            ;
            uni_navigateTo(NavigateToOptions(url = url));
        }
        ;
    }
    open lateinit var goDetailPage: (e: Page4) -> Unit;
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
                return utsMapOf("item" to padStyleMapOf(utsMapOf("marginBottom" to 12)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
