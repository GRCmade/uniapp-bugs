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
import io.dcloud.uniapp.extapi.hideTabBar as uni_hideTabBar;
import io.dcloud.uniapp.extapi.navigateTo as uni_navigateTo;
import io.dcloud.uniapp.extapi.showTabBar as uni_showTabBar;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesTabBarComponent : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onReady(fun() {
            default1(this.`$refs`["upgradePopup"] as UniUpgradeCenterAppComponentPublicInstance);
        }
        , __ins);
        onLoad(fun(_: OnLoadOptions) {}, __ins);
        onPageShow(fun() {
            this.pageHiden = false;
        }
        , __ins);
        onHide(fun() {
            this.pageHiden = true;
        }
        , __ins);
        onBeforeUnmount(fun() {
            uni_showTabBar(null)?.`catch`(fun(_){});
        }
        , __ins);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_u_link = resolveEasyComponent("u-link", GenComponentsULinkULinkClass);
        val _component_uni_collapse_item = resolveEasyComponent("uni-collapse-item", GenComponentsUniCollapseItemUniCollapseItemClass);
        val _component_uni_collapse = resolveEasyComponent("uni-collapse", GenComponentsUniCollapseUniCollapseClass);
        val _component_uni_upgrade_center_app = resolveEasyComponent("uni-upgrade-center-app", GenUniModulesUniUpgradeCenterAppComponentsUniUpgradeCenterAppUniUpgradeCenterAppClass);
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1", "background-color" to "#f8f8f8")), "enable-back-to-top" to "true"), utsArrayOf(
            createElementVNode("view", utsMapOf("class" to "uni-container"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "uni-header-logo"), utsArrayOf(
                    createElementVNode("image", utsMapOf("class" to "uni-header-image", "src" to "/static/componentIndex.png"))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-text-box"), utsArrayOf(
                    createElementVNode("text", utsMapOf("class" to "hello-text"), "uni-app内置组件，展示样式仅供参考，文档详见："),
                    createVNode(_component_u_link, utsMapOf("href" to "https://uniapp.dcloud.io/uni-app-x/component/", "text" to "https://uniapp.dcloud.io/uni-app-x/component/", "inWhiteList" to true), null, 8, utsArrayOf(
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
                ), "_" to 1)),
                createVNode(_component_uni_upgrade_center_app, utsMapOf("ref" to "upgradePopup", "onShow" to _ctx.upgradePopupShow, "onClose" to _ctx.upgradePopupClose), null, 8, utsArrayOf(
                    "onShow",
                    "onClose"
                ))
            ))
        ), 4);
    }
    open var list: UTSArray<ListItem> by `$data`;
    open var arrowUpIcon: String by `$data`;
    open var arrowDownIcon: String by `$data`;
    open var arrowRightIcon: String by `$data`;
    open var pageHiden: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("list" to utsArrayOf<ListItem>(ListItem(id = "view", name = "视图容器", pages = utsArrayOf<Page>(Page(name = "view"), Page(name = "scroll-view"), Page(name = "swiper"), Page(name = "list-view"), Page(name = "sticky-header"), Page(name = "sticky-section"), Page(name = "nested-scroll-header"), Page(name = "nested-scroll-body"))), ListItem(id = "content", name = "基础内容", pages = utsArrayOf<Page>(Page(name = "text"), Page(name = "rich-text", enable = true), Page(name = "progress"))), ListItem(id = "form", name = "表单组件", pages = utsArrayOf<Page>(Page(name = "button"), Page(name = "checkbox"), Page(name = "form"), Page(name = "input"), Page(name = "picker-view"), Page(name = "radio"), Page(name = "slider"), Page(name = "slider-100"), Page(name = "switch"), Page(name = "textarea"))), ListItem(id = "nav", name = "导航", pages = utsArrayOf<Page>(Page(name = "navigator", enable = true))), ListItem(id = "media", name = "媒体组件", pages = utsArrayOf<Page>(Page(name = "image", enable = true), Page(name = "video", enable = true))), ListItem(id = "web-view", name = "网页", pages = utsArrayOf<Page>(Page(name = "网络网页", enable = true, url = "/pages/component/web-view/web-view"), Page(name = "本地网页", enable = true, url = "/pages/component/web-view-local/web-view-local"))), ListItem(id = "unicloud-db", name = "unicloud-db", pages = utsArrayOf<Page>(Page(name = "联系人", enable = true, url = "/pages/component/unicloud-db-contacts/list"), Page(name = "mixinDatacom", enable = true, url = "/pages/component/mixin-datacom/mixin-datacom"))), ListItem(id = "general-attr-event", name = "通用属性和事件", pages = utsArrayOf<Page>(Page(name = "通用属性", url = "/pages/component/general-attribute/general-attribute", enable = true), Page(name = "通用事件", url = "/pages/component/general-event/general-event", enable = true), Page(name = "touch事件", url = "/pages/component/general-event/touch-event", enable = true), Page(name = "Transition事件", url = "/pages/component/general-event/transition-event", enable = true)))), "arrowUpIcon" to "/static/icons/arrow-up.png" as String, "arrowDownIcon" to "/static/icons/arrow-down.png" as String, "arrowRightIcon" to "/static/icons/arrow-right.png" as String, "pageHiden" to false);
    }
    override fun `$initMethods`() {
        this.goDetailPage = fun(e: Page) {
            if (e.enable == false) {
                uni_showToast(ShowToastOptions(title = "暂不支持", icon = "none"));
                return;
            }
            val url = if (e.url != null) {
                e.url!!;
            } else {
                "/pages/component/" + e.name + "/" + e.name;
            }
            ;
            uni_navigateTo(NavigateToOptions(url = url));
        }
        ;
        this.upgradePopupShow = fun() {
            console.log("upgradePopup show", " at pages/tabBar/component.uvue:304");
            if (!this.pageHiden) {
                uni_hideTabBar(null)?.`catch`(fun(_){});
            }
        }
        ;
        this.upgradePopupClose = fun() {
            console.log("upgradePopup close", " at pages/tabBar/component.uvue:310");
            uni_showTabBar(null)?.`catch`(fun(_){});
        }
        ;
    }
    open lateinit var goDetailPage: (e: Page) -> Unit;
    open lateinit var upgradePopupShow: () -> Unit;
    open lateinit var upgradePopupClose: () -> Unit;
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
