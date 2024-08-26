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
import io.dcloud.uniapp.extapi.getAppBaseInfo as uni_getAppBaseInfo;
import io.dcloud.uniapp.extapi.getProvider as uni_getProvider;
import io.dcloud.uniapp.extapi.hideLoading as uni_hideLoading;
import io.dcloud.uniapp.extapi.request as uni_request;
import io.dcloud.uniapp.extapi.requestPayment as uni_requestPayment;
import io.dcloud.uniapp.extapi.showLoading as uni_showLoading;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesAPIRequestPaymentRequestPayment : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onLoad(fun(_: OnLoadOptions) {
            uni_getProvider(GetProviderOptions(service = "payment", success = fun(e){
                console.log("payment success:" + JSON.stringify(e), " at pages/API/request-payment/request-payment.uvue:28");
                var array = e.provider as UTSArray<String>;
                array.forEach(fun(value: String){
                    when (value) {
                        "alipay" -> 
                            this.providerList.push(PayItem(name = "支付宝", id = "alipay", provider = e.providers.find(fun(item): Boolean {
                                return item.id == "alipay";
                            }
                            )));
                        "wxpay" -> 
                            this.providerList.push(PayItem(name = "微信", id = "wxpay", provider = e.providers.find(fun(item): Boolean {
                                return item.id == "wxpay";
                            }
                            )));
                        else -> 
                            {}
                    }
                }
                );
            }
            , fail = fun(e){
                console.log("获取支付通道失败：", e, " at pages/API/request-payment/request-payment.uvue:56");
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
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_page_head, utsMapOf("title" to "发起支付")),
            if (_ctx.providerList.length > 0) {
                createElementVNode(Fragment, utsMapOf("key" to 0), RenderHelpers.renderList(_ctx.providerList, fun(item, index, __index, _cached): Any {
                    return createElementVNode("button", utsMapOf("style" to normalizeStyle(utsMapOf("margin-top" to "20px")), "type" to "primary", "key" to index, "onClick" to fun(){
                        _ctx.requestPayment(item);
                    }), toDisplayString(item.name) + "支付", 13, utsArrayOf(
                        "onClick"
                    ));
                }), 128);
            } else {
                createCommentVNode("v-if", true);
            }
        ), 64);
    }
    open var btnText: String by `$data`;
    open var btnType: String by `$data`;
    open var orderInfo: String by `$data`;
    open var errorCode: Number by `$data`;
    open var errorMsg: String by `$data`;
    open var complete: Boolean by `$data`;
    open var providerList: UTSArray<PayItem> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("btnText" to "支付宝支付", "btnType" to "primary", "orderInfo" to "", "errorCode" to 0, "errorMsg" to "", "complete" to false, "providerList" to utsArrayOf<PayItem>());
    }
    override fun `$initMethods`() {
        this.requestPayment = fun(e: PayItem) {
            val provider = e.id;
            if (provider == "alipay") {
                this.payAli();
            } else if (provider == "wxpay") {
                if (e.provider != null && e.provider?.isAppExist == false) {
                    uni_showToast(ShowToastOptions(title = "微信没有安装", icon = "error"));
                } else {
                    this.payWX();
                }
            }
        }
        ;
        this.payAli = fun() {
            uni_showLoading(ShowLoadingOptions(title = "请求中..."));
            uni_request<Any>(RequestOptions(url = "https://demo.dcloud.net.cn/payment/alipay/?total=0.01", method = "GET", timeout = 6000, success = fun(res){
                this.orderInfo = JSON.stringify(res.data);
                console.log("====" + this.orderInfo, " at pages/API/request-payment/request-payment.uvue:88");
                uni_hideLoading();
                uni_requestPayment(RequestPaymentOptions(provider = "alipay", orderInfo = res.data as String, fail = fun(res){
                    console.log(JSON.stringify(res), " at pages/API/request-payment/request-payment.uvue:94");
                    this.errorCode = res.errCode;
                    uni_showToast(ShowToastOptions(icon = "error", title = "errorCode:" + this.errorCode));
                }
                , success = fun(res){
                    console.log(JSON.stringify(res), " at pages/API/request-payment/request-payment.uvue:102");
                    uni_showToast(ShowToastOptions(icon = "success", title = "支付成功"));
                }
                ));
            }
            , fail = fun(e){
                console.log(e, " at pages/API/request-payment/request-payment.uvue:111");
                uni_hideLoading();
            }
            ));
        }
        ;
        this.payWX = fun() {
            uni_showLoading(ShowLoadingOptions(title = "请求中..."));
            var url = "https://demo.dcloud.net.cn/payment/wxpayv3.__UNI__uniappx/?total=0.01";
            val res = uni_getAppBaseInfo(null);
            var packageName: String?;
            packageName = res.packageName;
            if (packageName == "io.dcloud.hellouniappx") {
                url = "https://demo.dcloud.net.cn/payment/wxpayv3.__UNI__HelloUniAppX/?total=0.01";
            }
            uni_request<Any>(RequestOptions(url = url, method = "GET", timeout = 6000, header = UTSJSONObject(Map<String, Any?>(utsArrayOf(
                utsArrayOf(
                    "Content-Type",
                    "application/json"
                )
            ))), success = fun(res){
                console.log(res.data, " at pages/API/request-payment/request-payment.uvue:143");
                uni_hideLoading();
                uni_requestPayment(RequestPaymentOptions(provider = "wxpay", orderInfo = JSON.stringify(res.data), fail = fun(res){
                    console.log(JSON.stringify(res), " at pages/API/request-payment/request-payment.uvue:149");
                    this.errorCode = res.errCode;
                    uni_showToast(ShowToastOptions(duration = 5000, icon = "error", title = "errorCode:" + this.errorCode));
                }
                , success = fun(res){
                    console.log(JSON.stringify(res), " at pages/API/request-payment/request-payment.uvue:158");
                    uni_showToast(ShowToastOptions(duration = 5000, icon = "success", title = "支付成功"));
                }
                ));
            }
            , fail = fun(res){
                uni_hideLoading();
                console.log(res, " at pages/API/request-payment/request-payment.uvue:169");
            }
            ));
        }
        ;
        this.jest_pay = fun() {
            uni_requestPayment(RequestPaymentOptions(provider = "alipay", orderInfo = this.orderInfo, fail = fun(res: RequestPaymentFail){
                this.errorCode = res.errCode;
                this.complete = true;
            }
            , success = fun(res: RequestPaymentSuccess){
                console.log(JSON.stringify(res), " at pages/API/request-payment/request-payment.uvue:184");
                this.complete = true;
            }
            ));
        }
        ;
    }
    open lateinit var requestPayment: (e: PayItem) -> Unit;
    open lateinit var payAli: () -> Unit;
    open lateinit var payWX: () -> Unit;
    open lateinit var jest_pay: () -> Unit;
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
