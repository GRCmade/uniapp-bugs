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
import io.dcloud.uniapp.extapi.getLaunchOptionsSync as uni_getLaunchOptionsSync;
open class GenPagesAPIGetLaunchOptionsSyncGetLaunchOptionsSync : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        val _component_page_head = resolveEasyComponent("page-head", GenComponentsPageHeadPageHeadClass);
        return createElementVNode(Fragment, null, utsArrayOf(
            createVNode(_component_page_head, utsMapOf("title" to "getLaunchOptionsSync")),
            createElementVNode("view", utsMapOf("class" to "uni-padding-wrap"), utsArrayOf(
                createElementVNode("button", utsMapOf("onClick" to _ctx.getLaunchOptionsSync), "getLaunchOptionsSync", 8, utsArrayOf(
                    "onClick"
                )),
                if (_ctx.launchOptionsPath.length > 0) {
                    createElementVNode("view", utsMapOf("key" to 0, "class" to "uni-common-mt"), utsArrayOf(
                        createElementVNode("text", null, "应用启动路径："),
                        createElementVNode("text", utsMapOf("style" to normalizeStyle(utsMapOf("margin-top" to "5px"))), toDisplayString(_ctx.launchOptionsPath), 5)
                    ));
                } else {
                    createCommentVNode("v-if", true);
                }
            ))
        ), 64);
    }
    open var checked: Boolean by `$data`;
    open var homePagePath: String by `$data`;
    open var launchOptionsPath: String by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("checked" to false, "homePagePath" to "pages/tabBar/component", "launchOptionsPath" to "");
    }
    override fun `$initMethods`() {
        this.getLaunchOptionsSync = fun() {
            val launchOptions = uni_getLaunchOptionsSync();
            this.launchOptionsPath = launchOptions.path;
            if (launchOptions.path == this.homePagePath) {
                this.checked = true;
            }
        }
        ;
    }
    open lateinit var getLaunchOptionsSync: () -> Unit;
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
