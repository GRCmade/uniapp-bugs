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
import io.dcloud.uniapp.extapi.createRewardedVideoAd as uni_createRewardedVideoAd;
import io.dcloud.uniapp.extapi.showToast as uni_showToast;
open class GenPagesAPIRewardedVideoAdRewardedVideoAd : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onReady(fun() {
            this.loadAd();
        }
        , __ins);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_page_head, utsMapOf("title" to "激励视频广告")),
            createElementVNode("button", utsMapOf("type" to _ctx.btnType, "style" to normalizeStyle(utsMapOf("margin" to "10px")), "disabled" to _ctx.btnDisable, "onClick" to fun(){
                _ctx.showAd();
            }
            ), toDisplayString(_ctx.btnText), 13, utsArrayOf(
                "type",
                "disabled",
                "onClick"
            ))
        ), 64);
    }
    open var btnText: String by `$data`;
    open var btnType: String by `$data`;
    open var btnDisable: Boolean by `$data`;
    open var rewardAd: RewardedVideoAd? by `$data`;
    open var isAdLoadSuccess: Boolean by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("btnText" to "", "btnType" to "primary", "btnDisable" to false, "rewardAd" to null as RewardedVideoAd?, "isAdLoadSuccess" to false);
    }
    override fun `$initMethods`() {
        this.loadAd = fun() {
            if (this.btnDisable) {
                return;
            }
            this.btnDisable = true;
            this.btnText = "正在加载广告";
            this.btnType = "primary";
            if (this.rewardAd == null) {
                this.rewardAd = uni_createRewardedVideoAd(CreateRewardedVideoAdOptions(adpid = "1507000689"));
                this.rewardAd!!.onError(fun(_){
                    this.btnType = "warn";
                    this.btnText = "广告加载失败，点击重试";
                    this.btnDisable = false;
                }
                );
                this.rewardAd!!.onLoad(fun(_){
                    this.btnType = "primary";
                    this.btnText = "广告加载成功，点击观看";
                    this.btnDisable = false;
                    this.isAdLoadSuccess = true;
                }
                );
                this.rewardAd!!.onClose(fun(e){
                    this.isAdLoadSuccess = false;
                    uni_showToast(ShowToastOptions(title = "激励视频" + (if (e.isEnded) {
                        "";
                    } else {
                        "未";
                    }
                    ) + "播放完毕", position = "bottom"));
                    this.loadAd();
                }
                );
            }
            this.rewardAd!!.load();
        }
        ;
        this.showAd = fun() {
            if (this.isAdLoadSuccess) {
                this.rewardAd!!.show();
            } else {
                this.loadAd();
            }
        }
        ;
    }
    open lateinit var loadAd: () -> Unit;
    open lateinit var showAd: () -> Unit;
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