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
import io.dcloud.uniapp.extapi.getWindowInfo as uni_getWindowInfo;
import io.dcloud.uniapp.extapi.hideToast as uni_hideToast;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesAPIToastToast : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onLoad(fun(_: OnLoadOptions) {
            uni_showToast(ShowToastOptions(title = "onLoad 调用示例,2秒后消失"));
            setTimeout(fun() {
                uni_hideToast();
            }
            , 2000);
        }
        , __ins);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass);
        return createElementVNode("view", null, utsArrayOf(
            createVNode(_component_page_head, utsMapOf("title" to _ctx.title), null, 8, utsArrayOf(
                "title"
            )),
            createElementVNode("view", utsMapOf("class" to "uni-padding-wrap"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "uni-btn-v"), utsArrayOf(
                    createElementVNode("button", utsMapOf("class" to "uni-btn-v", "type" to "default", "onClick" to _ctx.toast1Tap, "id" to "btn-toast-default"), "点击弹出默认toast", 8, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("button", utsMapOf("class" to "uni-btn-v", "type" to "default", "onClick" to _ctx.toastTapIconError, "id" to "btn-toast-errorIcon"), "点击弹出设置icon的toast", 8, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("button", utsMapOf("class" to "uni-btn-v", "type" to "default", "onClick" to _ctx.toast2Tap, "id" to "btn-toast-duration"), "点击弹出设置duration的toast", 8, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("button", utsMapOf("class" to "uni-btn-v", "type" to "default", "onClick" to _ctx.toast3Tap, "id" to "btn-toast-loading"), "点击弹出显示loading的toast", 8, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("button", utsMapOf("class" to "uni-btn-v", "type" to "default", "onClick" to _ctx.toast4Tap), "点击弹出显示自定义图片的toast", 8, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("button", utsMapOf("class" to "uni-btn-v", "type" to "default", "onClick" to _ctx.toast5Tap, "id" to "btn-toast-postion-bottom"), "点击显示无图标的居底toast", 8, utsArrayOf(
                        "onClick"
                    )),
                    createElementVNode("button", utsMapOf("class" to "uni-btn-v", "type" to "default", "onClick" to _ctx.hideToast, "id" to "btn-toast-hide"), "点击隐藏toast", 8, utsArrayOf(
                        "onClick"
                    ))
                )),
                createElementVNode("text", null, toDisplayString(_ctx.exeRet), 1)
            ))
        ));
    }
    open var title: String by `$data`;
    open var exeRet: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("title" to "toast", "exeRet" to "");
    }
    override fun `$initMethods`() {
        this.jest_getWindowInfo = fun(): GetWindowInfoResult {
            return uni_getWindowInfo();
        }
        ;
        this.toast1Tap = fun() {
            uni_showToast(ShowToastOptions(title = "默认", success = fun(res){
                this.exeRet = "success:" + JSON.stringify(res);
            }
            , fail = fun(res){
                this.exeRet = "fail:" + JSON.stringify(res);
            }
            ));
        }
        ;
        this.toastTapIconError = fun() {
            uni_showToast(ShowToastOptions(title = "默认", icon = "error", success = fun(res){
                this.exeRet = "success:" + JSON.stringify(res);
            }
            , fail = fun(res){
                this.exeRet = "fail:" + JSON.stringify(res);
            }
            ));
        }
        ;
        this.toast2Tap = fun() {
            uni_showToast(ShowToastOptions(title = "duration 3000", duration = 3000, success = fun(res){
                this.exeRet = "success:" + JSON.stringify(res);
            }
            , fail = fun(res){
                this.exeRet = "fail:" + JSON.stringify(res);
            }
            ));
        }
        ;
        this.toast3Tap = fun() {
            uni_showToast(ShowToastOptions(title = "loading", icon = "loading", duration = 5000, success = fun(res){
                this.exeRet = "success:" + JSON.stringify(res);
            }
            , fail = fun(res){
                this.exeRet = "fail:" + JSON.stringify(res);
            }
            ));
        }
        ;
        this.toast4Tap = fun() {
            uni_showToast(ShowToastOptions(title = "logo", image = "/static/uni.png", success = fun(res){
                this.exeRet = "success:" + JSON.stringify(res);
            }
            , fail = fun(res){
                this.exeRet = "fail:" + JSON.stringify(res);
            }
            ));
        }
        ;
        this.toast5Tap = fun() {
            uni_showToast(ShowToastOptions(title = "显示一段轻提示", position = "bottom", success = fun(res){
                this.exeRet = "success:" + JSON.stringify(res);
            }
            , fail = fun(res){
                this.exeRet = "fail:" + JSON.stringify(res);
            }
            ));
        }
        ;
        this.hideToast = fun() {
            uni_hideToast();
        }
        ;
    }
    open lateinit var jest_getWindowInfo: () -> GetWindowInfoResult;
    open lateinit var toast1Tap: () -> Unit;
    open lateinit var toastTapIconError: () -> Unit;
    open lateinit var toast2Tap: () -> Unit;
    open lateinit var toast3Tap: () -> Unit;
    open lateinit var toast4Tap: () -> Unit;
    open lateinit var toast5Tap: () -> Unit;
    open lateinit var hideToast: () -> Unit;
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
