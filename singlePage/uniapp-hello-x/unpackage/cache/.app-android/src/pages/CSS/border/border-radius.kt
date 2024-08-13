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
open class GenPagesCSSBorderBorderRadius : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _cache = this.`$`.renderCache;
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-grow" to "1"))), utsArrayOf(
                createElementVNode("view", null, utsArrayOf(
                    createElementVNode("text", null, "border-radius: 10px"),
                    createElementVNode("view", utsMapOf("class" to "common", "style" to normalizeStyle(utsMapOf("border-radius" to "10px"))), null, 4)
                )),
                createElementVNode("view", null, utsArrayOf(
                    createElementVNode("text", null, "border-top-left-radius: 10px"),
                    createElementVNode("view", utsMapOf("class" to "common", "style" to normalizeStyle(utsMapOf("border-top-left-radius" to "10px"))), null, 4)
                )),
                createElementVNode("view", null, utsArrayOf(
                    createElementVNode("text", null, "border-top-right-radius: 10px"),
                    createElementVNode("view", utsMapOf("class" to "common", "style" to normalizeStyle(utsMapOf("border-top-right-radius" to "10px"))), null, 4)
                )),
                createElementVNode("view", null, utsArrayOf(
                    createElementVNode("text", null, "border-bottom-left-radius: 10px"),
                    createElementVNode("view", utsMapOf("class" to "common", "style" to normalizeStyle(utsMapOf("border-bottom-left-radius" to "10px"))), null, 4)
                )),
                createElementVNode("view", null, utsArrayOf(
                    createElementVNode("text", null, "border-bottom-right-radius: 10px"),
                    createElementVNode("view", utsMapOf("class" to "common", "style" to normalizeStyle(utsMapOf("border-bottom-right-radius" to "10px"))), null, 4)
                ))
            ), 4)
        ), 4);
    }
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
                return utsMapOf("common" to padStyleMapOf(utsMapOf("width" to 250, "height" to 250, "backgroundColor" to "#808080")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
