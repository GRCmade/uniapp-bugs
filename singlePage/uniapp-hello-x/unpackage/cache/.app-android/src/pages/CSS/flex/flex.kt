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
open class GenPagesCSSFlexFlex : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _cache = this.`$`.renderCache;
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("flex-grow" to "1"))), utsArrayOf(
                createElementVNode("view", null, utsArrayOf(
                    createElementVNode("text", null, "flex: 0"),
                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "250px", "height" to "150px", "background-color" to "gray", "flex-direction" to "row"))), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "common", "style" to normalizeStyle(utsMapOf("min-width" to "25px", "flex" to "0"))), null, 4),
                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "50px", "height" to "50px", "background-color" to "green"))), null, 4),
                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "50px", "height" to "50px", "background-color" to "blue"))), null, 4)
                    ), 4)
                )),
                createElementVNode("view", null, utsArrayOf(
                    createElementVNode("text", null, "flex: 1"),
                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "250px", "height" to "150px", "background-color" to "gray", "flex-direction" to "row"))), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "common", "style" to normalizeStyle(utsMapOf("flex" to "1"))), null, 4),
                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "50px", "height" to "50px", "background-color" to "green"))), null, 4),
                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "50px", "height" to "50px", "background-color" to "blue"))), null, 4)
                    ), 4)
                )),
                createElementVNode("view", null, utsArrayOf(
                    createElementVNode("text", null, "flex: auto"),
                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "250px", "height" to "150px", "background-color" to "gray", "flex-direction" to "row"))), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "common", "style" to normalizeStyle(utsMapOf("flex" to "auto"))), null, 4),
                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "50px", "height" to "50px", "background-color" to "green"))), null, 4),
                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "50px", "height" to "50px", "background-color" to "blue"))), null, 4)
                    ), 4)
                )),
                createElementVNode("view", null, utsArrayOf(
                    createElementVNode("text", null, "flex: none"),
                    createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "250px", "height" to "150px", "background-color" to "gray", "flex-direction" to "row"))), utsArrayOf(
                        createElementVNode("view", utsMapOf("class" to "common", "style" to normalizeStyle(utsMapOf("flex" to "none"))), null, 4),
                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "50px", "height" to "50px", "background-color" to "green"))), null, 4),
                        createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "50px", "height" to "50px", "background-color" to "blue"))), null, 4)
                    ), 4)
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
                return utsMapOf("common" to padStyleMapOf(utsMapOf("width" to 50, "height" to 50, "backgroundColor" to "#FF0000")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}