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
import io.dcloud.uniapp.extapi.createSelectorQuery as uni_createSelectorQuery;
open class GenUniModulesUniRecycleViewComponentsUniRecycleItemUniRecycleItem : VueComponent {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {
        onMounted(fun() {
            uni_createSelectorQuery().`in`(this).select(".item-container").boundingClientRect().exec(fun(ret){
                this.setCachedSize(this.item, (ret[0] as NodeInfo).height!!);
            }
            );
        }
        , __ins);
    }
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("class" to "item-container"), utsArrayOf(
            renderSlot(_ctx.`$slots`, "default")
        ));
    }
    open var setCachedSize: (item: Any, size: Number) -> Unit by `$inject`;
    open var item: Any by `$props`;
    companion object {
        var name = "uni-recycle-item";
        val styles: Map<String, Map<String, Map<String, Any>>>
            get() {
                return normalizeCssStyles(utsArrayOf());
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf("setCachedSize" to utsMapOf("type" to "Function"));
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf("item" to utsMapOf("required" to true)));
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
