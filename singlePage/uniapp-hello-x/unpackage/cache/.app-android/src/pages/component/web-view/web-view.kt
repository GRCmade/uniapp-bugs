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
import io.dcloud.uniapp.extapi.createWebviewContext as uni_createWebviewContext;
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
open class GenPagesComponentWebViewWebView : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onReady(fun() {
            this.webviewContext = uni_createWebviewContext("web-view", this);
        }
        , __ins);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_switch = resolveComponent("switch");
        return createElementVNode("scroll-view", utsMapOf("class" to "uni-flex-item"), utsArrayOf(
            createElementVNode("web-view", utsMapOf("id" to "web-view", "class" to "uni-flex-item", "src" to _ctx.src, "webview-styles" to _ctx.webview_styles, "horizontalScrollBarAccess" to _ctx.horizontalScrollBarAccess, "verticalScrollBarAccess" to _ctx.verticalScrollBarAccess, "onMessage" to _ctx.message, "onError" to _ctx.error, "onLoading" to _ctx.loading, "onLoad" to _ctx.load, "onDownload" to _ctx.download), null, 40, utsArrayOf(
                "src",
                "webview-styles",
                "horizontalScrollBarAccess",
                "verticalScrollBarAccess",
                "onMessage",
                "onError",
                "onLoading",
                "onLoad",
                "onDownload"
            )),
            createElementVNode("view", utsMapOf("class" to "uni-padding-wrap uni-common-mt"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "uni-btn-v"), utsArrayOf(
                    createElementVNode("input", utsMapOf("class" to "uni-input", "confirmType" to "go", "placeholder" to "输入网址跳转", "onConfirm" to _ctx.confirm, "maxlength" to "-1"), null, 40, utsArrayOf(
                        "onConfirm"
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-row uni-btn-v"), utsArrayOf(
                    createElementVNode("button", utsMapOf("class" to "uni-flex-item", "type" to "primary", "onClick" to _ctx.back), "后退", 8, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("button", utsMapOf("class" to "margin-left-5 uni-flex-item", "type" to "primary", "onClick" to _ctx.forward), "前进", 8, utsArrayOf(
                        "onClick"
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-row uni-btn-v"), utsArrayOf(
                    createElementVNode("button", utsMapOf("class" to "uni-flex-item", "type" to "primary", "onClick" to _ctx.reload), "重新加载", 8, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("button", utsMapOf("class" to "margin-left-5 uni-flex-item", "type" to "primary", "onClick" to _ctx.stop), "停止加载", 8, utsArrayOf(
                        "onClick"
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-btn-v"), utsArrayOf(
                    createElementVNode("button", utsMapOf("type" to "primary", "onClick" to _ctx.nativeToWeb), "原生和Web通信", 8, utsArrayOf(
                        "onClick"
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-row uni-btn-v"), utsArrayOf(
                    createElementVNode("view", utsMapOf("class" to "uni-row uni-flex-item align-items-center"), utsArrayOf(
                        createElementVNode("text", null, "显示横向滚动条"),
                        createVNode(_component_switch, utsMapOf("checked" to true, "onChange" to _ctx.changeHorizontalScrollBarAccess), null, 8, utsArrayOf(
                            "onChange"
                        ))
                    )),
                    createElementVNode("view", utsMapOf("class" to "uni-row uni-flex-item align-items-center"), utsArrayOf(
                        createElementVNode("text", null, "显示竖向滚动条"),
                        createVNode(_component_switch, utsMapOf("checked" to true, "onChange" to _ctx.changeVerticalScrollBarAccess), null, 8, utsArrayOf(
                            "onChange"
                        ))
                    ))
                ))
            ))
        ));
    }
    open var src: String by `$data`;
    open var webview_styles: UTSJSONObject by `$data`;
    open var webviewContext: WebviewContext? by `$data`;
    open var loadError: Boolean by `$data`;
    open var horizontalScrollBarAccess: Boolean by `$data`;
    open var verticalScrollBarAccess: Boolean by `$data`;
    open var autoTest: Boolean by `$data`;
    open var eventLoading: UTSJSONObject? by `$data`;
    open var eventLoad: UTSJSONObject? by `$data`;
    open var eventError: UTSJSONObject? by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("src" to "https://www.dcloud.io", "webview_styles" to object : UTSJSONObject() {
            var progress = object : UTSJSONObject() {
                var color = "#FF3333"
            }
        }, "webviewContext" to null as WebviewContext?, "loadError" to false, "horizontalScrollBarAccess" to true, "verticalScrollBarAccess" to true, "autoTest" to false, "eventLoading" to null as UTSJSONObject?, "eventLoad" to null as UTSJSONObject?, "eventError" to null as UTSJSONObject?);
    }
    override fun `$initMethods`() {
        this.back = fun() {
            this.webviewContext?.back();
        }
        ;
        this.forward = fun() {
            this.webviewContext?.forward();
        }
        ;
        this.reload = fun() {
            this.webviewContext?.reload();
        }
        ;
        this.stop = fun() {
            this.webviewContext?.stop();
        }
        ;
        this.nativeToWeb = fun() {
            this.webviewContext?.evalJS("alert('hello uni-app x')");
        }
        ;
        this.message = fun(event: UniWebViewMessageEvent) {
            console.log(JSON.stringify(event.detail), " at pages/component/web-view/web-view.uvue:84");
        }
        ;
        this.error = fun(event: UniWebViewErrorEvent) {
            this.loadError = true;
            console.log(JSON.stringify(event.detail), " at pages/component/web-view/web-view.uvue:88");
            if (this.autoTest) {
                this.eventError = UTSJSONObject(Map<String, Any?>(utsArrayOf(
                    utsArrayOf(
                        "tagName",
                        event.target?.tagName
                    ),
                    utsArrayOf(
                        "type",
                        event.type
                    ),
                    utsArrayOf(
                        "errCode",
                        event.detail.errCode
                    ),
                    utsArrayOf(
                        "errMsg",
                        event.detail.errMsg
                    ),
                    utsArrayOf(
                        "url",
                        event.detail.url
                    ),
                    utsArrayOf(
                        "fullUrl",
                        event.detail.fullUrl
                    ),
                    utsArrayOf(
                        "src",
                        event.detail.src
                    )
                )));
            }
        }
        ;
        this.loading = fun(event: UniWebViewLoadingEvent) {
            console.log(JSON.stringify(event.detail), " at pages/component/web-view/web-view.uvue:102");
            if (this.autoTest) {
                this.eventLoading = UTSJSONObject(Map<String, Any?>(utsArrayOf(
                    utsArrayOf(
                        "tagName",
                        event.target?.tagName
                    ),
                    utsArrayOf(
                        "type",
                        event.type
                    ),
                    utsArrayOf(
                        "src",
                        event.detail.src
                    )
                )));
            }
        }
        ;
        this.load = fun(event: UniWebViewLoadEvent) {
            console.log(JSON.stringify(event.detail), " at pages/component/web-view/web-view.uvue:112");
            if (this.autoTest) {
                this.eventLoad = UTSJSONObject(Map<String, Any?>(utsArrayOf(
                    utsArrayOf(
                        "tagName",
                        event.target?.tagName
                    ),
                    utsArrayOf(
                        "type",
                        event.type
                    ),
                    utsArrayOf(
                        "src",
                        event.detail.src
                    )
                )));
            }
        }
        ;
        this.download = fun(event: UniWebViewDownloadEvent) {
            console.log(JSON.stringify(event.detail), " at pages/component/web-view/web-view.uvue:122");
            uni_showModal(ShowModalOptions(content = "下载链接: " + event.detail.url + "\n文件大小: " + event.detail.contentLength / 1024 + "KB", showCancel = false));
        }
        ;
        this.confirm = fun(event: UniInputConfirmEvent) {
            var url = event.detail.value;
            if (!url.startsWith("https://") && !url.startsWith("http://")) {
                url = "https://" + url;
            }
            this.src = url;
        }
        ;
        this.changeHorizontalScrollBarAccess = fun(event: UniSwitchChangeEvent) {
            this.horizontalScrollBarAccess = event.detail.value;
        }
        ;
        this.changeVerticalScrollBarAccess = fun(event: UniSwitchChangeEvent) {
            this.verticalScrollBarAccess = event.detail.value;
        }
        ;
    }
    open lateinit var back: () -> Unit;
    open lateinit var forward: () -> Unit;
    open lateinit var reload: () -> Unit;
    open lateinit var stop: () -> Unit;
    open lateinit var nativeToWeb: () -> Unit;
    open lateinit var message: (event: UniWebViewMessageEvent) -> Unit;
    open lateinit var error: (event: UniWebViewErrorEvent) -> Unit;
    open lateinit var loading: (event: UniWebViewLoadingEvent) -> Unit;
    open lateinit var load: (event: UniWebViewLoadEvent) -> Unit;
    open lateinit var download: (event: UniWebViewDownloadEvent) -> Unit;
    open lateinit var confirm: (event: UniInputConfirmEvent) -> Unit;
    open lateinit var changeHorizontalScrollBarAccess: (event: UniSwitchChangeEvent) -> Unit;
    open lateinit var changeVerticalScrollBarAccess: (event: UniSwitchChangeEvent) -> Unit;
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
                return utsMapOf("margin-left-5" to padStyleMapOf(utsMapOf("marginLeft" to 5)), "align-items-center" to padStyleMapOf(utsMapOf("alignItems" to "center")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
