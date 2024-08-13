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
open class GenPagesCSSBorderDynamicBorder : BasePage {
    constructor(__ins: ComponentInternalInstance) : super(__ins) {}
    @Suppress("UNUSED_PARAMETER", "UNUSED_VARIABLE")
    override fun `$render`(): Any? {
        val _ctx = this;
        val _cache = this.`$`.renderCache;
        return createElementVNode("view", utsMapOf("style" to normalizeStyle(utsMapOf("margin" to "15px", "border-radius" to "10px", "background-color" to "white"))), utsArrayOf(
            createElementVNode(Fragment, null, RenderHelpers.renderList(10, fun(index, __key, __index, _cached): Any {
                return createElementVNode("view", utsMapOf("key" to index, "class" to normalizeClass((if (index < 9) {
                    "bb1";
                } else {
                    "";
                }
                ) + " " + (if (_ctx.currentIndex == 0) {
                    "btlr10 btrr10";
                } else {
                    if (_ctx.currentIndex == 9) {
                        "bblr10 bbrr10";
                    } else {
                        "";
                    }
                    ;
                }
                )), "style" to normalizeStyle(utsArrayOf(
                    utsMapOf("flex-direction" to "row", "align-items" to "center", "padding" to "15px"),
                    if (index == _ctx.currentIndex) {
                        "background-color :#57BE6A;";
                    } else {
                        "";
                    }
                )), "onClick" to fun(){
                    _ctx.currentIndex = index;
                }
                ), utsArrayOf(
                    createElementVNode("view", null, utsArrayOf(
                        createElementVNode("text", utsMapOf("style" to normalizeStyle(utsArrayOf(
                            utsMapOf("font-size" to "14px"),
                            if (index == _ctx.currentIndex) {
                                "color: #FFFFFF;";
                            } else {
                                "";
                            }
                        ))), toDisplayString(index), 5)
                    ))
                ), 14, utsArrayOf(
                    "onClick"
                ));
            }
            ), 64)
        ), 4);
    }
    open var currentIndex: Number by `$data`;
    @Suppress("USELESS_CAST")
    override fun data(): Map<String, Any?> {
        return utsMapOf("currentIndex" to 1);
    }
    override fun `$initMethods`() {
        this.changeIndex = fun(index: Number) {
            this.currentIndex = index;
        }
        ;
    }
    open lateinit var changeIndex: (index: Number) -> Unit;
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
                return utsMapOf("bb1" to padStyleMapOf(utsMapOf("borderBottomWidth" to "1rpx", "borderBottomStyle" to "solid", "borderBottomColor" to "#EEEEEE")), "btlr10" to padStyleMapOf(utsMapOf("borderTopLeftRadius" to "10rpx")), "btrr10" to padStyleMapOf(utsMapOf("borderTopRightRadius" to "10rpx")), "bblr10" to padStyleMapOf(utsMapOf("borderBottomLeftRadius" to "10rpx")), "bbrr10" to padStyleMapOf(utsMapOf("borderBottomRightRadius" to "10rpx")));
            }
        var inheritAttrs = true;
        var inject: Map<String, Map<String, Any?>> = utsMapOf();
        var emits: Map<String, Any?> = utsMapOf();
        var props = normalizePropsOptions(utsMapOf());
        var propsNeedCastKeys: UTSArray<String> = utsArrayOf();
        var components: Map<String, CreateVueComponent> = utsMapOf();
    }
}
