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
import io.dcloud.uniapp.extapi.getUniverifyManager as uni_getUniverifyManager;
import io.dcloud.uniapp.extapi.showModal as uni_showModal;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesAPIGetUniverifyManagerGetUniverifyManager : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onLoad(fun(_: OnLoadOptions) {
            this.univerifyManager = uni_getUniverifyManager();
            this.univerifyManager?.preLogin(PreLoginOptions(success = fun(){
                console.log("pre login success", " at pages/API/get-univerify-manager/get-univerify-manager.uvue:28");
            }
            , fail = fun(err: PreLoginFail){
                console.error("pre login fail => " + JSON.stringify(err), " at pages/API/get-univerify-manager/get-univerify-manager.uvue:31");
                uni_showToast(ShowToastOptions(title = "预登录失败"));
            }
            ));
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
            createElementVNode("view", utsMapOf("class" to "uni-padding-wrap uni-common-mt"), utsArrayOf(
                createElementVNode("view", utsMapOf("class" to "uni-btn-v uni-common-mt"), utsArrayOf(
                    createElementVNode("button", utsMapOf("type" to "primary", "onClick" to fun(){
                        _ctx.verify(false);
                    }
                    ), "一键登录（半屏）", 8, utsArrayOf(
                        "onClick"
                    ))
                )),
                createElementVNode("view", utsMapOf("class" to "uni-btn-v uni-common-mt"), utsArrayOf(
                    createElementVNode("button", utsMapOf("type" to "primary", "onClick" to fun(){
                        _ctx.verify(true);
                    }
                    ), "一键登录（全屏）", 8, utsArrayOf(
                        "onClick"
                    ))
                ))
            ))
        ));
    }
    open var title: String by `$data`;
    open var univerifyManager: UniverifyManager? by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("title" to "一键登录", "univerifyManager" to null as UniverifyManager?);
    }
    override fun `$initMethods`() {
        this.verify = fun(fullScreen: Boolean) {
            val isPreLoginValid = this.univerifyManager?.isPreLoginValid() ?: false;
            if (isPreLoginValid) {
                this.login(fullScreen);
            } else {
                this.univerifyManager?.preLogin(PreLoginOptions(success = fun(){
                    console.log("pre login success", " at pages/API/get-univerify-manager/get-univerify-manager.uvue:49");
                    this.login(fullScreen);
                }
                , fail = fun(err: PreLoginFail){
                    console.error("pre login fail => " + JSON.stringify(err), " at pages/API/get-univerify-manager/get-univerify-manager.uvue:53");
                    uni_showToast(ShowToastOptions(title = "预登录失败"));
                }
                ));
            }
        }
        ;
        this.login = fun(fullScreen: Boolean) {
            this.univerifyManager?.login(LoginOptions(univerifyStyle = UniverifyStyle(fullScreen = fullScreen, backgroundColor = "#FFFFFF", loginBtnText = "一键登录", logoPath = "/static/logo.png"), success = fun(res: LoginSuccess){
                console.log("login success => " + JSON.stringify(res), " at pages/API/get-univerify-manager/get-univerify-manager.uvue:71");
                uniCloud.callFunction(UniCloudCallFunctionOptions(name = "univerify", data = object : UTSJSONObject() {
                    var access_token = res.accessToken
                    var openid = res.openId
                })).then(fun(res){
                    this.univerifyManager?.close();
                    setTimeout(fun(){
                        uni_showModal(ShowModalOptions(title = "取号成功", content = res.result.getJSON("res")?.getString("phoneNumber"), showCancel = false));
                    }
                    , 100);
                }
                ).`catch`(fun(err){
                    console.error(JSON.stringify(err), " at pages/API/get-univerify-manager/get-univerify-manager.uvue:90");
                    this.univerifyManager?.close();
                    setTimeout(fun(){
                        uni_showModal(ShowModalOptions(title = "取号失败", content = (err as UTSError).message, showCancel = false));
                    }
                    , 100);
                }
                );
            }
            , fail = fun(err: LoginFail){
                console.error("login fail => " + err, " at pages/API/get-univerify-manager/get-univerify-manager.uvue:103");
                uni_showToast(ShowToastOptions(title = "登录失败"));
            }
            ));
        }
        ;
    }
    open lateinit var verify: (fullScreen: Boolean) -> Unit;
    open lateinit var login: (fullScreen: Boolean) -> Unit;
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
