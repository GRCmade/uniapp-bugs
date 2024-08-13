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
open class GenPagesTabBarAPI : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onLoad(fun(_: OnLoadOptions) {}, __ins);
        onPageShow(fun() {}, __ins);
        onHide(fun() {}, __ins);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_u_link = resolveEasyComponent("u-link", GenComponentsULinkULinkClass);
        val _component_uni_collapse_item = resolveEasyComponent("uni-collapse-item", GenComponentsUniCollapseItemUniCollapseItemClass);
        val _component_uni_collapse = resolveEasyComponent("uni-collapse", GenComponentsUniCollapseUniCollapseClass);
        val _component_api_set_tabbar = resolveEasyComponent("api-set-tabbar", GenComponentsApiSetTabbarApiSetTabbarClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1", "background-color" to "#f8f8f8")), "enable-back-to-top" to "true"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "uni-container"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "uni-header-logo"), utsArrayOf(
                        createElementVNode("image", utsMapOf("class" to "uni-header-image", "src" to "/static/apiIndex.png"))
                    )),
                    createElementVNode("view", utsMapOf("class" to "uni-text-box"), utsArrayOf(
                        createElementVNode("text", utsMapOf("class" to "hello-text"), "以下将演示uni-app接口能力，详细文档见："),
                        createVNode(_component_u_link, utsMapOf("href" to "https://uniapp.dcloud.io/uni-app-x/api/", "text" to "https://uniapp.dcloud.io/uni-app-x/api/", "inWhiteList" to true), null, 8, utsArrayOf(
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
            ), 4),
            createElementVNode("view", utsMapOf("ref" to "pop", "onClick" to fun(){
                _ctx.hidePop();
            }
            , "class" to "popup"), utsArrayOf(
                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "90%", "background-color" to "white")), "onClick" to _ctx.stopClickPop), utsArrayOf(
                    createVNode(_component_api_set_tabbar)
                ), 12, utsArrayOf(
                    "onClick"
                ))
            ), 8, utsArrayOf(
                "onClick"
            ))
        ), 64);
    }
    open var list: UTSArray<ListItem1> by `$data`;
    open var arrowUpIcon: String by `$data`;
    open var arrowDownIcon: String by `$data`;
    open var arrowRightIcon: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("list" to utsArrayOf<ListItem1>(ListItem1(id = "global", name = "全局", pages = utsArrayOf<Page1>(Page1(name = "getApp", url = "get-app"), Page1(name = "getCurrentPages", url = "get-current-pages"))), ListItem1(id = "base", name = "基础", pages = utsArrayOf<Page1>(Page1(name = "事件总线event-bus", url = "event-bus", api = utsArrayOf(
            "\$on",
            "\$once",
            "\$off",
            "\$emit"
        )), Page1(name = "拦截器", url = "interceptor", api = utsArrayOf(
            "addInterceptor",
            "removeInterceptor"
        )), Page1(name = "获取启动参数", url = "get-launch-options-sync"), Page1(name = "env环境变量", url = "env"), Page1(name = "退出应用", url = "exit"))), ListItem1(id = "page", name = "页面和路由", pages = utsArrayOf<Page1>(Page1(name = "页面跳转", url = "navigator", api = utsArrayOf(
            "navigateTo",
            "reLaunch",
            "navigateBack",
            "redirectTo",
            "switchTab"
        )), Page1(name = "设置导航条标题", url = "set-navigation-bar-title"), Page1(name = "设置导航条颜色", url = "set-navigation-bar-color"), Page1(name = "设置页面容器背景色", url = "set-page-backgroundColorContent"), Page1(name = "设置TabBar", url = "set-tabbar", api = utsArrayOf(
            "showTabBar",
            "hideTabBar",
            "showTabBarRedDot",
            "hideTabBarRedDot",
            "setTabBarBadge",
            "removeTabBarBadge",
            "setTabBarStyle",
            "setTabBarItem"
        )), Page1(name = "页面下拉刷新", url = "pull-down-refresh", api = utsArrayOf(
            "stopPullDownRefresh"
        )), Page1(name = "将页面滚动到指定位置", url = "page-scroll-to"))), ListItem1(id = "ui", name = "界面", pages = utsArrayOf<Page1>(Page1(name = "element元素", url = "get-element-by-id", api = utsArrayOf(
            "getElementById"
        )), Page1(name = "element draw", url = "element-draw", api = utsArrayOf(
            "Element.getDrawableContext"
        )), Page1(name = "element截图", url = "element-takesnapshot", api = utsArrayOf(
            "Element.takeSnapshot"
        )), Page1(name = "element大小变化监听", url = "resize-observer"), Page1(name = "node节点", url = "nodes-info", api = utsArrayOf(
            "createSelectorQuery"
        )), Page1(name = "动态加载字体", url = "load-font-face"), Page1(name = "rpx2px", url = "rpx2px"), Page1(name = "actionSheet操作菜单", url = "action-sheet"), Page1(name = "showModal模态弹窗", url = "modal", api = utsArrayOf(
            "showModal"
        )), Page1(name = "showLoading等待框", url = "loading"), Page1(name = "showToast轻提示框", url = "toast", api = utsArrayOf(
            "showToast"
        )), Page1(name = "主题切换", url = "theme-change", api = utsArrayOf(
            "setAppTheme",
            "onOsThemeChange",
            "offOsThemeChange",
            "onAppThemeChange",
            "offAppThemeChange"
        )))), ListItem1(id = "network", name = "网络", pages = utsArrayOf<Page1>(Page1(name = "发起请求request", url = "request"), Page1(name = "上传文件", url = "upload-file"), Page1(name = "下载文件", url = "download-file"), Page1(name = "获取设备网络状态", url = "get-network-type"), Page1(name = "socketTask", url = "websocket-socketTask", api = utsArrayOf(
            ""
        )), Page1(name = "全局websocket", url = "websocket-global", api = utsArrayOf(
            "connectSocket",
            "onSocketOpen",
            "onSocketError",
            "sendSocketMessage",
            "onSocketMessage",
            "closeSocket",
            "onSocketClose"
        )))), ListItem1(id = "device", name = "设备", pages = utsArrayOf<Page1>(Page1(name = "获取系统信息", url = "get-system-info"), Page1(name = "获取设备信息", url = "get-device-info"), Page1(name = "获取窗口信息", url = "get-window-info"), Page1(name = "获取APP基础信息", url = "get-app-base-info"), Page1(name = "获取APP授权设置", url = "get-app-authorize-setting"), Page1(name = "获取系统设置", url = "get-system-setting"), Page1(name = "电量", url = "get-battery-info"), Page1(name = "安装Apk", url = "install-apk"))), ListItem1(id = "media", name = "媒体", pages = utsArrayOf<Page1>(Page1(name = "拍摄图片或从相册中选择图片", url = "choose-image"), Page1(name = "图片预览", url = "preview-image", api = utsArrayOf(
            "previewImage",
            "closePreviewImage"
        )), Page1(name = "保存图片到相册", url = "save-image-to-photos-album"), Page1(name = "获取图片信息", url = "get-image-info"), Page1(name = "压缩图片", url = "compress-image"), Page1(name = "拍摄视频或从相册中选择视频", url = "choose-video"), Page1(name = "保存视频到相册", url = "save-video-to-photos-album"), Page1(name = "获取视频信息", url = "get-video-info"), Page1(name = "压缩视频", url = "compress-video"))), ListItem1(id = "location", name = "位置", pages = utsArrayOf<Page1>(Page1(name = "获取当前位置", url = "get-location"))), ListItem1(id = "storage", name = "数据存储", pages = utsArrayOf<Page1>(Page1(name = "storage（key-value存储）", url = "storage", api = utsArrayOf(
            "getStorageInfo",
            "getStorageInfoSync",
            "getStorage",
            "getStorageSync",
            "setStorage",
            "setStorageSync",
            "removeStorage",
            "removeStorageSync",
            "clearStorage",
            "clearStorageSync"
        )))), ListItem1(id = "file", name = "文件", pages = utsArrayOf<Page1>(Page1(name = "fileSystemManager文件管理", url = "get-file-system-manager"))), ListItem1(id = "unicloud", name = "uniCloud", pages = utsArrayOf<Page1>(Page1(name = "云函数", url = "unicloud-call-function"), Page1(name = "云对象", url = "unicloud-import-object"), Page1(name = "云存储", url = "unicloud-file-api"), Page1(name = "clientDB", url = "unicloud-database"))), ListItem1(id = "login", name = "登录与认证", pages = utsArrayOf<Page1>(Page1(name = "一键登录", url = "get-univerify-manager"), Page1(name = "实人认证", url = "facial-recognition-verify"))), ListItem1(id = "ad", name = "广告", pages = utsArrayOf<Page1>(Page1(name = "激励视频广告", url = "rewarded-video-ad"))), ListItem1(id = "payment", name = "支付", pages = utsArrayOf<Page1>(Page1(name = "简易支付示例", url = "request-payment"), Page1(name = "uni-pay支付示例", url = "request-payment-uni-pay"))), ListItem1(id = "permission-listener", name = "权限申请监听", pages = utsArrayOf<Page1>(Page1(name = "权限申请监听", url = "create-request-permission-listener")))), "arrowUpIcon" to "/static/icons/arrow-up.png", "arrowDownIcon" to "/static/icons/arrow-down.png", "arrowRightIcon" to "/static/icons/arrow-right.png");
    }
    override fun `$initMethods`() {
        this.goDetailPage = fun(e: Page1) {
            if (e.enable == false) {
                uni_showToast(ShowToastOptions(title = "暂不支持", icon = "none"));
                return;
            }
            if (e.url === "set-tabbar") {
                this.showPop();
                return;
            }
            val url = if (e.url.indexOf("platform") > -1) {
                e.url;
            } else {
                "/pages/API/" + e.url + "/" + e.url;
            }
            ;
            uni_navigateTo(NavigateToOptions(url = url));
        }
        ;
        this.showPop = fun() {
            (this.`$refs`["pop"] as UniElement).style.setProperty("display", "flex");
        }
        ;
        this.hidePop = fun() {
            (this.`$refs`["pop"] as UniElement).style.setProperty("display", "none");
        }
        ;
        this.stopClickPop = fun(e: PointerEvent) {
            e.stopPropagation();
        }
        ;
    }
    open lateinit var goDetailPage: (e: Page1) -> Unit;
    open lateinit var showPop: () -> Unit;
    open lateinit var hidePop: () -> Unit;
    open lateinit var stopClickPop: (e: PointerEvent) -> Unit;
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
                return utsMapOf("item" to padStyleMapOf(utsMapOf("marginBottom" to 12)), "popup" to padStyleMapOf(utsMapOf("width" to "100%", "position" to "absolute", "height" to "100%", "alignItems" to "center", "justifyContent" to "center", "display" to "none", "backgroundColor" to "rgba(16,16,16,0.5)")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
