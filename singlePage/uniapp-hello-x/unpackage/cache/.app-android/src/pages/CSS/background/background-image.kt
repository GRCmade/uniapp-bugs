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
open class GenPagesCSSBackgroundBackgroundImage : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("scroll-view", utsMapOf("style" to normalizeStyle(utsMapOf("flex" to "1"))), utsArrayOf(
            createElementVNode("view", null, utsArrayOf(
                createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("width" to "0px", "height" to "0px", "background-image" to "linear-gradient(to bottom,#f5f5f5,#eff2f5)"))), null, 4),
                createElementVNode("text", null, "不支持背景图片，仅支持linear-gradient方法"),
                createElementVNode(Fragment, null, RenderHelpers.renderList(_ctx.directionData, fun(direction, __key, __index, _cached): Any {
                    return createElementVNode("view", null, utsArrayOf(
                        createElementVNode("text", null, "background-image: linear-gradient(" + toDisplayString(direction) + ", red, yellow)", 1),
                        createElementVNode("view", utsMapOf("class" to "common", "style" to normalizeStyle(utsMapOf("background-image" to if (_ctx.backgroundSelect) {
                            "linear-gradient(" + direction + ", red, yellow)";
                        } else {
                            "";
                        }
                        ))), null, 4)
                    ));
                }
                ), 256)
            ))
        ), 4);
    }
    open var backgroundSelect: Boolean by `$data`;
    open var directionData: UTSArray<String> by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("backgroundSelect" to true, "directionData" to utsArrayOf(
            "to right",
            "to left",
            "to bottom",
            "to top",
            "to bottom left",
            "to bottom right",
            "to top left",
            "to top right"
        ));
    }
    override fun `$initMethods`() {
        this.updateBackgroundSelect = fun() {
            this.backgroundSelect = !this.backgroundSelect;
        }
        ;
    }
    open lateinit var updateBackgroundSelect: () -> Unit;
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
                return utsMapOf("common" to padStyleMapOf(utsMapOf("width" to 250, "height" to 250)));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}