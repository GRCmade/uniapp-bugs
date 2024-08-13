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
open class GenPagesTabBarTemplate : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_u_link = resolveEasyComponent("u-link", GenComponentsULinkULinkClass);
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1", "background-color" to "#f8f8f8")), "enable-back-to-top" to "true"), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "uni-container"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "uni-header-logo"), utsArrayOf(
                    createElementVNode("image", utsMapOf("class" to "uni-header-image", "src" to "/static/templateIndex.png"))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-text-box"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "hello-text"), "以下是部分模板示例，更多模板见插件市场："),
                    createVNode(_component_u_link, utsMapOf("href" to "https://ext.dcloud.net.cn", "text" to "https://ext.dcloud.net.cn", "inWhiteList" to true), null, 8, utsArrayOf(
                        "text"
                    ))
                )),
                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.list, fun(item, index, __index, _cached): Any {
                    return createElementVNode("view", utsMapOf("class" to "uni-panel", "key" to item.id), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to normalizeClass(utsArrayOf(
                            "uni-panel-h",
                            if (item.open) {
                                "uni-panel-h-on";
                            } else {
                                "";
                            }
                        )), "onClick" to fun(){
                            _ctx.triggerCollapse(index, item);
                        }
                        ), utsArrayOf(
                            createElementVNode("text", utsMapOf("class" to normalizeClass(utsArrayOf(
                                "uni-panel-text",
                                if (item.enable == false) {
                                    "text-disabled";
                                } else {
                                    "";
                                }
                            ))), toDisplayString(item.name), 3),
                            createElementVNode("image", utsMapOf("src" to if (item.pages.length > 0) {
                                if (item.open) {
                                    _ctx.arrowUpIcon;
                                } else {
                                    _ctx.arrowDownIcon;
                                };
                            } else {
                                _ctx.arrowRightIcon;
                            }
                            , "class" to "uni-icon-size"), null, 8, utsArrayOf(
                                "src"
                            ))
                        ), 10, utsArrayOf(
                            "onClick"
                        )),
                        if (isTrue(item.open)) {
                            createElementVNode("view", utsMapOf("key" to 0), utsArrayOf(
                                createElementVNode(Fragment, null, RenderHelpers.renderList(item.pages, fun(page, key, __index, _cached): Any {
                                    return createElementVNode("view", utsMapOf("class" to "uni-navigate-item", "hover-class" to if (page.enable == false) {
                                        "";
                                    } else {
                                        "is--active";
                                    }, "key" to key, "onClick" to fun(){
                                        _ctx.goDetailPage(page);
                                    }), utsArrayOf(
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
                                }), 128)
                            ));
                        } else {
                            createCommentVNode("v-if", true);
                        }
                    ));
                }
                ), 128)
            ))
        ), 4);
    }
    open var list: UTSArray<ListItem3> by `$data`;
    open var arrowUpIcon: String by `$data`;
    open var arrowDownIcon: String by `$data`;
    open var arrowRightIcon: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("list" to utsArrayOf<ListItem3>(ListItem3(id = "long-list", url = "long-list", name = "左右滑动长列表", open = false, enable = true, pages = utsArrayOf<Page5>(Page5(name = "Android顶部搜索框随时下移长列表", url = "long-list"), Page5(name = "顶部banner长列表（嵌套滚动）", url = "long-list-nested"))), ListItem3(id = "list-news", url = "list-news", name = "列表到详情（吸顶）", open = false, pages = utsArrayOf<Page5>()), ListItem3(id = "swiper-list", url = "swiper-list", name = "swiper-list", open = false, pages = utsArrayOf<Page5>(Page5(name = "下划线样式", url = "swiper-list"), Page5(name = "字体放大样式", url = "swiper-list2"))), ListItem3(id = "custom-long-list", url = "custom-long-list", name = "自定义虚拟长列表uni-recycle-view", open = false, pages = utsArrayOf<Page5>()), ListItem3(id = "scroll-fold-nav", url = "scroll-fold-nav", name = "随滚动折叠的导航栏", open = false, pages = utsArrayOf<Page5>()), ListItem3(id = "custom-refresher", url = "custom-refresher", name = "自定义下拉刷新", open = false, pages = utsArrayOf<Page5>()), ListItem3(id = "pull-zoom-image", url = "pull-zoom-image", name = "下拉缩放顶部封面图", open = false, pages = utsArrayOf<Page5>()), ListItem3(id = "scroll-sticky", url = "scroll-sticky", name = "scroll-view自定义滚动吸顶", open = false, pages = utsArrayOf<Page5>()), ListItem3(id = "swiper-vertical-video", url = "swiper-vertical-video", name = "竖滑视频", open = false, pages = utsArrayOf<Page5>()), ListItem3(id = "half-screen", url = "half-screen", name = "半屏弹窗", open = false, pages = utsArrayOf<Page5>()), ListItem3(id = "drop-card", url = "drop-card", name = "划走式卡片", open = false, pages = utsArrayOf<Page5>()), ListItem3(id = "navbar-lite", url = "navbar-lite", name = "自定义导航栏", open = false, pages = utsArrayOf<Page5>()), ListItem3(id = "custom-tab-bar", url = "custom-tab-bar", name = "自定义TabBar", open = false, enable = true, pages = utsArrayOf<Page5>()), ListItem3(id = "calendar", url = "calendar", name = "日历", open = false, pages = utsArrayOf<Page5>()), ListItem3(id = "schema", url = "schema", name = "打开外部链接", open = false, pages = utsArrayOf<Page5>()), ListItem3(id = "share", url = "share", name = "分享示例", open = false, pages = utsArrayOf<Page5>())), "arrowUpIcon" to "/static/icons/arrow-up.png", "arrowDownIcon" to "/static/icons/arrow-down.png", "arrowRightIcon" to "/static/icons/arrow-right.png");
    }
    override fun `$initMethods`() {
        this.triggerCollapse = fun(index: Number, item: ListItem3) {
            if (item.pages.length == 0) {
                val page = Page5(name = item.name, enable = item.enable, url = item.url!!);
                this.goDetailPage(page);
                return;
            }
            run {
                var i: Number = 0;
                while(i < this.list.length){
                    if (index == i) {
                        this.list[i].open = !this.list[i].open;
                    } else {
                        this.list[i].open = false;
                    }
                    ++i;
                }
            }
        }
        ;
        this.goDetailPage = fun(e: Page5) {
            if (e.enable == false) {
                uni_showToast(ShowToastOptions(icon = "none", title = "暂不支持"));
                return;
            }
            val url = if (e.url.indexOf("platform") > -1) {
                e.url;
            } else {
                "/pages/template/" + e.url + "/" + e.url;
            }
            ;
            uni_navigateTo(NavigateToOptions(url = url));
        }
        ;
    }
    open lateinit var triggerCollapse: (index: Number, item: ListItem3) -> Unit;
    open lateinit var goDetailPage: (e: Page5) -> Unit;
    companion object {
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf(), utsArrayOf(
                    GenApp.styles
                ));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
